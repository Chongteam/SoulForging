package chongteam.soulforging.creativetab;

import chongteam.soulforging.item.ItemRegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabSoulForging extends CreativeTabs {
    public static final TabSoulForging TAB_SOULFORGING=new TabSoulForging();

    public TabSoulForging(){
        super("soulforging");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemRegistryHandler.ITEM_COMPRESSED_DIRT);
    }

    @Override
    public boolean hasSearchBar(){
        return true;
    }

    @Override
    public int getSearchbarWidth(){
        return 45;
    }
    /**
    @Override
    public String getBackgroundImageName(){
        return "soulforging.png";
    }
    */
}
