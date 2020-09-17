package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import chongteam.soulforging.entity.EntityDirtBall;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemDirtBall extends Item {
    public ItemDirtBall() {
        this.setUnlocalizedName(SoulForging.MODID + ".dirtBall");
        this.setCreativeTab(TabSoulForging.TAB_SOULFORGING);
        this.setRegistryName("dirt_ball");
        this.setMaxStackSize(64);
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack) {
        return 100;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
        ItemStack item=playerIn.getHeldItem(handIn);
        if(!playerIn.capabilities.isCreativeMode){
            item.shrink(1);
        }
        if(!worldIn.isRemote){
            EntityDirtBall entityDirtBall=new EntityDirtBall(worldIn,playerIn);
            float pitch=playerIn.rotationPitch,yaw=playerIn.rotationYaw;
            entityDirtBall.shoot(playerIn,pitch,yaw,0.0F,1.5F,1.0F);
            worldIn.spawnEntity(entityDirtBall);
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS,item);
    }
}
