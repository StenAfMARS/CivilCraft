package net.shasol.civilcraft.energy;

public interface IEnergyNode {
    /** Called once per tick; return the packet you wish to inject (source) or null. */
    default EnergyPacket tickEmit(EnergyNetwork network) { return null; }

    /** Called when this node receives power from the network. */
    default void receive(EnergyPacket packet) { }

    /** Resistance (Ω) of the node itself (e.g. transformer winding). */
    double getResistance();

    /** Maximum current (A) this node can handle. */
    double getMaxCurrent();

    /** True if this node can generate power. */
    default boolean isSource() { return false; }

    /** True if this node can consume power. */
    default boolean isSink() { return false; }
}
