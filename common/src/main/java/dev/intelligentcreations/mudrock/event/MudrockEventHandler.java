package dev.intelligentcreations.mudrock.event;

import dev.intelligentcreations.mudrock.Mudrock;
import dev.intelligentcreations.mudrock.event.listeners.MudrockEventListener;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Event handler for all (both-sided) Mudrock events.
 */
public class MudrockEventHandler
{
    /**
     * The list of listeners.
     * To get the list of listeners, use the getter.
     */
    private static final List<MudrockEventListener> listeners = new ArrayList<>();

    /**
     * Register a listener.
     * The listener must implement one of the interfaces that extends {@link MudrockEventListener}.
     */
    public static <T extends MudrockEventListener> void registerListener(Class<T> listenerClass)
    {
        try
        {
            T listener = listenerClass.getDeclaredConstructor().newInstance();
            listeners.add(listener);
            Mudrock.LOGGER.info("Registered listener " + listenerClass.getName());
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
            throw new RuntimeException("No valid constructor found for: " + listenerClass.getName());
        }
    }

    /**
     * Get the number of the loaded listeners.
     */
    public static int getListenerCount()
    {
        return getListeners().size();
    }

    /**
     * Get the list of the loaded listeners.
     */
    public static List<MudrockEventListener> getListeners() {
        return listeners;
    }
}
