package dev.intelligentcreations.mudrock.forge.event;

import dev.intelligentcreations.mudrock.Mudrock;
import dev.intelligentcreations.mudrock.event.MudrockEventHandler;
import dev.intelligentcreations.mudrock.event.listeners.ItemCraftListener;
import dev.intelligentcreations.mudrock.event.listeners.ItemUseListener;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mudrock.MOD_ID)
public class ItemEvent
{
    // In Forge, we use event bus
    @SubscribeEvent
    public static void onItemUse(PlayerInteractEvent.RightClickItem event)
    {
        if (!MudrockEventHandler.getListeners().isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.getListeners().size(); ++i)
            {
                if (MudrockEventHandler.getListeners().get(i) instanceof ItemUseListener listener)
                {
                    listener.onItemUse(event.getWorld(), event.getPlayer(), event.getHand());
                }
            }
        }
    }
    @SubscribeEvent
    public static void onItemCraft(PlayerEvent.ItemCraftedEvent event)
    {
        if (!MudrockEventHandler.getListeners().isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.getListeners().size(); ++i)
            {
                if (MudrockEventHandler.getListeners().get(i) instanceof ItemCraftListener listener)
                {
                    listener.onCraft(event.getPlayer().getWorld(), event.getPlayer(), event.getCrafting().getCount());
                }
            }
        }
    }
}
