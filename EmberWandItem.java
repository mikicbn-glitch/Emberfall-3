package com.embarfall.item;

import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Kor Asasi (Ember Wand): sag tik ile kucuk bir ates topu firlatir.
 *
 * ONEMLI: Mojang, Item#use() imzasini surumler arasinda birkac kez
 * degistirdi (TypedActionResult<ItemStack> <-> ActionResult gibi).
 * 1.21.11 icin IDE derleme hatasi verirse, @Override'i IDE'nin onerdigi
 * guncel imzayla degistir - mantik (asa mekanigi) ayni kalir.
 */
public class EmberWandItem extends Item {

    public EmberWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<net.minecraft.item.ItemStack> use(World world, net.minecraft.entity.player.PlayerEntity user, Hand hand) {
        net.minecraft.item.ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            Vec3d look = user.getRotationVec(1.0F);
            SmallFireballEntity fireball = new SmallFireballEntity(world, user,
                    look.multiply(0.6));
            fireball.setPosition(
                    user.getX() + look.x,
                    user.getEyeY() - 0.2,
                    user.getZ() + look.z
            );
            world.spawnEntity(fireball);

            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_BLAZE_SHOOT,
                    SoundCategory.PLAYERS, 1.0F, 1.0F);

            // NOT: ItemStack#damage metodunun imzasi surumden surume degisiyor
            // (LivingEntity/EquipmentSlot ya da ServerWorld/Runnable alabiliyor).
            // Dayaniklilik dusurmek istersen IDE'nin onerdigi asiri yuklemeyi kullan.
            user.getItemCooldownManager().set(stack, 20); // 1 saniye bekleme suresi
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}
