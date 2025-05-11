package net.shasol.civilcraft.block;

import com.google.common.base.Supplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shasol.civilcraft.CivilCraft;
import net.shasol.civilcraft.item.ModItems;

public class Modblocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(CivilCraft.MODID);

    public static final DeferredBlock<Block> BAUXITE_ORE_BLOCK =
            registerBlock("bauxite_ore_block", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

//    public static final DeferredBlock<Block> COBALT_ORE_BLOCK =
//            registerBlock("cobalt_ore_block", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
//
//    public static final DeferredBlock<Block> NICKEL_ORE_BLOCK =
//            registerBlock("nickel_ore_block", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
//
//    public static final DeferredBlock<Block> REO_ORE_BLOCK =
//            registerBlock("reo_ore_block", () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static <T extends Block>DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
