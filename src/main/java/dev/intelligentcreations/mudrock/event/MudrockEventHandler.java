package dev.intelligentcreations.mudrock.event;

import dev.intelligentcreations.mudrock.event.listeners.ItemUseListener;

import java.util.ArrayList;
import java.util.List;

public class MudrockEventHandler
{
    public static List<ItemUseListener> itemUseListeners = new ArrayList<>();

    public void registerListener(ItemUseListener listener)
    {
        itemUseListeners.add(listener);
    }
}
