package dev.danmizu.vanillaful;

import dev.architectury.platform.Platform;

import dev.danmizu.vanillaful.block.ModBlocks;
// import dev.danmizu.vanillaful.fluid.ModFluids;
// import dev.danmizu.vanillaful.gui.ModCreativeTabs;
import dev.danmizu.vanillaful.item.ModItems;
import dev.danmizu.vanillaful.util.Log;
// import dev.danmizu.vanillaful.util.ModGroups;
import dev.danmizu.vanillaful.util.ModInfo;

public class Vanillaful {
    public static void init() {
        // register fluids
        // ModFluids.FLUIDS.register();

        // register blocks
        ModBlocks.BLOCKS.register();

        // register items
        ModItems.ITEMS.register();

        // log
        Log.info("Vanillaful v" + Platform.getMod(ModInfo.MOD_ID).getVersion() + " has loaded!");
    }
}
