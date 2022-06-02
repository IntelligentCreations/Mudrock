package dev.intelligentcreations.mudrock.forge.event;

import dev.intelligentcreations.mudrock.Mudrock;
import dev.intelligentcreations.mudrock.event.MudrockEventHandler;
import dev.intelligentcreations.mudrock.event.listeners.BlockBreakListener;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mudrock.MOD_ID)
public class BlockEvent
{
    @SubscribeEvent
    public static void onBreak(net.minecraftforge.event.world.BlockEvent.BreakEvent event)
    {
        if (!MudrockEventHandler.getListeners().isEmpty())
        {
            for (int i = 0; i < MudrockEventHandler.getListeners().size(); ++i)
            {
                if (MudrockEventHandler.getListeners().get(i) instanceof BlockBreakListener listener)
                {
                    listener.onBreak(event.getPlayer().getWorld(), event.getPos(), event.getState(), event.getPlayer());
                }
            }
        }
    }
}
