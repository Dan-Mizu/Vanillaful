package dev.danmizu.vanillaful.block;

import java.util.function.Supplier;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
// import dev.architectury.core.block.ArchitecturyLiquidBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.Registry;

import dev.danmizu.vanillaful.item.ModItems;
// import dev.danmizu.vanillaful.fluid.ModFluids;
import dev.danmizu.vanillaful.util.ModInfo;

public class ModBlocks {
    // init registry
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ModInfo.MOD_ID,
            Registry.BLOCK_REGISTRY);

    /// Fluid Blocks
    // public static final RegistrySupplier<LiquidBlock> GEL_FLUID_BLOCK =
    /// BLOCKS.register("gel", () -> new ArchitecturyLiquidBlock(ModFluids.GEL,
    /// BlockBehaviour.Properties.copy(Blocks.WATER)));

    // Gel Blocks
    // default
    public static final RegistrySupplier<GelBlock> GEL_BLOCK = registerGelBlock("gel_block");
    // white
    public static final RegistrySupplier<GelBlock> WHITE_GEL_BLOCK = registerGelBlock("white_gel_block");
    // orange
    public static final RegistrySupplier<GelBlock> ORANGE_GEL_BLOCK = registerGelBlock("orange_gel_block");
    // magenta
    public static final RegistrySupplier<GelBlock> MAGENTA_GEL_BLOCK = registerGelBlock("magenta_gel_block");
    // light blue
    public static final RegistrySupplier<GelBlock> LIGHT_BLUE_GEL_BLOCK = registerGelBlock("light_blue_gel_block");
    // yellow
    public static final RegistrySupplier<GelBlock> YELLOW_GEL_BLOCK = registerGelBlock("yellow_gel_block");
    // lime
    public static final RegistrySupplier<GelBlock> LIME_GEL_BLOCK = registerGelBlock("lime_gel_block");
    // pink
    public static final RegistrySupplier<GelBlock> PINK_GEL_BLOCK = registerGelBlock("pink_gel_block");
    // gray
    public static final RegistrySupplier<GelBlock> GRAY_GEL_BLOCK = registerGelBlock("gray_gel_block");
    // light gray
    public static final RegistrySupplier<GelBlock> LIGHT_GRAY_GEL_BLOCK = registerGelBlock("light_gray_gel_block");
    // cyan
    public static final RegistrySupplier<GelBlock> CYAN_GEL_BLOCK = registerGelBlock("cyan_gel_block");
    // purple
    public static final RegistrySupplier<GelBlock> PURPLE_GEL_BLOCK = registerGelBlock("purple_gel_block");
    // blue
    public static final RegistrySupplier<GelBlock> BLUE_GEL_BLOCK = registerGelBlock("blue_gel_block");
    // brown
    public static final RegistrySupplier<GelBlock> BROWN_GEL_BLOCK = registerGelBlock("brown_gel_block");
    // green
    public static final RegistrySupplier<GelBlock> GREEN_GEL_BLOCK = registerGelBlock("green_gel_block");
    // red
    public static final RegistrySupplier<GelBlock> RED_GEL_BLOCK = registerGelBlock("red_gel_block");
    // black
    public static final RegistrySupplier<GelBlock> BLACK_GEL_BLOCK = registerGelBlock("black_gel_block");

    // Register Gel Block
    public static RegistrySupplier<GelBlock> registerGelBlock(String name) {
        return registerBlockWithItem(name,
                () -> new GelBlock(),
                ModItems.defaultProperties());
    }

    // Register Block with Block Item
    public static <T extends Block> RegistrySupplier<T> registerBlockWithItem(String name, Supplier<T> supplier,
            Item.Properties properties) {
        // register block
        RegistrySupplier<T> block = BLOCKS.register(name, supplier);

        // register item
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));

        return block;
    }
}
