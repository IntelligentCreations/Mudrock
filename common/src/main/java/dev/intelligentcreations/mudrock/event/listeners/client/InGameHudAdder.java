package dev.intelligentcreations.mudrock.event.listeners.client;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

/**
 * Creates a client-sided event listener that is able to add new things to the in-game HUD.
 * Implement this class to add your functions.
 */
public interface InGameHudAdder extends MudrockClientEventListener
{
    void onHudRender(MatrixStack matrices, float tickDelta);
}
