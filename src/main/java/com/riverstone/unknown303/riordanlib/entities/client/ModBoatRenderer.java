package com.riverstone.unknown303.riordanlib.entities.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.entities.custom.ModBoatEntity;
import com.riverstone.unknown303.riordanlib.entities.custom.ModChestBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class ModBoatRenderer extends BoatRenderer {
    private final Map<ModBoatEntity.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public ModBoatRenderer(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.boatResources = Stream.of(ModBoatEntity.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type,
                type -> Pair.of(new ResourceLocation(RiordanMod.MOD_ID, getTextureLocation(type, pChestBoat)),
                        this.createBoatModel(pContext, type, pChestBoat))));
    }

    private static String getTextureLocation(ModBoatEntity.Type pType, boolean pChestBoat) {
        return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png" : "textures/entity/boat/" + pType.getName() + ".png";
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context pContext, ModBoatEntity.Type pType, boolean pChestBoat) {
        ModelLayerLocation modellayerlocation = pChestBoat ? ModBoatRenderer.createChestBoatModelName(pType) : ModBoatRenderer.createBoatModelName(pType);
        ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
        return pChestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    private static ModelLayerLocation createBoatModelName(ModBoatEntity.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    private static ModelLayerLocation createChestBoatModelName(ModBoatEntity.Type pType) {
        return createLocation("chest_boat/" + pType.getName(), "main");
    }

    private static ModelLayerLocation createLocation(String pPath, String pModel) {
        return new ModelLayerLocation(new ResourceLocation(RiordanMod.MOD_ID, pPath), pModel);
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if (boat instanceof ModBoatEntity modBoat) {
            return this.boatResources.get(modBoat.getModVariant());
        } else if (boat instanceof ModChestBoatEntity modChestBoat) {
            return this.boatResources.get(modChestBoat.getModVariant());
        } else {
            return null;
        }
    }
}
