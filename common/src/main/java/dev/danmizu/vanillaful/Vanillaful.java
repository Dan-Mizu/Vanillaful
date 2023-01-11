package dev.danmizu.vanillaful;

// import dev.danmizu.vanillaful.block.ModBlocks;
// import dev.danmizu.vanillaful.fluid.ModFluids;
import dev.danmizu.vanillaful.gui.ModCreativeTabs;
import dev.danmizu.vanillaful.item.ModItems;
import dev.danmizu.vanillaful.util.ModGroups;

public class Vanillaful {

    // Registering a new creative tab

    public static void init() {
        // register mod groups
        ModGroups.register();

        // register creative tab
        ModCreativeTabs.register();

        // register fluids
        // ModFluids.register();

        // register items
        ModItems.register();

        // register blocks
        // ModBlocks.register();
        
        // log
        System.out.println(ExampleExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
