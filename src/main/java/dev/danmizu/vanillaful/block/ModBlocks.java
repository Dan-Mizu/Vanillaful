package dev.danmizu.vanillaful.block;

// minecraft imports
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// fabric imports
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

// local imports
import dev.danmizu.vanillaful.Main;
import dev.danmizu.vanillaful.util.ModInfo;

public class ModBlocks {

    public static final Block IRON_LADDER = registerBlock("iron_ladder",
            new Block(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(5, 6).nonOpaque()));

    // private static Block registerBlockWithoutBlockItem(String name, Block block){
    //     return Registry.register(Registry.BLOCK, new Identifier(ModInfo.MOD_ID, name), block);
    // }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(ModInfo.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(Main.VANILLAFUL)));
    }

    public static void registerModBlocks() {
    }
}