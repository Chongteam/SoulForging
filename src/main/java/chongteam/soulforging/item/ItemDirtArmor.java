package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemDirtArmor extends ItemArmor {
    public ItemDirtArmor(EntityEquipmentSlot equipmentSlot){
        super(ItemRegistryHandler.DIRT_ARMOR_MATERIAL,0,equipmentSlot);
        this.setUnlocalizedName(SoulForging.MODID+".dirtArmor."+equipmentSlot.getName());
        this.setRegistryName("dirt_armor_"+equipmentSlot.getName());
        this.setCreativeTab(TabSoulForging.TAB_SOULFORGING);
    }
}
