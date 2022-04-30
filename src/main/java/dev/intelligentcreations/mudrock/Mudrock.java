package dev.intelligentcreations.mudrock;

import dev.intelligentcreations.mudrock.event.MudrockEventHandler;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mudrock implements ModInitializer
{
    public static final Logger LOGGER = LoggerFactory.getLogger("Mudrock");

    @Override
    public void onInitialize()
    {
        LOGGER.info("Mudrock is getting ready...");
        LOGGER.info("Loaded " + MudrockEventHandler.getListenerCount() + " event listeners.");
        LOGGER.info("Initialized.");
    }
}
