package com.embarfall.item;

import com.embarfall.EmbarFallMod;
import com.embarfall.entity.ModEntities;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

/**
 * Ortacag-buyu tarzi esyalar: hammadde, asa, tomar ve muska.
 */
public class ModItems {

    // --- Hammaddeler ---
    public static final Item EMBER_DUST = registerItem("ember_dust", new Item(new Item.Settings()));
    public static final Item SULFUR_DUST = registerItem("sulfur_dust", new Item(new Item.Settings()));
    public static final Item ASH_RUNE = registerItem("ash_rune", new Item(new Item.Settings().rarity(net.minecraft.util.Rarity.UNCOMMON)));

    // --- Buyulu esyalar ---
    public static final Item EMBER_WAND = registerItem("ember_wand",
            new EmberWandItem(new Item.Settings().maxCount(1).maxDamage(64)));

    public static final Item SCROLL_OF_FLAMES = registerItem("scroll_of_flames",
            new ScrollOfFlamesItem(new Item.Settings().maxCount(8)));

    public static final Item EMBER_AMULET = registerItem("ember_amulet",
            new Item(new Item.Settings().maxCount(1).rarity(net.minecraft.util.Rarity.RARE)));

    // --- 12 Ozel Kristal ---
    // Her biri kalicidir (tuketilmez), sag tik ile kisa sureli bir etki
    // verir ve ardindan bekleme suresine girer.
    public static final Item EMBER_CRYSTAL = registerItem("ember_crystal",
            new CrystalItem(new Item.Settings().maxCount(16), StatusEffects.FIRE_RESISTANCE,
                    600, 0, 1200, SoundEvents.ITEM_FIRECHARGE_USE));

    public static final Item ASH_CRYSTAL = registerItem("ash_crystal",
            new CrystalItem(new Item.Settings().maxCount(16), StatusEffects.NIGHT_VISION,
                    1200, 0, 2400, SoundEvents.PARTICLE_SOUL_ESCAPE));

    public static final Item SULFUR_CRYSTAL = registerItem("sulfur_crystal",
            new CrystalItem(new Item.Settings().maxCount(16), StatusEffects.SPEED,
                    400, 1, 1200, SoundEvents.ENTITY_RABBIT_JUMP));

    public static final Item MAGMA_CRYSTAL = registerItem("magma_crystal",
            new CrystalItem(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON), StatusEffects.STRENGTH,
                    400, 0, 1800, SoundEvents.ENTITY_BLAZE_AMBIENT));

    public static final Item OBSIDIAN_CRYSTAL = registerItem("obsidian_crystal",
            new CrystalItem(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON), StatusEffects.RESISTANCE,
                    600, 0, 2400, SoundEvents.BLOCK_ANCIENT_DEBRIS_HIT));

    public static final Item BASALT_CRYSTAL = registerItem("basalt_crystal",
            new CrystalItem(new Item.Settings().maxCount(16), StatusEffects.HASTE,
                    900, 1, 1800, SoundEvents.BLOCK_BASALT_BREAK));

    public static final Item SMOKE_CRYSTAL = registerItem("smoke_crystal",
            new CrystalItem(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON), StatusEffects.INVISIBILITY,
                    300, 0, 2400, SoundEvents.ENTITY_PHANTOM_FLAP));

    public static final Item FLAME_CRYSTAL = registerItem("flame_crystal",
            new CrystalItem(new Item.Settings().maxCount(16), StatusEffects.STRENGTH,
                    300, 0, 1200, SoundEvents.ITEM_FIRECHARGE_USE));

    public static final Item CHARCOAL_CRYSTAL = registerItem("charcoal_crystal",
            new CrystalItem(new Item.Settings().maxCount(16), StatusEffects.HASTE,
                    600, 0, 1200, SoundEvents.BLOCK_COAL_ORE_BREAK));

    public static final Item VOLCANIC_CRYSTAL = registerItem("volcanic_crystal",
            new CrystalItem(new Item.Settings().maxCount(16).rarity(Rarity.RARE), StatusEffects.FIRE_RESISTANCE,
                    600, 0, 2400, SoundEvents.ENTITY_GENERIC_EXPLODE));

    public static final Item PHOENIX_CRYSTAL = registerItem("phoenix_crystal",
            new CrystalItem(new Item.Settings().maxCount(16).rarity(Rarity.EPIC), StatusEffects.REGENERATION,
                    200, 1, 3600, SoundEvents.ENTITY_PLAYER_LEVELUP));

    public static final Item BLOOD_EMBER_CRYSTAL = registerItem("blood_ember_crystal",
            new CrystalItem(new Item.Settings().maxCount(16).rarity(Rarity.EPIC), StatusEffects.STRENGTH,
                    600, 1, 3600, SoundEvents.ENTITY_WITHER_AMBIENT));

    // --- Spawn yumurtalari (yaratik test icin) ---
    // NOT: SpawnEggItem constructor'i surume gore degisebilir; derleme
    // hatasi alirsan IDE'nin onerdigi (EntityType Supplier alan) asiri
    // yuklemeyi kullan.
    public static final Item KUL_ISKELETI_SPAWN_EGG = registerItem("ash_skeleton_spawn_egg",
            new SpawnEggItem(ModEntities.KUL_ISKELETI, 0x4a4a4a, 0xff7a1a, new Item.Settings()));

    public static final Item KOR_ZOMBISI_SPAWN_EGG = registerItem("ember_zombie_spawn_egg",
            new SpawnEggItem(ModEntities.KOR_ZOMBISI, 0x5c1a00, 0xff9d33, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EmbarFallMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EmbarFallMod.LOGGER.info("Embar Fall: esyalar kaydedildi");
    }
}
