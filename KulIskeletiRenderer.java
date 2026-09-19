package com.embarfall.client;

import com.embarfall.EmbarFallMod;
import com.embarfall.entity.custom.KulIskeletiEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Vanilla iskelet modelini/animasyonlarini aynen kullanir, sadece
 * dokuyu Embar Fall'a ozel olanla degistirir.
 */
public class KulIskeletiRenderer extends SkeletonEntityRenderer {

    private static final Identifier TEXTURE =
            Identifier.of(EmbarFallMod.MOD_ID, "textures/entity/ash_skeleton.png");

    public KulIskeletiRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(net.minecraft.entity.mob.SkeletonEntity entity) {
        return TEXTURE;
    }
}
