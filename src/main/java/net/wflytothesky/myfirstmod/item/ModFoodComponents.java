package net.wflytothesky.myfirstmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();

    public static final FoodComponent POPCORN_BUCKET = new FoodComponent.Builder().hunger(6).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 75), 0.1f).build();
}
