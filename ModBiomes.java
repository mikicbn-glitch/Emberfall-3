package com.embarfall.world.biome;

import com.embarfall.EmbarFallMod;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

/**
 * "Yanmis Topraklar" biyomunun kaydi. Biyomun kendisi
 * data/embarfall/worldgen/biome/burnt_lands.json dosyasinda tanimli;
 * burada sadece Overworld uretimine eklenmesini sagliyoruz.
 *
 * NOT: net.fabricmc.fabric.api.biome.v1 paketindeki OverworldBiomes
 * metod imzalari Fabric API surumune gore degisebilir. Eger IDE
 * derleme hatasi verirse, Fabric API'nin "Custom Biome API" wiki
 * sayfasindaki guncel ornegi kullanarak bu sinifi uyarlayabilirsin.
 */
public class ModBiomes {

    public static final RegistryKey<Biome> BURNT_LANDS = RegistryKey.of(
            RegistryKeys.BIOME, Identifier.of(EmbarFallMod.MOD_ID, "burnt_lands"));

    public static void registerModBiomes() {
        OverworldBiomes.addContinentalBiome(BURNT_LANDS, OverworldClimate.DRY, 0.15);
        EmbarFallMod.LOGGER.info("Embar Fall: Yanmis Topraklar biyomu Overworld'e eklendi");
    }
}
