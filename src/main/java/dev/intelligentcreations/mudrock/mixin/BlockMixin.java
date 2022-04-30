package dev.intelligentcreations.mudrock.mixin;

import dev.intelligentcreations.mudrock.event.MudrockEventHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin
{
    @Inject(method = "onSteppedOn", at = @At("RETURN"))
    public void onOnSteppedOn(World world, BlockPos pos, BlockState state, Entity entity, CallbackInfo ci)
    {
        if (!MudrockEventHandler.blockSteppedOnListeners.isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.blockSteppedOnListeners.size(); ++i)
            {
                MudrockEventHandler.blockSteppedOnListeners.get(i).onSteppedOn(world, pos, state, entity);
            }
        }
    }
}
