package dev.intelligentcreations.mudrock.registry;

import dev.intelligentcreations.mudrock.registry.impl.MudrockGemRegistry;
import dev.intelligentcreations.mudrock.registry.impl.MudrockMetalRegistry;
import dev.intelligentcreations.mudrock.registry.impl.MudrockStoneRegistry;
import dev.intelligentcreations.mudrock.registry.impl.MudrockWoodRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class MudrockRegistry {
    private final String namespace;
    private final String name;
    private final ItemGroup group;
    private List<Identifier> itemIdentifierList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();

    public MudrockRegistry(String namespace, String name, ItemGroup group) {
        this.namespace = namespace;
        this.name = name;
        this.group = group;
    }

    public static MudrockRegistry create(String namespace, String name, ItemGroup group, RegistryType type) {
        MudrockRegistry reg = new MudrockRegistry(namespace, name, group);
        switch (type) {
            case METAL -> reg = new MudrockMetalRegistry(namespace, name, group);
            case GEM -> reg = new MudrockGemRegistry(namespace, name, group);
            case WOOD -> reg = new MudrockWoodRegistry(namespace, name, group);
            case STONE -> reg = new MudrockStoneRegistry(namespace, name, group);
        }
        return reg;
    }

    public static MudrockRegistry create(String namespace, String name, ItemGroup group) {
        return new MudrockRegistry(namespace, name, group);
    }

    public MudrockRegistry with(String name_1) {
        this.itemIdentifierList.add(new Identifier(namespace, this.name + "_" + name_1));
        this.itemList.add(new Item(new FabricItemSettings().group(group)));
        return this;
    }

    public void build() {
        for (int i = 0; i < this.itemList.size(); ++i) {
            Registry.register(Registry.ITEM, this.itemIdentifierList.get(i), this.itemList.get(i));
        }
        this.itemIdentifierList = new ArrayList<>();
        this.itemList = new ArrayList<>();
    }
}
