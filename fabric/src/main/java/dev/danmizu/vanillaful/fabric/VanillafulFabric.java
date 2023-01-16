package dev.danmizu.vanillaful.fabric;

import net.fabricmc.api.ModInitializer;

public class VanillafulFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		dev.danmizu.vanillaful.Vanillaful.init();
	}
}
