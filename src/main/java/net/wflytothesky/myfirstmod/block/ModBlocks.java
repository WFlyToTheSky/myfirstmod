package net.wflytothesky.myfirstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.wflytothesky.myfirstmod.MyFirstMod;
import net.wflytothesky.myfirstmod.block.custom.CornCropBlock;
import net.wflytothesky.myfirstmod.block.custom.SoundBlock;
import net.wflytothesky.myfirstmod.block.custom.TomatoCropBlock;

public class ModBlocks {
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    public static final Block RUBY_STAIRS = registerBlock("ruby_stairs",
            new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_SLAB = registerBlock("ruby_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_BUTTON = registerBlock("ruby_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK), BlockSetType.IRON, 10, true));
    public static final Block RUBY_PRESSURE_PLATE = registerBlock("ruby_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK), BlockSetType.IRON));

    public static final Block RUBY_FENCE = registerBlock("ruby_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RUBY_FENCE_GATE = registerBlock("ruby_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK), WoodType.ACACIA));
    public static final Block RUBY_WALL = registerBlock("ruby_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RUBY_DOOR = registerBlock("ruby_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_DOOR).sounds(BlockSoundGroup.AMETHYST_BLOCK), BlockSetType.IRON));
    public static final Block RUBY_TRAPDOOR = registerBlock("ruby_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_TRAPDOOR).sounds(BlockSoundGroup.AMETHYST_BLOCK), BlockSetType.IRON));



    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(3, 5)));
    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(4, 5)));
    public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f), UniformIntProvider.create(3, 6)));
    public static final Block END_STONE_RUBY_ORE = registerBlock("end_stone_ruby_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f), UniformIntProvider.create(5, 7)));

    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK, new Identifier(MyFirstMod.MOD_ID, "tomato_crop"),
            new TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, new Identifier(MyFirstMod.MOD_ID, "corn_crop"),
            new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block DAHLIA = registerBlock("dahlia",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 10,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_DAHLIA = Registry.register(Registries.BLOCK, new Identifier(MyFirstMod.MOD_ID, "potted_dahlia"),
            new FlowerPotBlock(DAHLIA, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MyFirstMod.MOD_ID, name), block);
    }


    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MyFirstMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {
        MyFirstMod.LOGGER.info("Registering ModBlocks " + MyFirstMod.MOD_ID);
    }
}
