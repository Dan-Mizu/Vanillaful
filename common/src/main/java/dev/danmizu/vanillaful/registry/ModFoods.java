package dev.danmizu.vanillaful.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

	// Honey Bucket
	public static final FoodProperties HONEY_BUCKET =
		(new FoodProperties.Builder()).nutrition(8)
			.saturationMod(6F)
			.effect(
				new MobEffectInstance(MobEffects.REGENERATION, 100, 0),
				1.0F
			)
			.build();

	// Milk Bottle
	public static final FoodProperties MILK_BOTTLE =
		(new FoodProperties.Builder()).build();
}
