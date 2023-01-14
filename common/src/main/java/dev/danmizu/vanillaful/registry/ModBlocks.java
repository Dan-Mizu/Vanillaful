package dev.danmizu.vanillaful.registry;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import dev.danmizu.vanillaful.block.*;

public class ModBlocks {

        // Gel Blocks
        // default
        public static final Supplier<GelBlock> GEL_BLOCK = registerGelBlock("gel_block");
        // white
        public static final Supplier<GelBlock> WHITE_GEL_BLOCK = registerGelBlock("white_gel_block");
        // orange
        public static final Supplier<GelBlock> ORANGE_GEL_BLOCK = registerGelBlock("orange_gel_block");
        // magenta
        public static final Supplier<GelBlock> MAGENTA_GEL_BLOCK = registerGelBlock("magenta_gel_block");
        // light blue
        public static final Supplier<GelBlock> LIGHT_BLUE_GEL_BLOCK = registerGelBlock("light_blue_gel_block");
        // yellow
        public static final Supplier<GelBlock> YELLOW_GEL_BLOCK = registerGelBlock("yellow_gel_block");
        // lime
        public static final Supplier<GelBlock> LIME_GEL_BLOCK = registerGelBlock("lime_gel_block");
        // pink
        public static final Supplier<GelBlock> PINK_GEL_BLOCK = registerGelBlock("pink_gel_block");
        // gray
        public static final Supplier<GelBlock> GRAY_GEL_BLOCK = registerGelBlock("gray_gel_block");
        // light gray
        public static final Supplier<GelBlock> LIGHT_GRAY_GEL_BLOCK = registerGelBlock("light_gray_gel_block");
        // cyan
        public static final Supplier<GelBlock> CYAN_GEL_BLOCK = registerGelBlock("cyan_gel_block");
        // purple
        public static final Supplier<GelBlock> PURPLE_GEL_BLOCK = registerGelBlock("purple_gel_block");
        // blue
        public static final Supplier<GelBlock> BLUE_GEL_BLOCK = registerGelBlock("blue_gel_block");
        // brown
        public static final Supplier<GelBlock> BROWN_GEL_BLOCK = registerGelBlock("brown_gel_block");
        // green
        public static final Supplier<GelBlock> GREEN_GEL_BLOCK = registerGelBlock("green_gel_block");
        // red
        public static final Supplier<GelBlock> RED_GEL_BLOCK = registerGelBlock("red_gel_block");
        // black
        public static final Supplier<GelBlock> BLACK_GEL_BLOCK = registerGelBlock("black_gel_block");

        // Iron Ladder
        public static final Supplier<IronLadderBlock> IRON_LADDER = registerBlock("iron_ladder",
                        () -> new IronLadderBlock(), ModItems.defaultProperties());

        // Register Gel Blocks
        public static Supplier<GelBlock> registerGelBlock(String name) {
                return registerBlock(name,
                                () -> new GelBlock(),
                                ModItems.defaultProperties());
        }

        // Register Block, Block Item, and add it to the Creative Tab
        public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block,
                        Item.Properties itemProperties) {
                Supplier<T> supplier = ModRegistry.registerBlock(name, block);
                ModRegistry.registerItem(name,
                                () -> new BlockItem(supplier.get(), itemProperties));
                return supplier;
        }

        // Register Block and Block Item
        public static <T extends Block> Supplier<T> registerBlockHidden(String name, Supplier<T> block) {
                Supplier<T> supplier = ModRegistry.registerBlock(name, block);
                ModRegistry.registerItem(name, () -> new BlockItem(supplier.get(), new Item.Properties()));
                return supplier;
        }

        // Register Block
        public static <T extends Block> Supplier<T> registerBlockOnly(String name, Supplier<T> block) {
                return ModRegistry.registerBlock(name, block);
        }

        public static void init() {
        }
}
