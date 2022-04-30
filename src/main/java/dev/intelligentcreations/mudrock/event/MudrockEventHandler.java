package dev.intelligentcreations.mudrock.event;

import dev.intelligentcreations.mudrock.event.listeners.MudrockEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Event handler for all Mudrock events.
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
    public void registerListener(MudrockEventListener listener)
    {
        listeners.add(listener);
    }

    /**
     * Get the number of the loaded listeners.
     */
    public static int getListenerCount()
    {
        return listeners.size();
    }

    /**
     * Get the list of the loaded listeners.
     */
    public static List<MudrockEventListener> getListeners() {
        return listeners;
    }
}
