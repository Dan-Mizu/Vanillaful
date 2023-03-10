package dev.danmizu.vanillaful.forge;

import dev.danmizu.vanillaful.client.VanillafulClient;
import dev.danmizu.vanillaful.util.ModInfo;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
	modid = ModInfo.MOD_ID,
	bus = Mod.EventBusSubscriber.Bus.MOD
)
public class VanillafulForgeClient {

	@SubscribeEvent
	public static void init(FMLClientSetupEvent event) {
		VanillafulClient.init();
	}

	@SubscribeEvent
	public static void registerLayerDefinitions(
		EntityRenderersEvent.RegisterLayerDefinitions event
	) {}
}
