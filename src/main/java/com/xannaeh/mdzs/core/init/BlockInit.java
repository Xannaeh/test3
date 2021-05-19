package com.xannaeh.mdzs.core.init;
import com.xannaeh.mdzs.Mdzs;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,Mdzs.MODID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new Block(AbstractBlock.Properties.of(Material.SNOW, MaterialColor.DIAMOND)
                    .strength(4,5).harvestTool(ToolType.PICKAXE).harvestLevel(1)
                    .sound(SoundType.WET_GRASS)));
}
