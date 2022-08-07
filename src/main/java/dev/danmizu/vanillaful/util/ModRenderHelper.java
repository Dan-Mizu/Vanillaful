package dev.danmizu.vanillaful.util;

// Minecraft Imports
import net.minecraft.client.render.RenderLayer;

// Fabric Imports
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

// Local Imports
import dev.danmizu.vanillaful.block.ModBlocks;

public class ModRenderHelper {
    public static void setRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.IRON_LADDER);
    }
}