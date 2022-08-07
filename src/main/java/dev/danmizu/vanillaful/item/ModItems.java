package dev.danmizu.vanillaful.item;

// Minecraft Imports
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// Fabric Imports
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

// local Imports
import dev.danmizu.vanillaful.util.ModGroups;
import dev.danmizu.vanillaful.util.ModInfo;

public class ModItems {

    // Mod Icon
    public static final Item ICON = registerItem("icon", new Item(new FabricItemSettings()));

    // Nether Quartz Dust
    public static final Item NETHER_QUARTZ_DUST = registerItem("nether_quartz_dust",
            new Item(new FabricItemSettings().group(ModGroups.VANILLAFUL)));

    // Register Item
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, name), item);
    }

    public static void registerModItems() {
    }
}