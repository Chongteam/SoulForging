package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import net.minecraft.item.Item;

public class ItemSoulBottle extends Item{
    public ItemSoulBottle() {
        this.setUnlocalizedName(SoulForging.MODID + ".soulBottle");
        this.setRegistryName("soul_bottle");
        this.setMaxStackSize(64);
    }
}
