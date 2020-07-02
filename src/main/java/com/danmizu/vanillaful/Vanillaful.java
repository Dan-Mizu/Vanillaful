package com.danmizu.vanillaful;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.danmizu.vanillaful.blocks.*;

public class Vanillaful implements ModInitializer {
	//Create Creative Inventory Tab
    public static final ItemGroup VANILLAFUL = FabricItemGroupBuilder.build(
		new Identifier("vanillaful", "vanillaful"),
		() -> new ItemStack(Vanillaful.IRON_LADDER));

	//Tags
	//Ladders
	public static final Tag<Block> LADDERS = TagRegistry.block(new Identifier("vanillaful", "ladders"));
	//Ladders Fuel
	public static final Tag<Item> LADDERS_FUEL = TagRegistry.item(new Identifier("vanillaful", "flammable_ladders"));
	//Sticks Fuel
	public static final Tag<Item> STICKS_FUEL = TagRegistry.item(new Identifier("vanillaful", "flammable_sticks"));

	//Add Blocks/Items
	//Iron Bar
	public static final Item IRON_BAR = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Iron Ladder
	public static final IronLadderBlock IRON_LADDER = new IronLadderBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength((float)0.4,6).nonOpaque());
	//Spruce Stick
	public static final Item SPRUCE_STICK = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Spruce Ladder
	public static final SpruceLadderBlock SPRUCE_LADDER = new SpruceLadderBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.LADDER).strength((float)0.4,(float)0.4).nonOpaque());
	//Birch Stick
	public static final Item BIRCH_STICK = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Birch Ladder
	public static final BirchLadderBlock BIRCH_LADDER = new BirchLadderBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.LADDER).strength((float)0.4,(float)0.4).nonOpaque());
	//Jungle Stick
	public static final Item JUNGLE_STICK = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Jungle Ladder
	public static final JungleLadderBlock JUNGLE_LADDER = new JungleLadderBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.LADDER).strength((float)0.4,(float)0.4).nonOpaque());
	//Acacia Stick
	public static final Item ACACIA_STICK = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Acacia Ladder
	public static final AcaciaLadderBlock ACACIA_LADDER = new AcaciaLadderBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.LADDER).strength((float)0.4,(float)0.4).nonOpaque());
	//Dark Oak Stick
	public static final Item DARK_OAK_STICK = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Dark Oak Ladder
	public static final DarkOakLadderBlock DARK_OAK_LADDER = new DarkOakLadderBlock(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.LADDER).strength((float)0.4,(float)0.4).nonOpaque());
	//Crimson Stick
	public static final Item CRIMSON_STICK = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Crimson Ladder
	public static final CrimsonLadderBlock CRIMSON_LADDER = new CrimsonLadderBlock(FabricBlockSettings.of(Material.NETHER_WOOD).sounds(BlockSoundGroup.LADDER).strength((float)0.4,(float)0.4).nonOpaque());
	//Warped Stick
	public static final Item WARPED_STICK = new Item(new Item.Settings().group(Vanillaful.VANILLAFUL));
	//Warped Ladder
	public static final WarpedLadderBlock WARPED_LADDER = new WarpedLadderBlock(FabricBlockSettings.of(Material.NETHER_WOOD).sounds(BlockSoundGroup.LADDER).strength((float)0.4,(float)0.4).nonOpaque());

	//Nether Brick Fence Gate
	public static final NetherBrickFenceGateBlock NETHER_BRICK_FENCE_GATE = new NetherBrickFenceGateBlock(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.NETHER_BRICKS).strength(2,6).nonOpaque());

	@Override
	public void onInitialize() {
		//Version
		ModMetadata metadata = FabricLoader.getInstance().getModContainer("vanillaful").get().getMetadata();
		System.out.println("Loading Vanillaful v"+ metadata.getVersion());
		
		//Add Blocks/Items
		//Iron Bar
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "iron_bar"), IRON_BAR);
		//Iron Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "iron_ladder"), IRON_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "iron_ladder"), new BlockItem(IRON_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));
		//Spruce Stick
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "spruce_stick"), SPRUCE_STICK);
		//Spruce Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "spruce_ladder"), SPRUCE_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "spruce_ladder"), new BlockItem(SPRUCE_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));
		//Birch Stick
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "birch_stick"), BIRCH_STICK);
		//Birch Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "birch_ladder"), BIRCH_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "birch_ladder"), new BlockItem(BIRCH_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));
		//Jungle Stick
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "jungle_stick"), JUNGLE_STICK);
		//Jungle Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "jungle_ladder"), JUNGLE_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "jungle_ladder"), new BlockItem(JUNGLE_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));
		//Acacia Stick
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "acacia_stick"), ACACIA_STICK);
		//Acacia Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "acacia_ladder"), ACACIA_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "acacia_ladder"), new BlockItem(ACACIA_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));
		//Dark Oak Stick
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "dark_oak_stick"), DARK_OAK_STICK);
		//Dark Oak Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "dark_oak_ladder"), DARK_OAK_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "dark_oak_ladder"), new BlockItem(DARK_OAK_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));
		//Crimson Stick
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "crimson_stick"), CRIMSON_STICK);
		//Crimson Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "crimson_ladder"), CRIMSON_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "crimson_ladder"), new BlockItem(CRIMSON_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));
		//Warped Stick
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "warped_stick"), WARPED_STICK);
		//Warped Ladder
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "warped_ladder"), WARPED_LADDER);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "warped_ladder"), new BlockItem(WARPED_LADDER, new Item.Settings().group(Vanillaful.VANILLAFUL)));

		//Nether Brick Fence Gate
		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "nether_brick_fence_gate"), NETHER_BRICK_FENCE_GATE);
		Registry.register(Registry.ITEM, new Identifier("vanillaful", "nether_brick_fence_gate"), new BlockItem(NETHER_BRICK_FENCE_GATE, new Item.Settings().group(Vanillaful.VANILLAFUL)));

		//Render Ladders
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Vanillaful.IRON_LADDER, Vanillaful.SPRUCE_LADDER, Vanillaful.BIRCH_LADDER, Vanillaful.JUNGLE_LADDER, Vanillaful.ACACIA_LADDER, Vanillaful.DARK_OAK_LADDER, Vanillaful.CRIMSON_LADDER, Vanillaful.WARPED_LADDER);

		//Register Fuel
		FuelRegistry.INSTANCE.add(Vanillaful.LADDERS_FUEL, 300);
		FuelRegistry.INSTANCE.add(Vanillaful.STICKS_FUEL, 100);
	}
}