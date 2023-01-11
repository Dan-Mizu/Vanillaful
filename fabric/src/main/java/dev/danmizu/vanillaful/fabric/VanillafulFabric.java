package dev.danmizu.vanillaful.fabric;

import dev.danmizu.vanillaful.fabriclike.VanillafulFabricLike;
import net.fabricmc.api.ModInitializer;

public class VanillafulFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        VanillafulFabricLike.init();
    }
}
