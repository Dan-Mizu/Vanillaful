package dev.danmizu.vanillaful;

import dev.danmizu.vanillaful.registry.*;
import dev.danmizu.vanillaful.util.Log;
import dev.danmizu.vanillaful.util.MetaReader;

public class Vanillaful {

	public static void init() {
		ModFluidProperties.init();
        ModFluids.init();
		ModBlocks.init();
		ModItems.init();
		ModSoundEvents.init();
		ModEntityTypes.init();
		ModBlockEntityTypes.init();

		// log
		Log.info("Vanillaful v" + MetaReader.getVersion() + " has loaded!");
	}
}
