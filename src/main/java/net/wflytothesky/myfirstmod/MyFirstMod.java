package net.wflytothesky.myfirstmod;

import net.fabricmc.api.ModInitializer;

import net.wflytothesky.myfirstmod.block.ModBlocks;
import net.wflytothesky.myfirstmod.item.ModFuelRegistry;
import net.wflytothesky.myfirstmod.item.ModItemGroups;
import net.wflytothesky.myfirstmod.item.ModItems;
import net.wflytothesky.myfirstmod.util.ModCustomTrades;
import net.wflytothesky.myfirstmod.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyFirstMod implements ModInitializer {
	public static final String MOD_ID = "myfirstmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModFuelRegistry.registerModFuel();

		ModCustomTrades.registerCustomTrades();

		ModLootTableModifiers.modifyLootTables();
	}
}