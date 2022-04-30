package dev.intelligentcreations.mudrock.event.listeners;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface BlockBreakListener extends MudrockEventListener
{
    void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player);
}
