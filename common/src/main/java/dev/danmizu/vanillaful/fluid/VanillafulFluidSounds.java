package dev.danmizu.vanillaful.fluid;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.sounds.SoundEvent;

public class VanillafulFluidSounds {

	private final Map<String, SoundEvent> sounds = new HashMap<>();

	public void addSound(String name, SoundEvent sound) {
		sounds.put(name, sound);
	}

	public SoundEvent getSound(String name) {
		return sounds.get(name);
	}

	public Map<String, SoundEvent> getSounds() {
		return sounds;
	}
}
