package dev.danmizu.vanillaful.forge;

import dev.danmizu.vanillaful.Vanillaful;
import dev.danmizu.vanillaful.registry.forge.ModRegistryImpl;
import dev.danmizu.vanillaful.util.ModInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModInfo.MOD_ID)
public class VanillafulForge {

	public VanillafulForge() {
		Vanillaful.init();

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ModRegistryImpl.FLUIDS.register(bus);
		ModRegistryImpl.BLOCKS.register(bus);
		ModRegistryImpl.ITEMS.register(bus);
		ModRegistryImpl.SOUND_EVENTS.register(bus);
		ModRegistryImpl.ENTITY_TYPES.register(bus);
		ModRegistryImpl.BLOCK_ENTITY_TYPES.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}
}
