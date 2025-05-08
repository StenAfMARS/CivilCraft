package net.shasol.civilcraft.energy;

public interface IEnergyNode {
    /**
     * Called every tick to allow the node to inject or consume power.
     */
    void tick(EnergyNetwork network);

    /**
     * Resistance (Ω) of the node (for wires, transformers, etc).
     */
    double getResistance();

    /**
     * Returns the maximum current (in amps) the node can handle.
     */
    double getMaxCurrent();

    /**
     * Is this node a source (e.g., generator)?
     */
    default boolean isSource() { return false; }

    /**
     * Is this node a sink (e.g., consumer)?
     */
    default boolean isSink() { return false; }
}
