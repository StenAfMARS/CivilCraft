package net.shasol.civilcraft.energy;

public class ConductorProperties {
    public final double resistancePerMeter; // ohms per meter
    public final double maxCurrent; // amps
    public final double crossSectionArea; // mm² or equivalent

    public ConductorProperties(double resistancePerMeter, double maxCurrent, double area) {
        this.resistancePerMeter = resistancePerMeter;
        this.maxCurrent = maxCurrent;
        this.crossSectionArea = area;
    }

    public double getTotalResistance(double length) {
        return resistancePerMeter * length;
    }
}
