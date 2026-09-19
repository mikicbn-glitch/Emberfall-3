package com.embarfall.entity;

import com.embarfall.EmbarFallMod;
import com.embarfall.entity.custom.KorZombisiEntity;
import com.embarfall.entity.custom.KulIskeletiEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

/**
 * Biyoma ozgu iki yeni mob: Kul Iskeleti (ates okuyla saldiran iskelet
 * varyanti) ve Kor Zombisi (ates hasari veren zombi varyanti).
 * Ikisi de vanilla Skeleton/Zombie'yi genisletir, boylece mevcut
 * animasyon ve model altyapisini yeniden kullanirlar - sadece dokusu
 * ve davranisi degisir.
 */
public class ModEntities {

    public static final EntityType<KulIskeletiEntity> KUL_ISKELETI = register("ash_skeleton",
            EntityType.Builder.create(KulIskeletiEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.99f));

    public static final EntityType<KorZombisiEntity> KOR_ZOMBISI = register("ember_zombie",
            EntityType.Builder.create(KorZombisiEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6f, 1.95f));

    @SuppressWarnings("unchecked")
    private static <T extends net.minecraft.entity.Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        Identifier id = Identifier.of(EmbarFallMod.MOD_ID, name);
        RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);
        EntityType<T> type = builder.build(key);
        return Registry.register(Registries.ENTITY_TYPE, id, type);
    }

    public static void registerModEntities() {
        EmbarFallMod.LOGGER.info("Embar Fall: mob turleri kaydedildi");
    }
}
