package net.shasol.civilcraft.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.shasol.civilcraft.CivilCraft;
import net.shasol.civilcraft.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CivilCraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_BAUXITE_ORE.get());
        basicItem(ModItems.COBBER_WIRE_COIL.get());
        basicItem(ModItems.COBBER_FINE_WIRE_COIL.get());
        basicItem(ModItems.ALUMINIUM_WIRE_COIL.get());
        basicItem(ModItems.ALUMINIUM_FINE_WIRE_COIL.get());


    }


}