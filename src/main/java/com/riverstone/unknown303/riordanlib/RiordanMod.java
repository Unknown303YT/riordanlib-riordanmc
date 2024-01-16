package com.riverstone.unknown303.riordanlib;

import com.mojang.logging.LogUtils;
import com.riverstone.unknown303.riordanlib.blocks.ModBlocks;
import com.riverstone.unknown303.riordanlib.blocks.entity.ModBlockEntities;
import com.riverstone.unknown303.riordanlib.entities.ModEntities;
import com.riverstone.unknown303.riordanlib.entities.client.ModBoatRenderer;
import com.riverstone.unknown303.riordanlib.items.ModCreativeTabs;
import com.riverstone.unknown303.riordanlib.items.ModItems;
import com.riverstone.unknown303.riordanlib.loot.ModLootModifiers;
import com.riverstone.unknown303.riordanlib.util.ModWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RiordanMod.MOD_ID)
public class RiordanMod {
    public static final String MOD_ID = "riordancompat";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RiordanMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLootModifiers.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);

        ModCreativeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //Creative Mode Tabs Here
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            Sheets.addWoodType(ModWoodTypes.PINE);

            EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
        }
    }
}
