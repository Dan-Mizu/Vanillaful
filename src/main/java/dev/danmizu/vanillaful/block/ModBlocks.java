package dev.danmizu.vanillaful.block;

// Minecraft Imports
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
import dev.danmizu.vanillaful.block.custom.GelFluidBlock;

public class ModBlocks {

    // Iron Ladder
    public static final Block IRON_LADDER = registerBlock("iron_ladder",
            new FreeStandingLadderBlock(
                    FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(5, 6).nonOpaque()));

    // Gel
    public static Item GEL_BUCKET;
    public static final Fluid STILL_GEL = registerFluid("gel",
            new GelFluidBlock.Still(), "gel_bucket", GEL_BUCKET);

    // Gel (Flowing)
    public static final Fluid FLOWING_GEL = registerFluidWithoutFluidItem("flowing_gel",
            new GelFluidBlock.Flowing());

    // Gel (Fluid Block)
    public static final Block GEL = registerBlockWithoutBlockItem("gel",
            new FluidBlock((FlowableFluid) STILL_GEL, FabricBlockSettings.copy(Blocks.WATER)));

    // Register Blocks
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(ModInfo.MOD_ID, name), block);
    }

    // Register Blocks without Items
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(ModInfo.MOD_ID,
                name), block);
    }

    // Register Block Items
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModGroups.VANILLAFUL)));
    }

    // Register Fluid
    private static Fluid registerFluid(String name, Fluid fluid, String fluidItemName, Item item) {
        item = registerFluidItem(fluidItemName, fluid);
        return Registry.register(Registry.FLUID, new Identifier(ModInfo.MOD_ID, name), fluid);
    }

    // Register Fluid Without Fluid Item
    private static Fluid registerFluidWithoutFluidItem(String name, Fluid fluid) {
        return Registry.register(Registry.FLUID, new Identifier(ModInfo.MOD_ID, name), fluid);
    }

    // Register Fluid Items (Buckets)
    private static Item registerFluidItem(String name, Fluid fluid) {
        return Registry.register(Registry.ITEM, new Identifier(ModInfo.MOD_ID, name),
                new BucketItem(fluid, new FabricItemSettings().group(ModGroups.VANILLAFUL).recipeRemainder(Items.BUCKET)
                        .maxCount(1)));
    }

    public static void registerModBlocks() {
    }
}