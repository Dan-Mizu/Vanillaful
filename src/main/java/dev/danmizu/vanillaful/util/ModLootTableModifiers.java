package dev.danmizu.vanillaful.util;

// Minecraft Imports
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

// Fabric Imports
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;

// Local Imports
import dev.danmizu.vanillaful.item.ModItems;

public class ModLootTableModifiers {
    // Get Loot Tables
    private static final Identifier NETHER_QUARTZ_ORE_LOOT_TABLE_ID = new Identifier("minecraft",
            "blocks/nether_quartz_ore");

    // Modify Loot Tables
    public static void modifyLootTables() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			// Nether Quartz Ore
			if (source.isBuiltin() && NETHER_QUARTZ_ORE_LOOT_TABLE_ID.equals(id)) {
				// Nether Quartz Dust
				LootPool.Builder normal = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(0.15f)) // 15% Chance
						.with(ItemEntry.builder(ModItems.NETHER_QUARTZ_DUST))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); // 1 Drop
				tableBuilder.pool(normal.build());

				LootPool.Builder rare = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceLootCondition.builder(0.05f)) // 5% Chance
						.with(ItemEntry.builder(ModItems.NETHER_QUARTZ_DUST))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build()); // 1-2 Drops;
				tableBuilder.pool(rare.build());
				
			}
		});
    }
}