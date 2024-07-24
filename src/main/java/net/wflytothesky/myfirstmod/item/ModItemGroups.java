package net.wflytothesky.myfirstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wflytothesky.myfirstmod.MyFirstMod;
import net.wflytothesky.myfirstmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MyFirstMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        // Normal Items
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);

                        // Normal Blocks
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RAW_RUBY_BLOCK);

                        // Ores
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);

                        // Food Items
                        entries.add(ModItems.TOMATO);

                        // Fuel Items
                        entries.add(ModItems.COAL_BRIQUETTE);

                        // Advanced Blocks
                        entries.add(ModBlocks.SOUND_BLOCK);

                        // Advanced Items
                        entries.add(ModItems.METAL_DETECTOR);

                    }).build());

    public static void registerItemGroups() {
        MyFirstMod.LOGGER.info("Registering Item Groups for " +MyFirstMod.MOD_ID);
    }
}
