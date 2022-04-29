package dev.intelligentcreations.mudrock;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;

public class Mudrock implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("Mudrock");

    @Override
    public void onInitialize() {
        LOGGER.info("Mudrock is getting ready...");
    }
}