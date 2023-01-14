package dev.danmizu.vanillaful.fabric;

import net.fabricmc.api.ClientModInitializer;

public class VanillafulFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        dev.danmizu.vanillaful.client.VanillafulClient.init();
        // BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
        // AFBlocks.OAK_TABLE.get(),
        // );
    }
}
