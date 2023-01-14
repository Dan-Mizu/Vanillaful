package dev.danmizu.vanillaful.gui;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import dev.danmizu.vanillaful.registry.ModItems;
import dev.danmizu.vanillaful.registry.ModRegistry;
import dev.danmizu.vanillaful.util.ModInfo;

public class ModCreativeTab {
    public static final CreativeModeTab TAB = ModRegistry.registerCreativeModeTab(new ResourceLocation(ModInfo.MOD_ID, "tab"), () -> new ItemStack(ModItems.ICON.get()));
}
