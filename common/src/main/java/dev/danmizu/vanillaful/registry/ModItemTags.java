package dev.danmizu.vanillaful.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import dev.danmizu.vanillaful.util.ModInfo;

public class ModItemTags {
    private static TagKey<Item> itemTag(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(ModInfo.MOD_ID, name));
    }
}
