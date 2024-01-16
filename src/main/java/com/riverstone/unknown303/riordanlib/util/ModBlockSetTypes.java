package com.riverstone.unknown303.riordanlib.util;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModBlockSetTypes {
    public static final BlockSetType PINE;
    static {
        PINE = BlockSetType.register(new BlockSetType(RiordanMod.MOD_ID + ":pine"));
    }
}
