package dev.intelligentcreations.mudrock.event.listeners;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public interface ItemUseListener
{
    void onItemUse(World world, PlayerEntity user, Hand hand);
}
