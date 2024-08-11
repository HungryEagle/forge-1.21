package net.hungryeagle.mccourse.block;

import net.hungryeagle.mccourse.MCCourseMod;
import net.hungryeagle.mccourse.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> ALEXANDRITE_ORE_BLOCK = registerBlock("alexandrite_ore_block",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_ALEXANDRITE_ORE_BLOCK = registerBlock("deepslate_alexandrite_ore_block",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 7),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> END_STONE_ALEXANDRITE_ORE_BLOCK = registerBlock("end_stone_alexandrite_ore_block",
            () -> new DropExperienceBlock(
                    UniformInt.of(5, 8),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHER_ALEXANDRITE_ORE_BLOCK = registerBlock("nether_alexandrite_ore_block",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 6),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(5f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
