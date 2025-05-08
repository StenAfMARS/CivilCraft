package net.shasol.civilcraft.block;

import com.google.common.base.Supplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shasol.civilcraft.CivilCraft;
import net.shasol.civilcraft.block.custom.CopperWireBlock;

public class Modblocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CivilCraft.MODID);

    public static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static final DeferredBlock<Block> COPPER_WIRE_BLOCK =
            registerBlock("copper_wire_block", () -> new Block(BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops()));

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
