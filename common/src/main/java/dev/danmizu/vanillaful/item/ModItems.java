package dev.danmizu.vanillaful.item;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.world.item.Item;
import net.minecraft.core.Registry;
import dev.architectury.registry.registries.RegistrySupplier;

import dev.danmizu.vanillaful.gui.ModCreativeTabs;
import dev.danmizu.vanillaful.util.ModInfo;

public class ModItems {
    // init registry
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ModInfo.MOD_ID, Registry.ITEM_REGISTRY);

    // Mod Icon
    public static final RegistrySupplier<Item> ICON = registerItem("icon");

    /// Gel Buckets
    // default
    public static final RegistrySupplier<Item> GEL_BUCKET = registerBucketItem("gel_bucket");
    // white
    public static final RegistrySupplier<Item> WHITE_GEL_BUCKET = registerBucketItem("white_gel_bucket");
    // orange
    public static final RegistrySupplier<Item> ORANGE_GEL_BUCKET = registerBucketItem("orange_gel_bucket");
    // magenta
    public static final RegistrySupplier<Item> MAGENTA_GEL_BUCKET = registerBucketItem("magenta_gel_bucket");
    // light blue
    public static final RegistrySupplier<Item> LIGHT_BLUE_GEL_BUCKET = registerBucketItem("light_blue_gel_bucket");
    // yellow
    public static final RegistrySupplier<Item> YELLOW_GEL_BUCKET = registerBucketItem("yellow_gel_bucket");
    // lime
    public static final RegistrySupplier<Item> LIME_GEL_BUCKET = registerBucketItem("lime_gel_bucket");
    // pink
    public static final RegistrySupplier<Item> PINK_GEL_BUCKET = registerBucketItem("pink_gel_bucket");
    // gray
    public static final RegistrySupplier<Item> GRAY_GEL_BUCKET = registerBucketItem("gray_gel_bucket");
    // light gray
    public static final RegistrySupplier<Item> LIGHT_GRAY_GEL_BUCKET = registerBucketItem("light_gray_gel_bucket");
    // cyan
    public static final RegistrySupplier<Item> CYAN_GEL_BUCKET = registerBucketItem("cyan_gel_bucket");
    // purple
    public static final RegistrySupplier<Item> PURPLE_GEL_BUCKET = registerBucketItem("purple_gel_bucket");
    // blue
    public static final RegistrySupplier<Item> BLUE_GEL_BUCKET = registerBucketItem("blue_gel_bucket");
    // brown
    public static final RegistrySupplier<Item> BROWN_GEL_BUCKET = registerBucketItem("brown_gel_bucket");
    // green
    public static final RegistrySupplier<Item> GREEN_GEL_BUCKET = registerBucketItem("green_gel_bucket");
    // red
    public static final RegistrySupplier<Item> RED_GEL_BUCKET = registerBucketItem("red_gel_bucket");
    // black
    public static final RegistrySupplier<Item> BLACK_GEL_BUCKET = registerBucketItem("black_gel_bucket");

    // Honey Bucket
    public static final RegistrySupplier<Item> HONEY_BUCKET = registerBucketItem("honey_bucket");

    // register gel bucket items
    private static RegistrySupplier<Item> registerBucketItem(String id) {
        return ITEMS.register(id,
                () -> new Item(new Item.Properties().tab(ModCreativeTabs.TAB).stacksTo(1)));
    }
    // private static RegistrySupplier<Item> registerBucketItem(String id) {
    // return ITEMS.register(id,
    // () -> new ArchitecturyBucketItem(ModFluids.GEL, new
    // Item.Properties().tab(ModCreativeTabs.TAB).craftRemainder(Items.BUCKET).stacksTo(1)));
    // }

    // register item
    private static RegistrySupplier<Item> registerItem(String id) {
        return ITEMS.register(id, () -> new Item(new Item.Properties()));
    }

    public static void register() {
        ITEMS.register();
    }
}
