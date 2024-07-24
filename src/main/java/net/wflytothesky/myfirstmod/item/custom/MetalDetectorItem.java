package net.wflytothesky.myfirstmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wflytothesky.myfirstmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state= context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;

                    context.getWorld().playSound(player, positionClicked, SoundEvents.BLOCK_NOTE_BLOCK_CHIME.value(), SoundCategory.PLAYERS, i, 1f);

                    break;
                }
            }


            if(!foundBlock) {
                player.sendMessage(Text.literal("No Valuables Found!"));
                context.getWorld().playSound(player, positionClicked, SoundEvents.BLOCK_NOTE_BLOCK_SNARE.value(), SoundCategory.PLAYERS, 1f, 1f);
            }

            context.getStack().damage(1, context.getPlayer(),
                    playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));
        }

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.COAL_ORE) || state.isOf(Blocks.COPPER_ORE) || state.isOf(Blocks.GOLD_ORE) || state.isOf(Blocks.REDSTONE_ORE) || state.isOf(Blocks.LAPIS_ORE) || state.isOf(ModBlocks.RUBY_ORE) || state.isOf(Blocks.DIAMOND_ORE) || state.isOf(Blocks.EMERALD_ORE) || state.isOf(Blocks.DEEPSLATE_COAL_ORE) || state.isOf(Blocks.DEEPSLATE_COPPER_ORE) || state.isOf(Blocks.DEEPSLATE_GOLD_ORE) || state.isOf(Blocks.DEEPSLATE_REDSTONE_ORE) || state.isOf(Blocks.DEEPSLATE_LAPIS_ORE) || state.isOf(ModBlocks.DEEPSLATE_RUBY_ORE) || state.isOf(Blocks.DEEPSLATE_DIAMOND_ORE) || state.isOf(Blocks.DEEPSLATE_EMERALD_ORE);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.myfirstmod.metal_detector"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
