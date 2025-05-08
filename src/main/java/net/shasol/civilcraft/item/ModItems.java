package net.shasol.civilcraft.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shasol.civilcraft.CivilCraft;
import net.shasol.civilcraft.block.Modblocks;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CivilCraft.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
