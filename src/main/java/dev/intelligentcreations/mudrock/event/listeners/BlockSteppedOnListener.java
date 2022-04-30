package dev.intelligentcreations.mudrock.event.listeners;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface BlockSteppedOnListener
{
    void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity);
}
