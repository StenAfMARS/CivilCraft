package net.shasol.civilcraft.core.block;

import com.google.common.base.Supplier;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shasol.civilcraft.core.CivilCraftCore;

public class Modblocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CivilCraftCore.MODID);

    public static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
