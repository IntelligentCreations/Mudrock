package dev.intelligentcreations.mudrock.event.listeners;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface ItemCraftListener extends MudrockEventListener
{
    void onCraft(World world, PlayerEntity player, int amount);
}
