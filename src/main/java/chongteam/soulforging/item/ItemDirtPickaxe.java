package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemDirtPickaxe extends ItemPickaxe{
    public ItemDirtPickaxe(){
        super(ItemRegistryHandler.DIRT_TOOL_MATERIAL);
        this.setUnlocalizedName(SoulForging.MODID+".dirtPickaxe");
        this.setCreativeTab(TabSoulForging.TAB_SOULFORGING);
        this.setRegistryName("dirt_pickaxe");
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state){
        Block block=state.getBlock();
        float speed=super.getDestroySpeed(stack,state);
        return (block==Blocks.DIRT || block==Blocks.GRASS || block==Blocks.GRASS_PATH) ? speed*10 : speed;
    }
}
