package dev.danmizu.vanillaful.registry;

import dev.danmizu.vanillaful.util.ModInfo;
import earth.terrarium.botarium.api.registry.fluid.FluidData;
import earth.terrarium.botarium.api.registry.fluid.FluidProperties;
import earth.terrarium.botarium.api.registry.fluid.FluidRegistry;
import net.minecraft.resources.ResourceLocation;

public class ModFluidProperties {

	public static final FluidRegistry FLUID_TYPES = new FluidRegistry(
		ModInfo.MOD_ID
	);

	public static final FluidData GEL_FLUID = FLUID_TYPES.register(
		"gel",
		FluidProperties
			.create()
			.still(new ResourceLocation(ModInfo.MOD_ID, "block/gel_still"))
			.flowing(new ResourceLocation(ModInfo.MOD_ID, "block/gel_flow"))
			.overlay(new ResourceLocation(ModInfo.MOD_ID, "block/gel_overlay"))
			.viscosity(2000)
			.density(2000)
			.canConvertToSource(false)
	);

    public static void init() {
        FLUID_TYPES.initialize();
    }
}
