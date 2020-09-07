package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import net.minecraft.item.Item;

public class ItemPureSoul extends Item {
    public ItemPureSoul() {
        this.setUnlocalizedName(SoulForging.MODID + ".pureSoul");
        this.setRegistryName("pure_soul");
        this.setMaxStackSize(64);
    }
}
