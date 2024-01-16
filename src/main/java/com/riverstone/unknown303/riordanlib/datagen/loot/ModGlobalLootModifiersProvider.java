package com.riverstone.unknown303.riordanlib.datagen.loot;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.items.ModItems;
import com.riverstone.unknown303.riordanlib.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, RiordanMod.MOD_ID);
    }

    @Override
    protected void start() {
        add("fabric_from_shipwreck", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_supply")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));
        add("fabric_from_dungeon", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));
        add("fabric_from_buried_treasure", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/buried_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));
        add("fabric_from_village_desert_house", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_desert_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));
        add("fabric_from_village_desert_house", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_desert_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));
        add("fabric_from_village_plains_house", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_plains_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));
        add("fabric_from_village_savanna_house", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_savanna_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));
        add("fabric_from_village_snowy_house", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_snowy_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));
        add("fabric_from_village_taiga_house", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_taiga_house")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build()
        }, ModItems.FABRIC.get()));

    }
}
