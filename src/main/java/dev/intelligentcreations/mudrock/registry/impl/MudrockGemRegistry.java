package dev.intelligentcreations.mudrock.registry.impl;

import dev.intelligentcreations.mudrock.registry.MudrockRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class MudrockGemRegistry extends MudrockRegistry {
    private final String namespace;
    private final String name;
    private final ItemGroup group;
    private List<Identifier> itemIdentifierList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

    public MudrockGemRegistry(String namespace, String name, ItemGroup group) {
        super(namespace, name, group);
        this.namespace = namespace;
        this.name = name;
        this.group = group;
    }
}
