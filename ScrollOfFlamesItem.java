package com.embarfall.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * Alev Tomari (Scroll of Flames): kullanilinca kisa sureli Ates Direnci
 * ve Hiz verir, ardindan tuketilir. "Ortacag buyusu" hissi icin bir
 * tomar/muska esyasi.
 *
 * NOT: EmberWandItem'daki gibi, use() imzasi surume gore degisebilir.
 */
public class ScrollOfFlamesItem extends Item {

    public ScrollOfFlamesItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 400, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 1));
            world.playSound(null, user.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE,
                    SoundCategory.PLAYERS, 1.0F, 1.2F);

            if (!user.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}
