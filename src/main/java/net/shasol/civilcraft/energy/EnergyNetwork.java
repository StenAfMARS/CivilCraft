package net.shasol.civilcraft.energy;

import java.util.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class EnergyNetwork {
    private final Set<IEnergyNode> nodes = new HashSet<>();
    private final Map<IEnergyNode, BlockPos> positions = new HashMap<>();

    private final ConductorProperties wireProps;

    public EnergyNetwork(ConductorProperties wireProps) {
        this.wireProps = wireProps;
    }

    public void addNode(IEnergyNode node, BlockPos pos) {
        nodes.add(node); positions.put(node, pos);
    }

    public void tick(Level level) {
        // 1️⃣ Build graph
        PowerGraph graph = new PowerGraph();
        Map<IEnergyNode,PowerGraph.Node> map = new HashMap<>();
        for(var n: nodes) {
            var pgNode = new PowerGraph.Node(n, positions.get(n));
            graph.addNode(pgNode);
            map.put(n, pgNode);
        }
        // Build edges using real conductor resistance:
        for (PowerGraph.Node a : graph.nodes()) {
            for (PowerGraph.Node b : graph.nodes()) {
                if (a.equals(b)) continue;
                // block-distance (in meters if 1 block = 1 m)
                double distance = a.pos.distSqr(b.pos);
                // actual resistance over that length:
                double R = wireProps.getTotalResistance(distance);
                graph.addEdge(a, b, R);
            }
        }

        // Collect sources & sinks
        List<PowerGraph.Node> sources = new ArrayList<>();
        List<PowerGraph.Node> sinks   = new ArrayList<>();
        for(var pg: map.values()){
            if(pg.tile.isSource()) sources.add(pg);
            if(pg.tile.isSink())   sinks.add(pg);
        }

        // Route each source→sink
        for(var src: sources) {
            EnergyPacket emit = src.tile.tickEmit(this);
            if(emit==null) continue;
            for(var dst: sinks) {
                var path = PowerRouter.route(graph, src, dst);
                double Rtot = path.stream().mapToDouble(e->e.resistance).sum();
                double I = emit.current;
                double Vdrop = I * (Rtot + dst.tile.getResistance());
                double Vdel = emit.voltage - Vdrop;
                if(Vdel>0) {
                    dst.tile.receive(new EnergyPacket(Vdel, I));
                }
            }
        }
    }
}
