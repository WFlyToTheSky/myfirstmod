package net.wflytothesky.myfirstmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class RubyStaffItem extends Item {

    public RubyStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            player.setCurrentHand(hand);
            //spawnParticles(world, player);
            spawnExplosion(world, player);
        }

        return  TypedActionResult.success(player.getStackInHand(hand));
    }

    private void spawnParticles(World world, PlayerEntity player) {
        Vec3d lookVec = player.getRotationVec(3.0F);
        Vec3d eyePos = player.getEyePos();
        for (int i = 0; i < 10; i++) {
            double offsetX = lookVec.x * (i + 1);
            double offsetY = lookVec.y * (i + 1);
            double offsetZ = lookVec.z * (i + 1);
            world.addParticle(ParticleTypes.FLAME, eyePos.getX() + offsetX, eyePos.getY() + offsetY, eyePos.getZ() + offsetZ, lookVec.x, lookVec.y, lookVec.z);



            // Check for collision with entities
        }

    }
    private void spawnExplosion(World world, PlayerEntity player) {
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult hit = client.crosshairTarget;

        switch (hit.getType()) {
            case MISS:

                break;
            case BLOCK:
                BlockHitResult blockHit = (BlockHitResult) hit;
                BlockPos blockPos = blockHit.getBlockPos();
                BlockState blockState = client.world.getBlockState(blockPos);
                Block block = blockState.getBlock();
                player.getWorld().createExplosion(player, blockPos.getX(), blockPos.getY() + 1D, blockPos.getZ(), 4.0F, false, World.ExplosionSourceType.TNT);
                break;
            case ENTITY:
                EntityHitResult entityHit = (EntityHitResult) hit;
                Entity entity = entityHit.getEntity();
                player.getWorld().createExplosion(player, entity.getX(), entity.getY() + (double) (entity.getHeight() / 16.0F), entity.getZ(), 4.0F, false, World.ExplosionSourceType.TNT);
                break;
        }

    }
}
