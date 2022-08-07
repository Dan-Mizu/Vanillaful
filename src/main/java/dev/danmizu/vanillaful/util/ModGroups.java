package dev.danmizu.vanillaful.util;

// Minecraft Imports
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

// Fabric Imports
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;

// Local Imports
import dev.danmizu.vanillaful.item.ModItems;

public class ModGroups {

    // Init Groups (Creative Inventory Tabs)
	public static final ItemGroup VANILLAFUL = FabricItemGroupBuilder.build(
        new Identifier(ModInfo.MOD_ID, ModInfo.MOD_ID),
        () -> new ItemStack(ModItems.ICON));

    public static void registerModGroups() {
    }
}
