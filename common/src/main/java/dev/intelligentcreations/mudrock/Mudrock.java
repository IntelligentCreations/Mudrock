package dev.intelligentcreations.mudrock;

import dev.intelligentcreations.mudrock.event.MudrockEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mudrock
{
    public static final String MOD_ID = "mudrock";
    public static final Logger LOGGER = LoggerFactory.getLogger("Mudrock");

    public static void init()
    {
        LOGGER.info("Mudrock is getting ready...");
        LOGGER.info("Loaded " + MudrockEventHandler.getListenerCount() + " event listener(s).");
        LOGGER.info("Initialized.");
    }
}
