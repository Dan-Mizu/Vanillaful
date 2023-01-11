package dev.danmizu.vanillaful.block;

// import dev.architectury.core.block.ArchitecturyLiquidBlock;
import dev.architectury.registry.registries.DeferredRegister;
// import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;
// import net.minecraft.world.level.block.Blocks;
// import net.minecraft.world.level.block.LiquidBlock;
// import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.Registry;

// import dev.danmizu.vanillaful.fluid.ModFluids;
import dev.danmizu.vanillaful.util.ModInfo;

public class ModBlocks {
    // init registry
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ModInfo.MOD_ID,
            Registry.BLOCK_REGISTRY);

    /// Fluid Blocks
    // public static final RegistrySupplier<LiquidBlock> GEL_FLUID_BLOCK = BLOCKS.register("gel", () -> new ArchitecturyLiquidBlock(ModFluids.GEL, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static void register() {
        BLOCKS.register();
    }
}
