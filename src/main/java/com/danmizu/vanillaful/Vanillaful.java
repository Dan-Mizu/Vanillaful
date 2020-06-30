package com.danmizu.vanillaful;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Vanillaful implements ModInitializer {
	/* Declare and initialize our custom block instance.
	We set our block material to METAL, which requires a pickaxe to efficiently break.
	Hardness represents how long the break takes to break. Stone has a hardness of 1.5f, while Obsidian has a hardness of 50.0f.
	*/
	public static final Block IRON_LADDER = new Block(FabricBlockSettings.of(Material.METAL).hardness(5.0f));
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.BLOCK, new Identifier("vanillaful", "iron_ladder"), IRON_LADDER);

		System.out.println("Loading Vanillaful");
	}
}