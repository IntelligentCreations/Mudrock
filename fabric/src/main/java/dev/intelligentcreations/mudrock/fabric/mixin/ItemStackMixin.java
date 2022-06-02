package dev.intelligentcreations.mudrock.fabric.mixin;

import dev.intelligentcreations.mudrock.event.MudrockEventHandler;
import dev.intelligentcreations.mudrock.event.listeners.ItemCraftListener;
import dev.intelligentcreations.mudrock.event.listeners.ItemUseListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin
{
    // In Fabric, we use Mixin
    @Inject(method = "use", at = @At("RETURN"), cancellable = true)
    public void onUse(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir)
    {
        if (!MudrockEventHandler.getListeners().isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.getListeners().size(); ++i)
            {
                if (MudrockEventHandler.getListeners().get(i) instanceof ItemUseListener listener)
                {
                    cir.setReturnValue(listener.onItemUse(world, user, hand));
                }
            }
        }
    }

    @Inject(method = "onCraft", at = @At("RETURN"))
    public void onOnCraft(World world, PlayerEntity player, int amount, CallbackInfo ci)
    {
        if (!MudrockEventHandler.getListeners().isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.getListeners().size(); ++i)
            {
                if (MudrockEventHandler.getListeners().get(i) instanceof ItemCraftListener listener)
                {
                    listener.onCraft(world, player, amount);
                }
            }
        }
    }
}
