package dev.danmizu.vanillaful.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.danmizu.vanillaful.registry.ModBlocks;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    private LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "handleOnClimbable", at = @At(value = "TAIL"), cancellable = true)
    public void vanillaful_iron_ladder_handleOnClimbable(Vec3 motion, CallbackInfoReturnable<Vec3> cir) {
        // Get LivingEntity
        LivingEntity livingEntity = (LivingEntity) (Object) this;

        // Do nothing if entity isn't a player, is on the ground, or is sneaking.
        if (!(livingEntity instanceof Player) || this.onGround || livingEntity.isCrouching()) {
            return;
        }

        // Do nothing if the block they're climbing isn't an Iron Ladder
        if (!livingEntity.getFeetBlockState().is(ModBlocks.IRON_LADDER.get()))
            return;

        // Change climb speed if player isn't flying (creative mode) and they are
        // attempting to go up/down
        if (isEntityLookingUpOrDown(livingEntity) && !isEntityFlying(livingEntity)) {
            // Get current Y velocity
            Vec3 vec3 = cir.getReturnValue();
            double y = vec3.y();

            // Player is moving forward
            if (isEntityMovingForward(livingEntity)) {
                // Player is looking up
                if (isEntityLookingUp(livingEntity)) {
                    // Change climb speed
                    y = getClimbingSpeedChange((Player) livingEntity);

                    // Return Y velocity change
                    cir.setReturnValue(new Vec3(vec3.x(), y, vec3.z()));
                }
            }

            // Player is not moving forward or backward but is looking down
            else if (!isEntityMovingBackward(livingEntity) && isEntityLookingDown(livingEntity)) {
                // Change climb speed
                y = getClimbingSpeedChange((Player) livingEntity) * -1;

                // Return Y velocity change
                cir.setReturnValue(new Vec3(vec3.x(), y, vec3.z()));
            }
        }
    }

    private boolean isEntityFlying(LivingEntity livingEntity) {
        Player player = (Player) livingEntity;
        return player.getAbilities().flying;
    }

    private boolean isEntityLookingUp(LivingEntity livingEntity) {
        return livingEntity.getXRot() < 0;
    }

    private boolean isEntityLookingDown(LivingEntity livingEntity) {
        return livingEntity.getXRot() > 0;
    }

    private boolean isEntityLookingUpOrDown(LivingEntity livingEntity) {
        return livingEntity.getXRot() != 0;
    }

    private boolean isEntityMovingForward(LivingEntity livingEntity) {
        return livingEntity.zza > 0;
    }

    private boolean isEntityMovingBackward(LivingEntity livingEntity) {
        return livingEntity.zza < 0;
    }

    private float getClimbingSpeedChange(Player player) {
        return (float) (Math.abs(player.getXRot() / 90.0) * 0.4);
    }
}