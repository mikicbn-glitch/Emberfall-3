package com.embarfall.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

/**
 * Kor Zombisi (Ember Zombie): "Yanmis Topraklar" biyomuna ozgu, atese
 * bagisik ve yakin dovuste hedefini tutusturan bir zombi varyanti.
 * Vanilla ZombieEntity'yi genisletir.
 */
public class KorZombisiEntity extends ZombieEntity {

    public KorZombisiEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isFireImmune() {
        return true;
    }

    @Override
    protected void onFireTick() {
        // Ates ona zarar vermez.
    }

    @Override
    public boolean tryAttack(net.minecraft.server.world.ServerWorld world, net.minecraft.entity.Entity target) {
        boolean success = super.tryAttack(world, target);
        if (success && target instanceof LivingEntity livingTarget) {
            livingTarget.setOnFireFor(4);
        }
        return success;
    }

    public static DefaultAttributeContainer.Builder createEmberZombieAttributes() {
        return ZombieEntity.createZombieAttributes()
                .add(EntityAttributes.MAX_HEALTH, 28.0D)
                .add(EntityAttributes.ATTACK_DAMAGE, 4.0D);
    }
}
