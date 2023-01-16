package dev.danmizu.vanillaful.fabric;

import dev.danmizu.vanillaful.registry.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class VanillafulFabricClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		dev.danmizu.vanillaful.client.VanillafulClient.init();

		// Translucent Blocks
		BlockRenderLayerMap.INSTANCE.putBlocks(
			RenderType.translucent(),
			ModBlocks.GEL_BLOCK.get(),
			ModBlocks.WHITE_GEL_BLOCK.get(),
			ModBlocks.ORANGE_GEL_BLOCK.get(),
			ModBlocks.MAGENTA_GEL_BLOCK.get(),
			ModBlocks.LIGHT_BLUE_GEL_BLOCK.get(),
			ModBlocks.YELLOW_GEL_BLOCK.get(),
			ModBlocks.LIME_GEL_BLOCK.get(),
			ModBlocks.PINK_GEL_BLOCK.get(),
			ModBlocks.GRAY_GEL_BLOCK.get(),
			ModBlocks.LIGHT_GRAY_GEL_BLOCK.get(),
			ModBlocks.CYAN_GEL_BLOCK.get(),
			ModBlocks.PURPLE_GEL_BLOCK.get(),
			ModBlocks.BLUE_GEL_BLOCK.get(),
			ModBlocks.BROWN_GEL_BLOCK.get(),
			ModBlocks.GREEN_GEL_BLOCK.get(),
			ModBlocks.RED_GEL_BLOCK.get(),
			ModBlocks.BLACK_GEL_BLOCK.get()
		);

		// Cutout Blocks
		BlockRenderLayerMap.INSTANCE.putBlocks(
			RenderType.cutout(),
			ModBlocks.IRON_LADDER.get()
		);
	}
}
