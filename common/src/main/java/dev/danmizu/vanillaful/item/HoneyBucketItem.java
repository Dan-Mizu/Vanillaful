package dev.danmizu.vanillaful.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoneyBottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import dev.danmizu.vanillaful.registry.ModFoods;

public class HoneyBucketItem extends HoneyBottleItem {
    public HoneyBucketItem(Properties properties) {
        super(properties.stacksTo(1).food(ModFoods.HONEY_BUCKET));
    }

    public static final int DRINK_DURATION = 60;

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        // Remove Poison effect
        livingEntity.removeEffect(MobEffects.POISON);

        // Provide Honey Bucket food effects to player
        livingEntity.eat(level, stack);

        // Give back bucket on consumption
        return new ItemStack(Items.BUCKET);
    }
}
