package com.embarfall.item;

import com.embarfall.EmbarFallMod;
import com.embarfall.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * Tum Embar Fall esyalarinin ve bloklarinin goruldugu ozel yaraticilik
 * sekmesi.
 */
public class ModItemGroups {

    public static final ItemGroup EMBAR_FALL_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(EmbarFallMod.MOD_ID, "embarfall"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.EMBER_WAND))
                    .displayName(Text.translatable("itemGroup.embarfall"))
                    .entries((displayContext, entries) -> {
                        // Bloklar
                        entries.add(ModBlocks.VOLCANIC_ROCK);
                        entries.add(ModBlocks.ASH_BLOCK);
                        entries.add(ModBlocks.CHARRED_LOG);
                        entries.add(ModBlocks.EMBER_ORE);
                        entries.add(ModBlocks.MOLTEN_OBSIDIAN);
                        entries.add(ModBlocks.SCORCHED_DIRT);
                        entries.add(ModBlocks.SULFUR_CRYSTAL_BLOCK);
                        entries.add(ModBlocks.CRACKED_BASALT);
                        entries.add(ModBlocks.ASHEN_GRASS_BLOCK);
                        entries.add(ModBlocks.EMBER_LANTERN);

                        // Esyalar
                        entries.add(ModItems.EMBER_DUST);
                        entries.add(ModItems.SULFUR_DUST);
                        entries.add(ModItems.ASH_RUNE);
                        entries.add(ModItems.EMBER_WAND);
                        entries.add(ModItems.SCROLL_OF_FLAMES);
                        entries.add(ModItems.EMBER_AMULET);

                        // 12 Ozel Kristal
                        entries.add(ModItems.EMBER_CRYSTAL);
                        entries.add(ModItems.ASH_CRYSTAL);
                        entries.add(ModItems.SULFUR_CRYSTAL);
                        entries.add(ModItems.MAGMA_CRYSTAL);
                        entries.add(ModItems.OBSIDIAN_CRYSTAL);
                        entries.add(ModItems.BASALT_CRYSTAL);
                        entries.add(ModItems.SMOKE_CRYSTAL);
                        entries.add(ModItems.FLAME_CRYSTAL);
                        entries.add(ModItems.CHARCOAL_CRYSTAL);
                        entries.add(ModItems.VOLCANIC_CRYSTAL);
                        entries.add(ModItems.PHOENIX_CRYSTAL);
                        entries.add(ModItems.BLOOD_EMBER_CRYSTAL);

                        // Spawn yumurtalari
                        entries.add(ModItems.KUL_ISKELETI_SPAWN_EGG);
                        entries.add(ModItems.KOR_ZOMBISI_SPAWN_EGG);
                    })
                    .build());

    public static void registerModItemGroups() {
        EmbarFallMod.LOGGER.info("Embar Fall: yaraticilik sekmesi kaydedildi");
    }
}
