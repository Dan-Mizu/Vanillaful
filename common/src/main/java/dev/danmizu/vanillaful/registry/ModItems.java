package dev.danmizu.vanillaful.registry;

import java.util.function.Supplier;

import net.minecraft.world.item.Item;

import dev.danmizu.vanillaful.gui.ModCreativeTab;
import dev.danmizu.vanillaful.item.HoneyBucketItem;

public class ModItems {

        // Mod Icon
        public static final Supplier<Item> ICON = registerItemHidden("icon");

        /// Gel Buckets
        // default
        public static final Supplier<Item> GEL_BUCKET = registerBucketItem("gel_bucket");
        // white
        public static final Supplier<Item> WHITE_GEL_BUCKET = registerBucketItem("white_gel_bucket");
        // orange
        public static final Supplier<Item> ORANGE_GEL_BUCKET = registerBucketItem("orange_gel_bucket");
        // magenta
        public static final Supplier<Item> MAGENTA_GEL_BUCKET = registerBucketItem("magenta_gel_bucket");
        // light blue
        public static final Supplier<Item> LIGHT_BLUE_GEL_BUCKET = registerBucketItem("light_blue_gel_bucket");
        // yellow
        public static final Supplier<Item> YELLOW_GEL_BUCKET = registerBucketItem("yellow_gel_bucket");
        // lime
        public static final Supplier<Item> LIME_GEL_BUCKET = registerBucketItem("lime_gel_bucket");
        // pink
        public static final Supplier<Item> PINK_GEL_BUCKET = registerBucketItem("pink_gel_bucket");
        // gray
        public static final Supplier<Item> GRAY_GEL_BUCKET = registerBucketItem("gray_gel_bucket");
        // light gray
        public static final Supplier<Item> LIGHT_GRAY_GEL_BUCKET = registerBucketItem("light_gray_gel_bucket");
        // cyan
        public static final Supplier<Item> CYAN_GEL_BUCKET = registerBucketItem("cyan_gel_bucket");
        // purple
        public static final Supplier<Item> PURPLE_GEL_BUCKET = registerBucketItem("purple_gel_bucket");
        // blue
        public static final Supplier<Item> BLUE_GEL_BUCKET = registerBucketItem("blue_gel_bucket");
        // brown
        public static final Supplier<Item> BROWN_GEL_BUCKET = registerBucketItem("brown_gel_bucket");
        // green
        public static final Supplier<Item> GREEN_GEL_BUCKET = registerBucketItem("green_gel_bucket");
        // red
        public static final Supplier<Item> RED_GEL_BUCKET = registerBucketItem("red_gel_bucket");
        // black
        public static final Supplier<Item> BLACK_GEL_BUCKET = registerBucketItem("black_gel_bucket");

        // Honey Bucket
        public static final Supplier<HoneyBucketItem> HONEY_BUCKET = ModRegistry.registerItem("honey_bucket",
                        () -> new HoneyBucketItem(defaultProperties()));

        // Default Item Properties
        public static Item.Properties defaultProperties() {
                return new Item.Properties().tab(ModCreativeTab.TAB);
        }

        // Register Bucket Item
        private static Supplier<Item> registerBucketItem(String name) {
                return registerItem(name,
                                defaultProperties().stacksTo(1));
        }

        // Register Item and add it to the Creative Tab
        private static Supplier<Item> registerItem(String name, Item.Properties itemProperties) {
                return ModRegistry.registerItem(name, () -> new Item(itemProperties));
        }

        // Register Item
        private static Supplier<Item> registerItemHidden(String name) {
                return ModRegistry.registerItem(name, () -> new Item(new Item.Properties()));
        }

        public static void init() {
        }
}
