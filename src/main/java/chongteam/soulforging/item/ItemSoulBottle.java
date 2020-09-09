package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import net.minecraft.item.Item;

public class ItemSoulBottle extends Item{
    public ItemSoulBottle() {
        this.setUnlocalizedName(SoulForging.MODID + ".soulBottle");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("soul_bottle");
        this.setMaxStackSize(64);
    }
}
