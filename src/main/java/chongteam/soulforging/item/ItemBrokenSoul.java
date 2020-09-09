package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import net.minecraft.item.Item;

public class ItemBrokenSoul extends Item {
    public ItemBrokenSoul() {
        this.setUnlocalizedName(SoulForging.MODID + ".brokenSoul");
        this.setCreativeTab(TabSoulForging.TAB_SOUL_FORGING);
        this.setRegistryName("broken_soul");
        this.setMaxStackSize(64);
    }
}
