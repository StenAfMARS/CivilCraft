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

    //Simple Mod Items
    public static final DeferredItem<Item> COBBER_WIRE_COIL = ITEMS.registerSimpleItem("cobber_wire_coil");
    public static final DeferredItem<Item> ALUMINIUM_WIRE_COIL = ITEMS.registerSimpleItem("aluminium_wire_coil");
    public static final DeferredItem<Item> ALUMINIUM_FINE_WIRE_COIL = ITEMS.registerSimpleItem("aluminium_fine_wire_coil");
    public static final DeferredItem<Item> COBBER_FINE_WIRE_COIL = ITEMS.registerSimpleItem("cobber_fine_wire_coil");



    //Ore drops
    public static final DeferredItem<Item> RAW_BAUXITE_ORE = ITEMS.registerSimpleItem("raw_bauxite_ore");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }
}
