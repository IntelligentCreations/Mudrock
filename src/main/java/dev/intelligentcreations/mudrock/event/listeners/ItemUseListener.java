package dev.intelligentcreations.mudrock.event.listeners;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * Creates an event listener that listens to the use of items.
 * Implement this class to add your functions.
 */
public interface ItemUseListener extends MudrockEventListener
{
    TypedActionResult<ItemStack> onItemUse(World world, PlayerEntity user, Hand hand);
}
