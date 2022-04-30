package dev.intelligentcreations.mudrock;

import dev.intelligentcreations.mudrock.event.MudrockClientEventHandler;
import net.fabricmc.api.ClientModInitializer;

public class MudrockClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        Mudrock.LOGGER.info("Loaded " + MudrockClientEventHandler.getListenerCount() + " client listeners.");
    }
}
