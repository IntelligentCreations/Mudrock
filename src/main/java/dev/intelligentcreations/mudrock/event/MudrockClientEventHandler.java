package dev.intelligentcreations.mudrock.event;

import dev.intelligentcreations.mudrock.Mudrock;
import dev.intelligentcreations.mudrock.event.listeners.client.MudrockClientEventListener;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Event handler for all client-sided Mudrock events.
 */
@Environment(EnvType.CLIENT)
public class MudrockClientEventHandler
{
    /**
     * The list of client-sided listeners.
     * To get the list of listeners, use the getter.
     */
    private static final List<MudrockClientEventListener> listeners = new ArrayList<>();

    /**
     * Register a client-sided listener.
     * The listener must implement one of the interfaces that extends {@link MudrockClientEventListener}.
     */
    public static <T extends MudrockClientEventListener> void registerListener(Class<T> listenerClass)
    {
        try
        {
            T listener = listenerClass.getDeclaredConstructor().newInstance();
            listeners.add(listener);
            Mudrock.LOGGER.info("Registered client-sided listener " + listenerClass.getName());
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
            throw new RuntimeException("No valid constructor found for: " + listenerClass.getName());
        }
    }

    /**
     * Get the number of the loaded client-sided listeners.
     */
    public static int getListenerCount()
    {
        return getListeners().size();
    }

    /**
     * Get the list of the loaded listeners.
     */
    public static List<MudrockClientEventListener> getListeners() {
        return listeners;
    }
}
