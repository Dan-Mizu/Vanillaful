package dev.danmizu.vanillaful.quilt;

import dev.danmizu.vanillaful.fabriclike.VanillafulFabricLike;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class VanillafulQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        VanillafulFabricLike.init();
    }
}
