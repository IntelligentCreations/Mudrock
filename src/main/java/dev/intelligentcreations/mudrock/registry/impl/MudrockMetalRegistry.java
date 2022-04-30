package dev.intelligentcreations.mudrock.registry.impl;

import dev.intelligentcreations.mudrock.registry.MudrockRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MudrockMetalRegistry extends MudrockRegistry
{
    private final String namespace;
    private final String name;
    private final ItemGroup group;
    private List<Identifier> itemIdentifierList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    private List<Identifier> blockIdentifierList = new ArrayList<>();
    private List<Block> blockList = new ArrayList<>();
    private List<Identifier> featureIdentifierList = new ArrayList<>();
    private List<ConfiguredFeature<?, ?>> configuredFeatureList = new ArrayList<>();
    private List<PlacedFeature> placedFeatureList = new ArrayList<>();

    public MudrockMetalRegistry(String namespace, String name, ItemGroup group)
    {
        super(namespace, name, group);
        this.namespace = namespace;
        this.name = name;
        this.group = group;
    }

    public MudrockMetalRegistry with(String name_1)
    {
        this.itemIdentifierList.add(new Identifier(namespace, this.name + "_" + name_1));
        this.itemList.add(new Item(new FabricItemSettings().group(group)));
        return this;
    }

    public MudrockMetalRegistry withBlock(String name_1, Material material, float hardness)
    {
        this.blockIdentifierList.add(new Identifier(namespace, this.name + "_" + name_1));
        this.blockList.add(new Block(FabricBlockSettings.of(material).hardness(hardness)));
        return this;
    }

    public MudrockMetalRegistry withIngot()
    {
        return this.with("ingot");
    }

    public MudrockMetalRegistry withNugget()
    {
        return this.with("nugget");
    }

    public MudrockMetalRegistry withPlate()
    {
        return this.with("plate");
    }

    public MudrockMetalRegistry withMetalBlock(float hardness)
    {
        return this.withBlock("block", Material.METAL, hardness);
    }

    public MudrockMetalRegistry withOre(float hardness, int height, int veinSize, int veinNumberPerChunk)
    {
        Block block = new Block(FabricBlockSettings.of(Material.STONE).hardness(hardness));
        this.blockIdentifierList.add(new Identifier(namespace, this.name + "_ore"));
        this.blockList.add(block);
        ConfiguredFeature<?, ?> cfgFeature = new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, block.getDefaultState(), veinSize));
        PlacedFeature placedFeature = new PlacedFeature(RegistryEntry.of(cfgFeature), Arrays.asList(CountPlacementModifier.of(veinNumberPerChunk), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(height))));
        this.featureIdentifierList.add(new Identifier(namespace, this.name + "_ore_gen"));
        this.configuredFeatureList.add(cfgFeature);
        this.placedFeatureList.add(placedFeature);
        return this;
    }

    public MudrockMetalRegistry withDeepslateOre(float hardness, int height, int veinSize, int veinNumberPerChunk)
    {
        Block block = new Block(FabricBlockSettings.of(Material.STONE).hardness(hardness));
        this.blockIdentifierList.add(new Identifier(namespace, this.name + "_deepslate_ore"));
        this.blockList.add(block);
        ConfiguredFeature<?, ?> cfgFeature = new ConfiguredFeature(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, block.getDefaultState(), veinSize));
        PlacedFeature placedFeature = new PlacedFeature(RegistryEntry.of(cfgFeature), Arrays.asList(CountPlacementModifier.of(veinNumberPerChunk), SquarePlacementModifier.of(), HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(height))));
        this.featureIdentifierList.add(new Identifier(namespace, this.name + "_deepslate_ore_gen"));
        this.configuredFeatureList.add(cfgFeature);
        this.placedFeatureList.add(placedFeature);
        return this;
    }

    public MudrockMetalRegistry withSet(float hardness, int height, int veinSize, int veinNumberPerChunk)
    {
        this.withIngot();
        this.withMetalBlock(hardness);
        this.withNugget();
        this.withPlate();
        this.withOre(hardness, height, veinSize, veinNumberPerChunk);
        this.withDeepslateOre(hardness + 2.0f, height, veinSize, veinNumberPerChunk);
        return this;
    }

    public void build()
    {
        for (int i = 0; i < itemList.size(); ++i)
        {
            Registry.register(Registry.ITEM, itemIdentifierList.get(i), itemList.get(i));
        }
        for (int i = 0; i < blockList.size(); ++i)
        {
            Registry.register(Registry.BLOCK, blockIdentifierList.get(i), blockList.get(i));
            Registry.register(Registry.ITEM, blockIdentifierList.get(i), new BlockItem(blockList.get(i), new FabricItemSettings().group(group)));
        }
        for (int i = 0; i < configuredFeatureList.size(); ++i)
        {
            Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                featureIdentifierList.get(i), configuredFeatureList.get(i));
            Registry.register(BuiltinRegistries.PLACED_FEATURE, featureIdentifierList.get(i),
                placedFeatureList.get(i));
            BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY,
                    featureIdentifierList.get(i)));
        }
        // Refresh the lists
        this.itemIdentifierList = new ArrayList<>();
        this.itemList = new ArrayList<>();
        this.blockIdentifierList = new ArrayList<>();
        this.blockList = new ArrayList<>();
        this.featureIdentifierList = new ArrayList<>();
        this.configuredFeatureList = new ArrayList<>();
        this.placedFeatureList = new ArrayList<>();
    }
}
