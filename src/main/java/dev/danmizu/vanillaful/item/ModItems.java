package dev.danmizu.vanillaful.item;

// minecraft imports
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// fabric imports
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

// local imports
import dev.danmizu.vanillaful.Main;
import dev.danmizu.vanillaful.util.ModInfo;

public class ModItems {

    public static final Item ICON = registerItem("icon", new Item(new FabricItemSettings()));

    public static final Item NETHER_QUARTZ_DUST = registerItem("nether_quartz_dust",
            new Item(new FabricItemSettings().group(Main.VANILLAFUL)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, name), item);
    }

    public static void registerModItems() {
    }
}