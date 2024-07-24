package net.wflytothesky.myfirstmod.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModFuelRegistry {
    public static void registerModFuel () {
        FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 200);
    }
}
