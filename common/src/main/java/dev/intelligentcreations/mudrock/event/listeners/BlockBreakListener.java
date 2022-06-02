package dev.intelligentcreations.mudrock.event.listeners;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Creates an event listener that listens to the break of blocks.
 * Implement this class to add your functions.
 */
public interface BlockBreakListener extends MudrockEventListener
{
    void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player);
}
