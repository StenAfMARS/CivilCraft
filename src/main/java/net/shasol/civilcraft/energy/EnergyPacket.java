package net.shasol.civilcraft.energy;

public class EnergyPacket {
    public final double voltage; // volts
    public final double current; // amps

    public EnergyPacket(double voltage, double current) {
        this.voltage = voltage;
        this.current = current;
    }

    public double getPowerWatts() {
        return voltage * current;
    }

    public double getEnergyPerTick() {
        return getPowerWatts() / 20.0; // W = J/s, so per tick
    }
}
