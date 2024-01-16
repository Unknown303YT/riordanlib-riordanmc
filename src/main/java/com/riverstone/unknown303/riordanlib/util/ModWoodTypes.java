package com.riverstone.unknown303.riordanlib.util;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PINE = WoodType.register(new WoodType(RiordanMod.MOD_ID + ":pine", ModBlockSetTypes.PINE));
}
