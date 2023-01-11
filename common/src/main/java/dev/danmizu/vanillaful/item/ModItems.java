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
    public static final RegistrySupplier<Item> GEL_BUCKET = registerGelBucketItem("gel_bucket");
    // white
    public static final RegistrySupplier<Item> WHITE_GEL_BUCKET = registerGelBucketItem("white_gel_bucket");
    // orange
    public static final RegistrySupplier<Item> ORANGE_GEL_BUCKET = registerGelBucketItem("orange_gel_bucket");
    // magenta
    public static final RegistrySupplier<Item> MAGENTA_GEL_BUCKET = registerGelBucketItem("magenta_gel_bucket");
    // light blue
    public static final RegistrySupplier<Item> LIGHT_BLUE_GEL_BUCKET = registerGelBucketItem("light_blue_gel_bucket");
    // yellow
    public static final RegistrySupplier<Item> YELLOW_GEL_BUCKET = registerGelBucketItem("yellow_gel_bucket");
    // lime
    public static final RegistrySupplier<Item> LIME_GEL_BUCKET = registerGelBucketItem("lime_gel_bucket");
    // pink
    public static final RegistrySupplier<Item> PINK_GEL_BUCKET = registerGelBucketItem("pink_gel_bucket");
    // gray
    public static final RegistrySupplier<Item> GRAY_GEL_BUCKET = registerGelBucketItem("gray_gel_bucket");
    // light gray
    public static final RegistrySupplier<Item> LIGHT_GRAY_GEL_BUCKET = registerGelBucketItem("light_gray_gel_bucket");
    // cyan
    public static final RegistrySupplier<Item> CYAN_GEL_BUCKET = registerGelBucketItem("cyan_gel_bucket");
    // purple
    public static final RegistrySupplier<Item> PURPLE_GEL_BUCKET = registerGelBucketItem("purple_gel_bucket");
    // blue
    public static final RegistrySupplier<Item> BLUE_GEL_BUCKET = registerGelBucketItem("blue_gel_bucket");
    // brown
    public static final RegistrySupplier<Item> BROWN_GEL_BUCKET = registerGelBucketItem("brown_gel_bucket");
    // green
    public static final RegistrySupplier<Item> GREEN_GEL_BUCKET = registerGelBucketItem("green_gel_bucket");
    // red
    public static final RegistrySupplier<Item> RED_GEL_BUCKET = registerGelBucketItem("red_gel_bucket");
    // black
    public static final RegistrySupplier<Item> BLACK_GEL_BUCKET = registerGelBucketItem("black_gel_bucket");

    // Honey Bucket

    // register gel bucket items
    private static RegistrySupplier<Item> registerGelBucketItem(String id) {
        return ITEMS.register(id,
                () -> new Item(new Item.Properties().tab(ModCreativeTabs.TAB).stacksTo(1)));
    }
    // private static RegistrySupplier<Item> registerGelBucketItem(String id) {
    //     return ITEMS.register(id,
    //             () -> new ArchitecturyBucketItem(ModFluids.GEL, new Item.Properties().tab(ModCreativeTabs.TAB).craftRemainder(Items.BUCKET).stacksTo(1)));
    // }

    // register item
    private static RegistrySupplier<Item> registerItem(String id) {
        return ITEMS.register(id, () -> new Item(new Item.Properties()));
    }

    public static void register() {
        ITEMS.register();
    }
}
