package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import net.minecraft.item.Item;

public class ItemBrokenSoul extends Item
{
    public ItemBrokenSoul()
    {
        this.setUnlocalizedName(SoulForging.MODID + ".brokensoul");
        this.setRegistryName("broken_soul");
        this.setMaxStackSize(64);
    }
}
