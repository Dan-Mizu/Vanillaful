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
