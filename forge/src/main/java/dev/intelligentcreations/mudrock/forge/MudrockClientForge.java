package dev.intelligentcreations.mudrock.forge;

import dev.intelligentcreations.mudrock.Mudrock;
import dev.intelligentcreations.mudrock.MudrockClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Mudrock.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MudrockClientForge
{
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        MudrockClient.init();
    }
}
