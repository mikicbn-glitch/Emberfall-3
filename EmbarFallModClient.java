package com.embarfall.client;

import com.embarfall.entity.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class EmbarFallModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.KUL_ISKELETI, KulIskeletiRenderer::new);
        EntityRendererRegistry.register(ModEntities.KOR_ZOMBISI, KorZombisiRenderer::new);
    }
}
