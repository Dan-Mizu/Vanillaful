package dev.danmizu.vanillaful;

// java imports
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// fabric imports
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

// minecraft imports
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import dev.danmizu.vanillaful.block.ModBlocks;
import dev.danmizu.vanillaful.item.ModItems;
import dev.danmizu.vanillaful.util.ModInfo;

public class Main implements ModInitializer {
	// Init Logger
	public static final Logger LOGGER = LoggerFactory.getLogger(ModInfo.MOD_ID);

	// Init Groups (Creative Inventory Tabs)
	public static final ItemGroup VANILLAFUL = FabricItemGroupBuilder.build(
			new Identifier(ModInfo.MOD_ID, ModInfo.MOD_ID),
			() -> new ItemStack(ModItems.ICON));

	// Init Tags
	public static final TagKey<Block> LADDERS = TagKey.of(Registry.BLOCK_KEY,
			new Identifier(ModInfo.MOD_ID, "ladders"));

	@Override
	public void onInitialize() {
		// Version
		ModMetadata metadata = FabricLoader.getInstance().getModContainer(ModInfo.MOD_ID).get().getMetadata();
		LOGGER.info("Loading Vanillaful v" + metadata.getVersion());

		// Register Items
		ModItems.registerModItems();

		// Register Blocks
		ModBlocks.registerModBlocks();

		// Render Ladders
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.IRON_LADDER);

		// Get Loot Tables
		final Identifier NETHER_QUARTZ_ORE_LOOT_TABLE_ID = Blocks.NETHER_QUARTZ_ORE.getLootTableId();

		// Modify Loot Tables
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			// Nether Quartz Ore
			if (source.isBuiltin() && NETHER_QUARTZ_ORE_LOOT_TABLE_ID.equals(id)) {
				// Nether Quartz Dust
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(0.35f)) // 35% Chance
						.with(ItemEntry.builder(ModItems.NETHER_QUARTZ_DUST))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build()); // 1-3 Drops
				tableBuilder.pool(poolBuilder.build());
			}
		});
	}
}
