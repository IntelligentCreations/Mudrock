package dev.intelligentcreations.mudrock.mixin;

import dev.intelligentcreations.mudrock.event.MudrockEventHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin
{
    @Inject(method = "use", at = @At("RETURN"), cancellable = true)
    public void onUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir)
    {
        if (!MudrockEventHandler.itemUseListeners.isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.itemUseListeners.size(); ++i)
            {
                MudrockEventHandler.itemUseListeners.get(i).onItemUse(world, user, hand);
                cir.setReturnValue(TypedActionResult.success(user.getMainHandStack()));
            }
        }
    }
}
