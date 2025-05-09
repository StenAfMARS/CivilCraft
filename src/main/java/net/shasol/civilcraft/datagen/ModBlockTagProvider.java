package net.shasol.civilcraft.datagen;

import net.neoforged.fml.common.Mod;
import net.shasol.civilcraft.CivilCraft;
import net.shasol.civilcraft.block.Modblocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CivilCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Modblocks.BAUXITE_ORE_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Modblocks.BAUXITE_ORE_BLOCK.get());
    }
}
