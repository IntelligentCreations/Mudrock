package dev.intelligentcreations.mudrock.fabric;

import dev.intelligentcreations.mudrock.Mudrock;
import net.fabricmc.api.ModInitializer;

public class MudrockFabric implements ModInitializer
{
    @Override
    public void onInitialize()
    {
        Mudrock.init();
    }
}
