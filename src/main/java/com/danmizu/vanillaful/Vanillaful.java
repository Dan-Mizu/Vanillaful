package com.danmizu.vanillaful;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.danmizu.vanillaful.blocks.*;

public class Vanillaful implements ModInitializer {
	//Create Creative Inventory Tab
    public static final ItemGroup VANILLAFUL = FabricItemGroupBuilder.build(
		new Identifier("vanillaful", "vanillaful"),
		() -> new ItemStack(Vanillaful.IRON_LADDER));

	//Add Blocks/Items
	//Iron Bar
	public static final Item IRON_BAR = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Iron Ladder
	public static final IronLadderBlock IRON_LADDER = new IronLadderBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength((float)0.4,6).nonOpaque());

	@Override
	public void onInitialize() {
		//Version
		ModMetadata metadata = FabricLoader.getInstance().getModContainer("vanillaful").get().getMetadata();
		System.out.println("Initiated Vanillaful v"+ metadata.getVersion());
		
		//Add Blocks/Items
		//Iron Bar
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "iron_bar"), IRON_BAR);
		//Iron Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "iron_ladder"), IRON_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "iron_ladder"), new BlockItem(IRON_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));
		BlockRenderLayerMap.INSTANCE.putBlock(Vanillaful.IRON_LADDER, RenderLayer.getCutout());
	}
}