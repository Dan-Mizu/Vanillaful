package dev.danmizu.vanillaful.item;

import dev.danmizu.vanillaful.registry.ModFoods;
import dev.danmizu.vanillaful.registry.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class HoneyBucketItem extends HoneyBottleItem {

	public HoneyBucketItem(Properties properties) {
		super(properties.stacksTo(1).food(ModFoods.HONEY_BUCKET));
	}

	public static final int DRINK_DURATION = 60;

	@Override
	public ItemStack finishUsingItem(
		ItemStack stack,
		Level level,
		LivingEntity livingEntity
	) {
		// Remove Poison effect
		livingEntity.removeEffect(MobEffects.POISON);

		// Provide food effects
		livingEntity.eat(level, stack);

		// Don't consume if in creative mode
		if (((Player) livingEntity).isCreative()) {
			return new ItemStack(ModItems.HONEY_BUCKET.get());
		} else {
			return new ItemStack(Items.BUCKET);
		}
	}
}
