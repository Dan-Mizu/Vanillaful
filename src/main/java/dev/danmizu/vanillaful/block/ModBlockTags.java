package dev.danmizu.vanillaful.block;

// Minecraft Imports
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// Local Imports
import dev.danmizu.vanillaful.util.ModInfo;

public class ModBlockTags {

    // Init Block Tags
    public static final TagKey<Block> LADDERS = TagKey.of(Registry.BLOCK_KEY,
			new Identifier(ModInfo.MOD_ID, "ladders"));
            
    public static void registerModBlockTags() {
    }
}
