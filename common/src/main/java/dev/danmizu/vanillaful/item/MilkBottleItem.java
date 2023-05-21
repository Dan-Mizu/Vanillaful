package dev.danmizu.vanillaful.item;

import dev.danmizu.vanillaful.registry.ModFoods;
import dev.danmizu.vanillaful.registry.ModItems;
import java.util.Collection;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class MilkBottleItem extends HoneyBottleItem {

	public MilkBottleItem(Properties properties) {
		super(properties.stacksTo(16).food(ModFoods.MILK_BOTTLE));
	}

	public static final int DRINK_DURATION = 20;

	@Override
	public ItemStack finishUsingItem(
		ItemStack stack,
		Level level,
		LivingEntity livingEntity
	) {
		// Get entities's active effects
		Collection<MobEffectInstance> activeEffects = livingEntity.getActiveEffects();

		// Remove random effect (if they have any)
		if (activeEffects != null && !activeEffects.isEmpty()) {
			livingEntity.removeEffect(
				activeEffects
					.stream()
					.skip((int) (activeEffects.size() * Math.random()))
					.findFirst()
					.get()
					.getEffect()
			);
		}

		// Don't consume if in creative mode
		if (((Player) livingEntity).isCreative()) {
			return new ItemStack(ModItems.MILK_BOTTLE.get(), stack.getCount());
		}
		// Survival Mode
		else {
			// give empty bottle
			((Player) livingEntity).addItem(new ItemStack(Items.GLASS_BOTTLE));

			// finish stack
			if (stack.getCount() == 1) {
				return new ItemStack(Items.AIR);
			}
			// reduce stack
			else {
				return new ItemStack(
					ModItems.MILK_BOTTLE.get(),
					stack.getCount() - 1
				);
			}
		}
	}
}
