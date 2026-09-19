package com.embarfall.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * Ozel kristaller: tuketilmezler (elmas gibi kalicidirlar), ama sag tik
 * ile tasiyiciya kisa sureli buyulu bir etki verirler ve ardindan bir
 * bekleme suresine girerler. 12 farkli kristal, 12 farkli etki verir.
 *
 * NOT: use() imzasi (TypedActionResult vs ActionResult) surume gore
 * degisebilir; diger itemlarda oldugu gibi IDE'nin onerisiyle uyarlanabilir.
 */
public class CrystalItem extends Item {

    private final RegistryEntry<StatusEffect> effect;
    private final int durationTicks;
    private final int amplifier;
    private final int cooldownTicks;
    private final SoundEvent useSound;

    public CrystalItem(Settings settings, RegistryEntry<StatusEffect> effect, int durationTicks,
                        int amplifier, int cooldownTicks, SoundEvent useSound) {
        super(settings);
        this.effect = effect;
        this.durationTicks = durationTicks;
        this.amplifier = amplifier;
        this.cooldownTicks = cooldownTicks;
        this.useSound = useSound;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(effect, durationTicks, amplifier));
            world.playSound(null, user.getBlockPos(), useSound, SoundCategory.PLAYERS, 1.0F, 1.0F);
            user.getItemCooldownManager().set(stack, cooldownTicks);
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}
