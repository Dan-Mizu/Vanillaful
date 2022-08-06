package dev.danmizu.vanillaful.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.danmizu.vanillaful.Main;
// import dev.danmizu.vanillaful.config.ModConfig;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    private LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "applyClimbingSpeed", at = @At(value = "TAIL"), cancellable = true)
    public void adjustClimbingSpeed(Vec3d motion, CallbackInfoReturnable<Vec3d> cir) {
        LivingEntity livingEntity = (LivingEntity) (Object) this;

        // Do nothing if entity isn't climbing, or is sneaking, or isn't a player
        if (!livingEntity.isClimbing() || livingEntity.isSneaking() || !(livingEntity.isPlayer())) {
            return;
        }

        // Do nothing if the block they're climbing isnt an Iron Ladder
        if (!livingEntity.getBlockStateAtPos().isOf(Main.IRON_LADDER)) return;

        // Change climb speed dependant on key pressed and look direction if player isnt flying or looking up/down
        if (isEntityLookingUpOrDown(livingEntity) && !isEntityFlying(livingEntity)) {
            Vec3d vec3d = cir.getReturnValue();
            double y = vec3d.getY();

            // Go up faster if player is holding forward key and looking up
            if(!isEntityStill(livingEntity) && isEntityLookingUp(livingEntity)) {
                y = getNormalizedPitch(livingEntity.getPitch()) * 0.4;
            }
            
            // Go down faster if looking down and not holding forward key
            if (isEntityStill(livingEntity) && isEntityLookingDown(livingEntity)) {
                y = getNormalizedPitch(livingEntity.getPitch()) * 0.4 * -1.0;
            }

            // if (isEntityLookingUp(livingEntity)) {
            //     y = getNormalizedPitch(livingEntity.getPitch()) * ModConfig.get().ironLadderClimbUpSpeed;
            // } else if (isEntityLookingDown(livingEntity)) {
            //     y = getNormalizedPitch(livingEntity.getPitch()) * ModConfig.get().ironLadderClimbDownSpeed * -1.0;
            // }
            cir.setReturnValue(new Vec3d(vec3d.getX(), y, vec3d.getZ()));
        }
    }

    private boolean isEntityFlying(LivingEntity livingEntity) {
        PlayerEntity player = (PlayerEntity) livingEntity;
        return player.getAbilities().flying;
    }

    private boolean isEntityLookingUp(LivingEntity livingEntity) {
        return livingEntity.getPitch() < 0;
    }

    private boolean isEntityLookingDown(LivingEntity livingEntity) {
        return livingEntity.getPitch() > 0;
    }

    private boolean isEntityLookingUpOrDown(LivingEntity livingEntity) {
        return livingEntity.getPitch() != 0;
    }

    private boolean isEntityStill(LivingEntity livingEntity) {
        return livingEntity.forwardSpeed == 0;
    }

    private double getNormalizedPitch(float pitch) {
        return Math.abs(pitch / 90.0);
    }
}