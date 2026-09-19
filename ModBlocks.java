package com.embarfall.block;

import com.embarfall.EmbarFallMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

/**
 * "Yanmis Topraklar" (Burnt Lands / Ashlands) biyomuna ait 10 yeni blok.
 * NOT: Yarn mapping isimleri surumden surume kucuk farklar gosterebilir.
 * IDE'de kirmizi alt cizgi cikarsa ilgili metodun 1.21.11 karsiligini
 * (ornegin .strength, .sounds, .luminance) proje IDE'sinde otomatik
 * tamamlama ile duzeltebilirsin.
 */
public class ModBlocks {

    // 1) Volkanik, kararmis bir tas - genel yapi taşı.
    public static final Block VOLCANIC_ROCK = registerBlock("volcanic_rock",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .strength(2.0f, 6.0f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()));

    // 2) Kul - kuma benzer sekilde dusen (gravity) bir blok.
    public static final Block ASH_BLOCK = registerBlock("ash_block",
            new FallingBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIGHT_GRAY)
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.SAND)));

    // 3) Komurlesmis agac govdesi - eksene gore donen kutuk blogu.
    public static final PillarBlock CHARRED_LOG = (PillarBlock) registerBlock("charred_log",
            new PillarBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .strength(2.0f)
                    .sounds(BlockSoundGroup.WOOD)));

    // 4) Kor Cevheri - kirilinca Kor Tozu dusurur (loot table ile).
    public static final Block EMBER_ORE = registerBlock("ember_ore",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .strength(3.0f, 5.0f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
                    .luminance(state -> 3)));

    // 5) Ergimis Obsidyen - isik yayan, cok sert bir obsidyen varyanti.
    public static final Block MOLTEN_OBSIDIAN = registerBlock("molten_obsidian",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .strength(15.0f, 200.0f)
                    .sounds(BlockSoundGroup.STONE)
                    .requiresTool()
                    .luminance(state -> 10)));

    // 6) Yanmis Toprak - biyomun zemin blogu.
    public static final Block SCORCHED_DIRT = registerBlock("scorched_dirt",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.GRAY)
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.GRAVEL)));

    // 7) Kukurt Kristali - buyu esyalari icin malzeme kaynagi, dekoratif.
    public static final Block SULFUR_CRYSTAL_BLOCK = registerBlock("sulfur_crystal_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.YELLOW)
                    .strength(1.5f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .luminance(state -> 5)));

    // 8) Catlak Bazalt - bazaltin catlamis, biyoma ozgu varyanti.
    public static final Block CRACKED_BASALT = registerBlock("cracked_basalt",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLACK)
                    .strength(1.25f, 4.2f)
                    .sounds(BlockSoundGroup.BASALT)
                    .requiresTool()));

    // 9) Kul Cimi - biyomun "cim" blogu, ust yuzeyi kulle kaplı toprak.
    public static final Block ASHEN_GRASS_BLOCK = registerBlock("ashen_grass_block",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.LIGHT_GRAY)
                    .strength(0.6f)
                    .sounds(BlockSoundGroup.GRASS)
                    .ticksRandomly()));

    // 10) Kor Feneri - guclu isik kaynagi, "buyulu" bir el yapimi fener.
    public static final Block EMBER_LANTERN = registerBlock("ember_lantern",
            new Block(AbstractBlock.Settings.create()
                    .mapColor(MapColor.ORANGE)
                    .strength(3.5f)
                    .sounds(BlockSoundGroup.LANTERN)
                    .luminance(state -> 15)
                    .nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EmbarFallMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EmbarFallMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        EmbarFallMod.LOGGER.info("Embar Fall: 10 blok kaydedildi");
    }
}
