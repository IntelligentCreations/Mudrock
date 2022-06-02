package dev.intelligentcreations.mudrock.forge.mixin;

import dev.intelligentcreations.mudrock.event.MudrockEventHandler;
import dev.intelligentcreations.mudrock.event.listeners.BlockPlaceListener;
import dev.intelligentcreations.mudrock.event.listeners.BlockSteppedOnListener;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin
{
    // fk u forge
    // Here we have to use Mixin since Forge does not provide an event that is fired to listen to stepping on blocks (or they actually provided one, but I just can't find it)
    @Inject(method = "onSteppedOn", at = @At("RETURN"))
    public void onOnSteppedOn(World world, BlockPos pos, BlockState state, Entity entity, CallbackInfo ci)
    {
        if (!MudrockEventHandler.getListeners().isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.getListeners().size(); ++i)
            {
                if (MudrockEventHandler.getListeners().get(i) instanceof BlockSteppedOnListener listener)
                {
                    listener.onSteppedOn(world, pos, state, entity);
                }
            }
        }
    }

    @Inject(method = "onPlaced", at = @At("RETURN"))
    public void onOnPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack, CallbackInfo ci)
    {
        if (!MudrockEventHandler.getListeners().isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.getListeners().size(); ++i)
            {
                if (MudrockEventHandler.getListeners().get(i) instanceof BlockPlaceListener listener)
                {
                    listener.onPlaced(world, pos, state, placer, itemStack);
                }
            }
        }
    }
}
