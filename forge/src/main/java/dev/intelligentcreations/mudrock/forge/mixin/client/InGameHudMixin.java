package dev.intelligentcreations.mudrock.forge.mixin.client;

import dev.intelligentcreations.mudrock.event.MudrockClientEventHandler;
import dev.intelligentcreations.mudrock.event.listeners.client.InGameHudAdder;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Inject(method = "render", at = @At("RETURN"))
    public void onRender(MatrixStack matrices, float tickDelta, CallbackInfo ci)
    {
        if (!MudrockClientEventHandler.getListeners().isEmpty())
        {
            for (int i = 0; i < MudrockClientEventHandler.getListeners().size(); ++i)
            {
                if (MudrockClientEventHandler.getListeners().get(i) instanceof InGameHudAdder listener)
                {
                    listener.onHudRender(matrices, tickDelta);
                }
            }
        }
    }
}
