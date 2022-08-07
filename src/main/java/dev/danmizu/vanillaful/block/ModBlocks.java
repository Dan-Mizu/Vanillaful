package dev.danmizu.vanillaful.block;

// Minecraft Imports
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

// Fabric Imports
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

// Local Imports
import dev.danmizu.vanillaful.util.ModGroups;
import dev.danmizu.vanillaful.util.ModInfo;
import dev.danmizu.vanillaful.block.custom.FreeStandingLadderBlock;

public class ModBlocks {

    // Iron Ladder
    public static final Block IRON_LADDER = registerBlock("iron_ladder",
            new FreeStandingLadderBlock(FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(5, 6).nonOpaque()));

    // Register Blocks without Items
    // private static Block registerBlockWithoutBlockItem(String name, Block block){
    //     return Registry.register(Registry.BLOCK, new Identifier(ModInfo.MOD_ID, name), block);
    // }

    // Register Blocks
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(ModInfo.MOD_ID, name), block);
    }

    // Register Block Items
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModGroups.VANILLAFUL)));
    }

    public static void registerModBlocks() {
    }
}