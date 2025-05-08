package net.shasol.civilcraft.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.shasol.civilcraft.energy.IEnergyNode;
import net.shasol.civilcraft.energy.ConductorProperties;
import net.shasol.civilcraft.energy.EnergyNetwork;

public class CopperWireBlock extends Block implements IEnergyNode {

    private static final ConductorProperties PROPERTIES = new ConductorProperties(
            0.017, // ohm/m (copper)
            100.0, // max amps
            10.0   // mm²
    );

    public CopperWireBlock() {
        super(BlockBehaviour.Properties.of().strength(0.5f));
    }

    @Override
    public void tick(EnergyNetwork network) {
        // Conductors don't actively do much in tick — may handle overheating here
    }

    @Override
    public double getResistance() {
        return PROPERTIES.resistancePerMeter; // Length-based calc could be added later
    }

    @Override
    public double getMaxCurrent() {
        return PROPERTIES.maxCurrent;
    }

    @Override
    public boolean isSource() {
        return false;
    }

    @Override
    public boolean isSink() {
        return false;
    }
}
