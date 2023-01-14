package dev.danmizu.vanillaful.registry;

import java.util.function.Supplier;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import dev.danmizu.vanillaful.util.ModInfo;

public class ModSoundEvents {

    public static Supplier<SoundEvent> register(String name) {
        return ModRegistry.registerSoundEvent(name, () -> new SoundEvent(new ResourceLocation(ModInfo.MOD_ID, name)));
    }

    public static void init() {
    }
}
