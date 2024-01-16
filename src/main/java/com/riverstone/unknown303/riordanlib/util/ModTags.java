package com.riverstone.unknown303.riordanlib.util;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PINE = tag("pine_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(RiordanMod.MOD_ID, name));
        }
    }

    public static class Items {

    }

    public static class Biomes {
        public static final TagKey<Biome> PINE_SPAWNABLE = tag("pine_spawnable");

        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(RiordanMod.MOD_ID, name));
        }
    }
}
