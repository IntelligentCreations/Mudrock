package dev.intelligentcreations.mudrock.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.intelligentcreations.mudrock.Mudrock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Mudrock.MOD_ID)
public class MudrockForge
{
    public MudrockForge()
    {
        EventBuses.registerModEventBus(Mudrock.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Mudrock.init();
    }
}
