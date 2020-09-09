package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import net.minecraft.item.Item;

public class ItemPureSoul extends Item {
    public ItemPureSoul() {
        this.setUnlocalizedName(SoulForging.MODID + ".pureSoul");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("pure_soul");
        this.setMaxStackSize(64);
    }
}
