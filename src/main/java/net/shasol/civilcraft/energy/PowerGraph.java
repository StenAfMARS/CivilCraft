package net.shasol.civilcraft.energy;

import net.minecraft.core.BlockPos;
import java.util.*;

public class PowerGraph {
    public static class Node {
        public final IEnergyNode tile;
        public final BlockPos pos;
        public Node(IEnergyNode t, BlockPos p) { tile = t; pos = p; }
        @Override public boolean equals(Object o) {
            return o instanceof Node n && n.pos.equals(pos);
        }
        @Override public int hashCode() { return pos.hashCode(); }
    }

    public static class Edge {
        public final Node from, to;
        public final double resistance;
        public Edge(Node f, Node t, double r) { from = f; to = t; resistance = r; }
    }

    private final Map<Node,List<Edge>> adj = new HashMap<>();
    public void addNode(Node n) { adj.putIfAbsent(n, new ArrayList<>()); }
    public void addEdge(Node a, Node b, double resistance) {
        adj.get(a).add(new Edge(a,b,resistance));
        adj.get(b).add(new Edge(b,a,resistance));
    }
    public Collection<Node> nodes() { return adj.keySet(); }
    public List<Edge> edges(Node n) { return adj.getOrDefault(n, List.of()); }
}
