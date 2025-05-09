package net.shasol.civilcraft.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.shasol.civilcraft.block.Modblocks;
import net.shasol.civilcraft.item.ModItems;
import org.jetbrains.annotations.NotNull;


import java.util.Set;

public class ModBlockLootTableProvider  extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        this.add(Modblocks.BAUXITE_ORE_BLOCK.get(),
                block -> createOreDrop(Modblocks.BAUXITE_ORE_BLOCK.get(), ModItems.RAW_BAUXITE_ORE.get()));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return Modblocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
