package dev.intelligentcreations.mudrock.event.listeners.client;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public interface InGameHudAdder extends MudrockClientEventListener
{
    Identifier getTexture();

    void onHudRender(MatrixStack matrices, float tickDelta);
}
