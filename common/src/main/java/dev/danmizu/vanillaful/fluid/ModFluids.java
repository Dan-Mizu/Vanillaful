package dev.danmizu.vanillaful.fluid;

// import dev.architectury.core.fluid.ArchitecturyFlowingFluid;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.core.Registry;
// import dev.architectury.registry.registries.RegistrySupplier;

import dev.danmizu.vanillaful.util.ModInfo;

public class ModFluids {
    // init registry
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ModInfo.MOD_ID,
            Registry.FLUID_REGISTRY);

    // /// Gel
    // // default
    // public static final RegistrySupplier<Fluid> GEL = registerGelFluidSource("gel");
    // public static final RegistrySupplier<Fluid> GEL_FLOWING = registerGelFluidFlowing("gel_flowing");

    // // register gel fluids
    // private static RegistrySupplier<Fluid> registerGelFluidSource(String id) {
    //     return FLUIDS.register(id,
    //             () -> new ArchitecturyFlowingFluid.Source(ModFluidAttributes.GEL_FLUID_ATTRIBUTES));
    // }

    // private static RegistrySupplier<Fluid> registerGelFluidFlowing(String id) {
    //     return FLUIDS.register(id,
    //             () -> new ArchitecturyFlowingFluid.Flowing(ModFluidAttributes.GEL_FLUID_ATTRIBUTES));
    // }

    public static void register() {
        FLUIDS.register();
    }
}
