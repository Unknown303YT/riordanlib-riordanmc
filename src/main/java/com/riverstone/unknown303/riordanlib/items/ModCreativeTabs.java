package com.riverstone.unknown303.riordanlib.items;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RiordanMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RIORDAN_TAB = CREATIVE_TABS.register("riordan_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PINECONE.get()))
                    .title(Component.translatable("creativetab.riordancompat.riordan_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.PINE_LOG.get());
                        pOutput.accept(ModBlocks.PINE_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_PINE_LOG.get());
                        pOutput.accept(ModBlocks.STRIPPED_PINE_WOOD.get());
                        pOutput.accept(ModBlocks.PINE_PLANKS.get());
                        // STAIRS
                        // SLAB
                        // FENCE
                        // FENCE GATE
                        // DOOR
                        // TRAPDOOR
                        // PRESSURE PLATE
                        // BUTTON
                        pOutput.accept(ModBlocks.PINE_LEAVES.get());
                        pOutput.accept(ModBlocks.PINE_SAPLING.get());
                        pOutput.accept(ModItems.PINE_SIGN.get());
                        pOutput.accept(ModItems.PINE_HANGING_SIGN.get());
                        pOutput.accept(ModItems.PINE_CHEST_BOAT.get());
                        pOutput.accept(ModItems.PINE_BOAT.get());
                        pOutput.accept(ModItems.PINECONE.get());
                        pOutput.accept(ModItems.FABRIC.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
