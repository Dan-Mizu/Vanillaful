package dev.danmizu.vanillaful;

// java imports
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

// fabric imports
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

// minecraft imports
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

// local imports
import dev.danmizu.vanillaful.blocks.IronLadderBlock;
import dev.danmizu.vanillaful.util.ModInfo;

public class Main implements ModInitializer {
	// Init Groups (Creative Inventory Tabs)
	public static final ItemGroup VANILLAFUL = FabricItemGroupBuilder.build(
			new Identifier(ModInfo.MOD_ID, ModInfo.MOD_ID),
			() -> new ItemStack(Main.ICON));

	// Init Tags
	public static final TagKey<Block> LADDERS = TagKey.of(Registry.BLOCK_KEY,
			new Identifier(ModInfo.MOD_ID, "ladders"));

	// Init Blocks/Items
	public static final Item ICON = new Item(new FabricItemSettings());
	public static final IronLadderBlock IRON_LADDER = new IronLadderBlock(
			FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(5, 6).nonOpaque());

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	// public static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// LOGGER.info("Hello Fabric world!");

		// Version
		ModMetadata metadata = FabricLoader.getInstance().getModContainer(ModInfo.MOD_ID).get().getMetadata();
		System.out.println("Loading Vanillaful v" + metadata.getVersion());

		// Register Items
		Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, "icon"), ICON);
		Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, "iron_ladder"),
				new BlockItem(IRON_LADDER, new FabricItemSettings().group(Main.VANILLAFUL)));

		// Register Blocks
		Registry.register(Registry.BLOCK, new Identifier(ModInfo.MOD_ID, "iron_ladder"), IRON_LADDER);

		// Render Ladders
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Main.IRON_LADDER);
	}
}
