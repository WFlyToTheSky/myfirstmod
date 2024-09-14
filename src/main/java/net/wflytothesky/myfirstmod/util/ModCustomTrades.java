package net.wflytothesky.myfirstmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.wflytothesky.myfirstmod.item.ModItems;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(ModItems.TOMATO, 7),
                            6, 5, 0.05f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 7),
                            new ItemStack(ModItems.TOMATO_SEEDS, 1),
                            10, 6, 0.05f));
                });
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(ModItems.CORN, 6),
                            5, 7, 0.05f));

                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(ModItems.CORN_SEEDS, 1),
                            9, 8, 0.05f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 24),
                            new ItemStack(ModItems.METAL_DETECTOR, 1),
                            2, 16, 0.1f));
                });
    }
}
