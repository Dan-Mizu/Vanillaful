package dev.danmizu.vanillaful.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import dev.danmizu.vanillaful.Vanillaful;
import dev.danmizu.vanillaful.util.ModInfo;

@Mod(ModInfo.MOD_ID)
public class VanillafulForge {
    public VanillafulForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ModInfo.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Vanillaful.init();
    }
}
