package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import net.minecraft.item.Item;

public class ItemDirtBall extends Item {
    public ItemDirtBall() {
        this.setUnlocalizedName(SoulForging.MODID + ".dirtball");
        this.setRegistryName("dirt_ball");
        this.setMaxStackSize(64);
    }
}