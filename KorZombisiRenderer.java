package com.embarfall.client;

import com.embarfall.EmbarFallMod;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Vanilla zombi modelini/animasyonlarini aynen kullanir, sadece
 * dokuyu Embar Fall'a ozel olanla degistirir.
 */
public class KorZombisiRenderer extends ZombieEntityRenderer {

    private static final Identifier TEXTURE =
            Identifier.of(EmbarFallMod.MOD_ID, "textures/entity/ember_zombie.png");

    public KorZombisiRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public Identifier getTexture(net.minecraft.entity.mob.ZombieEntity entity) {
        return TEXTURE;
    }
}
