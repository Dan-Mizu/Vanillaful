package dev.danmizu.vanillaful.registry;

import earth.terrarium.botarium.api.registry.fluid.BotariumFlowingFluid;
import earth.terrarium.botarium.api.registry.fluid.BotariumSourceFluid;
import java.util.function.Supplier;
import net.minecraft.world.level.material.FlowingFluid;

public class ModFluids {

	public static final Supplier<FlowingFluid> GEL = ModRegistry.registerFluid(
		"gel",
		() -> new BotariumSourceFluid(ModFluidProperties.GEL_FLUID)
	);
	public static final Supplier<FlowingFluid> FLOWING_OIL = ModRegistry.registerFluid(
		"flowing_gel",
		() -> new BotariumFlowingFluid(ModFluidProperties.GEL_FLUID)
	);

	public static void init() {}
}
