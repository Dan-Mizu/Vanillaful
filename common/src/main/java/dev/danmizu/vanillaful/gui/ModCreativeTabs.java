package dev.danmizu.vanillaful.gui;

import net.minecraft.world.item.CreativeModeTab;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

import dev.danmizu.vanillaful.item.ModItems;
import dev.danmizu.vanillaful.util.ModInfo;

public class ModCreativeTabs {
    // creative mode tab
    public static final CreativeModeTab TAB = registerCreativeTab(ModInfo.MOD_ID, "vanillaful", ModItems.ICON);

    // register creative mode tab
    private static CreativeModeTab registerCreativeTab(String modID, String name, RegistrySupplier<Item> icon) {
        return CreativeTabRegistry.create(
                new ResourceLocation(modID, name),
                () -> new ItemStack(icon.get()));
    }

    public static void register() {
    }
}
