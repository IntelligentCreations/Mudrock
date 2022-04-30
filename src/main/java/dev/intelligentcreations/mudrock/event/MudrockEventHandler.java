package dev.intelligentcreations.mudrock.event;

import dev.intelligentcreations.mudrock.event.listeners.BlockSteppedOnListener;
import dev.intelligentcreations.mudrock.event.listeners.ItemUseListener;

import java.util.ArrayList;
import java.util.List;

public class MudrockEventHandler
{
    public static List<ItemUseListener> itemUseListeners = new ArrayList<>();
    public static List<BlockSteppedOnListener> blockSteppedOnListeners = new ArrayList<>();

    public void registerListener(ItemUseListener listener)
    {
        itemUseListeners.add(listener);
    }

    public void registerListener(BlockSteppedOnListener listener)
    {
        blockSteppedOnListeners.add(listener);
    }

    public static int getListenerCount()
    {
        return itemUseListeners.size() + blockSteppedOnListeners.size();
    }
}
