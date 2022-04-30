package dev.intelligentcreations.mudrock.event.listeners;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Creates an event listener that listens to the action of stepping on specific blocks.
 * Implement this class to add your functions.
 */
public interface BlockSteppedOnListener extends MudrockEventListener
{
    void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity);
}
