package net.shasol.civilcraft.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CobberWireItem  extends Item {
    public CobberWireItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();

        if (!level.isClientSide()){

        }

        return super.useOn(pContext);
    }
}
