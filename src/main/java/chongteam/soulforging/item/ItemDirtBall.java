package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import net.minecraft.item.Item;

public class ItemDirtBall extends Item {
    public ItemDirtBall() {
        this.setUnlocalizedName(SoulForging.MODID + ".dirtBall");
        this.setCreativeTab(TabSoulForging.TAB_SOULFORGING);
        this.setRegistryName("dirt_ball");
        this.setMaxStackSize(64);
    }
}
