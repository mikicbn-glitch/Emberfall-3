package com.embarfall.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;

/**
 * Kul Iskeleti (Ash Skeleton): "Yanmis Topraklar" biyomuna ozgu,
 * atese bagisik ve okları alevli olan bir iskelet varyanti.
 * Vanilla SkeletonEntity'yi genisletir - AI, animasyon ve okculuk
 * davranisini oldugu gibi devralir.
 */
public class KulIskeletiEntity extends SkeletonEntity {

    public KulIskeletiEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    protected void onFireTick() {
        // Ates ona zarar vermez, bu yuzden yanma efektini yok sayiyoruz.
    }

    @Override
    protected ProjectileEntity createArrowProjectile(net.minecraft.item.ItemStack arrow, float damageModifier, net.minecraft.item.ItemStack bow) {
        ProjectileEntity projectile = super.createArrowProjectile(arrow, damageModifier, bow);
        projectile.setOnFireFor(5);
        return projectile;
    }

    // Vanilla SkeletonEntity ile ayni temel oznitelikler (can, hiz, vs.).
    public static DefaultAttributeContainer.Builder createAshSkeletonAttributes() {
        return SkeletonEntity.createAbstractSkeletonAttributes()
                .add(EntityAttributes.MAX_HEALTH, 24.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.26D);
    }
}
