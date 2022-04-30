package dev.intelligentcreations.mudrock.event.listeners;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * Creates an event listener that listens to the place of blocks.
 * Implement this class to add your functions.
 */
public interface BlockPlaceListener extends MudrockEventListener
{
    void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack);
}
