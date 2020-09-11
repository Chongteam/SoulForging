package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
}
