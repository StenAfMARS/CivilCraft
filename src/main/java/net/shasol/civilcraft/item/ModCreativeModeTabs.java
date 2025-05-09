package net.shasol.civilcraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shasol.civilcraft.CivilCraft;
import net.shasol.civilcraft.block.Modblocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CivilCraft.MODID);

    public static final Supplier<CreativeModeTab> CIVILCRAFT_CREATIVE_MODE_TAB =
            CREATIVE_MODE_TABS.register("black_opal_items_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.civilcraft.civilcraft_creative_tab"))
                    .icon(() -> new ItemStack(ModItems.ALUMINIUM_WIRE_COIL.get()))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ALUMINIUM_WIRE_COIL);
                        pOutput.accept(ModItems.COBBER_WIRE_COIL);
                        pOutput.accept(ModItems.RAW_BAUXITE_ORE);
                        pOutput.accept(Modblocks.BAUXITE_ORE_BLOCK);


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
