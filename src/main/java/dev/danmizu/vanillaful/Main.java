package dev.danmizu.vanillaful;

// SLF4J Imports
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Fabric Imports
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

// Local Imports
import dev.danmizu.vanillaful.block.ModBlockTags;
import dev.danmizu.vanillaful.block.ModBlocks;
import dev.danmizu.vanillaful.item.ModItems;
import dev.danmizu.vanillaful.util.ModGroups;
import dev.danmizu.vanillaful.util.ModInfo;
import dev.danmizu.vanillaful.util.ModLootTableModifiers;
import dev.danmizu.vanillaful.util.ModRenderHelper;

public class Main implements ModInitializer {
	// Init Logger
	public static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

	// Init Mod
	@Override
	public void onInitialize() {
		// Register Groups (Creative Inventory Tabs)
		ModGroups.registerModGroups();

		// Register Items
		ModItems.registerModItems();

		// Register Block Tags
		ModBlockTags.registerModBlockTags();

		// Register Blocks
		ModBlocks.registerModBlocks();

		// Register Fuels

		// Set Render Layers
		ModRenderHelper.setRenderLayers();

		// Register Commands

		// Register Events

		// Modify Loot Tables
		ModLootTableModifiers.modifyLootTables();

		// Log Version
		ModMetadata metadata = FabricLoader.getInstance().getModContainer(ModInfo.MOD_ID).get().getMetadata();
		LOGGER.info("Initialized and Loaded Vanillaful v" + metadata.getVersion());
	}
}
