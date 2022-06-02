package dev.intelligentcreations.mudrock;

import dev.intelligentcreations.mudrock.event.MudrockClientEventHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class MudrockClient
{
    public static final Logger LOGGER = LoggerFactory.getLogger("Mudrock Client");

    public static void init()
    {
        LOGGER.info("Loaded " + MudrockClientEventHandler.getListenerCount() + " client-sided event listener(s).");
    }
}
