package dev.danmizu.vanillaful.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// import dev.danmizu.vanillaful.Main;

@Mixin(TitleScreen.class)
public class VanillafulMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		// Main.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
