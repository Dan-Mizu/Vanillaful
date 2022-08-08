package dev.danmizu.vanillaful.util;

// Minecraft Imports
import net.minecraft.client.render.RenderLayer;
// import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

// Fabric Imports
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
// import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;

// Local Imports
import dev.danmizu.vanillaful.block.ModBlocks;

public class ModRenderHelper {
    public static void setRenderLayers() {
        // Iron Ladder
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.IRON_LADDER);

        // Gel
        FluidRenderHandlerRegistry.INSTANCE.register(ModBlocks.STILL_GEL, ModBlocks.FLOWING_GEL,
                new SimpleFluidRenderHandler(
                        new Identifier("minecraft:block/water_still"),
                        new Identifier("minecraft:block/water_flow"),
                        0xCFFBFF));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModBlocks.STILL_GEL,
                ModBlocks.FLOWING_GEL);

        // if you want to use custom textures they needs to be registered.
        // In this example this is unnecessary because the vanilla water textures are
        // already registered.
        // To register your custom textures use this method.
        // ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture,
        // registry) -> {
        // registry.register(new Identifier("vanillaful:block/gel_still"));
        // registry.register(new Identifier("vanillaful:block/gel_flow"));
        // });
    }
}