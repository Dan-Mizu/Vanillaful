package dev.danmizu.vanillaful.mixin;

// Minecraft Imports
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

// Sponge Imports
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// Local Imports
import dev.danmizu.vanillaful.block.ModBlocks;

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
        if (!livingEntity.getBlockStateAtPos().isOf(ModBlocks.IRON_LADDER)) return;

        // Change climb speed dependant on key pressed and look direction if player isnt flying or looking up/down
        if (isEntityLookingUpOrDown(livingEntity) && !isPlayerFlying((PlayerEntity) livingEntity)) {
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

            // New Speed
            cir.setReturnValue(new Vec3d(vec3d.getX(), y, vec3d.getZ()));
        }
    }

    // Player is Flying (Creative Mode)
    private boolean isPlayerFlying(PlayerEntity player) {
        return player.getAbilities().flying;
    }

    // Entity is Looking Up
    private boolean isEntityLookingUp(LivingEntity livingEntity) {
        return livingEntity.getPitch() < 0;
    }

    // Entity is Looking Down
    private boolean isEntityLookingDown(LivingEntity livingEntity) {
        return livingEntity.getPitch() > 0;
    }

    // Entity is Looking either Up or Down
    private boolean isEntityLookingUpOrDown(LivingEntity livingEntity) {
        return livingEntity.getPitch() != 0;
    }

    // Entity is not Moving Forward
    private boolean isEntityStill(LivingEntity livingEntity) {
        return livingEntity.forwardSpeed == 0;
    }

    // Get the Normalized Pitch
    private double getNormalizedPitch(float pitch) {
        return Math.abs(pitch / 90.0);
    }
}