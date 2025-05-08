package net.shasol.civilcraft.energy;

import java.util.Set;
import java.util.HashSet;

public class EnergyNetwork {
    private final Set<IEnergyNode> nodes = new HashSet<>();

    public void addNode(IEnergyNode node) {
        nodes.add(node);
    }

    public void tick() {
        for (IEnergyNode node : nodes) {
            node.tick(this);
        }
        // TODO: Simulate current distribution & voltage drops
    }

    public Set<IEnergyNode> getNodes() {
        return nodes;
    }
}
