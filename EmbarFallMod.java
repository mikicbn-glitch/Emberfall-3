package com.embarfall;

import com.embarfall.block.ModBlocks;
import com.embarfall.entity.ModEntities;
import com.embarfall.entity.custom.KorZombisiEntity;
import com.embarfall.entity.custom.KulIskeletiEntity;
import com.embarfall.item.ModItemGroups;
import com.embarfall.item.ModItems;
import com.embarfall.world.biome.ModBiomes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmbarFallMod implements ModInitializer {

    public static final String MOD_ID = "embarfall";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Embar Fall modu yukleniyor...");

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModItemGroups.registerModItemGroups();
        ModEntities.registerModEntities();
        ModBiomes.registerModBiomes();

        FabricDefaultAttributeRegistry.register(ModEntities.KUL_ISKELETI,
                KulIskeletiEntity.createAshSkeletonAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.KOR_ZOMBISI,
                KorZombisiEntity.createEmberZombieAttributes());

        LOGGER.info("Embar Fall modu hazir.");
    }
}
