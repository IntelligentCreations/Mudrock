package dev.intelligentcreations.mudrock.fabric;

import dev.intelligentcreations.mudrock.MudrockClient;
import net.fabricmc.api.ClientModInitializer;

public class MudrockClientFabric implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        MudrockClient.init();
    }
}
