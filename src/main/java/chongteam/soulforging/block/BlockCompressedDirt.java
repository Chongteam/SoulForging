package chongteam.soulforging.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import chongteam.soulforging.SoulForging;

public class BlockCompressedDirt extends Block{
    public BlockCompressedDirt(){
        super(Material.GROUND);
        this.setUnlocalizedName(SoulForging.MODID+".compressedDirt");
        this.setRegistryName("compressed_dirt");
        this.setHarvestLevel("shovel",0);
        this.setHardness(0.5F);
    }
}
