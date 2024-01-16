package com.riverstone.unknown303.riordanlib.datagen.statesandmodels;


import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.blocks.ModBlocks;
import com.riverstone.unknown303.riordanlib.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RiordanMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PINECONE);
        saplingItem(ModBlocks.PINE_SAPLING);
        simpleItem(ModItems.PINE_SIGN);
        simpleItem(ModItems.PINE_HANGING_SIGN);
        simpleItem(ModItems.PINE_BOAT);
        simpleItem(ModItems.PINE_CHEST_BOAT);

        simpleItem(ModItems.FABRIC);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RiordanMod.MOD_ID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RiordanMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
