package chongteam.soulforging.item;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.creativetab.TabSoulForging;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemSoulIronArmor extends ItemArmor {
    public ItemSoulIronArmor(EntityEquipmentSlot equipmentSlot){
        super(ItemRegistryHandler.SOUL_IRON_ARMOR_MATERIAL,0,equipmentSlot);
        this.setUnlocalizedName(SoulForging.MODID+".soulironArmor."+equipmentSlot.getName());
        this.setRegistryName("soul_iron_armor_"+equipmentSlot.getName());
        this.setCreativeTab(TabSoulForging.TAB_SOULFORGING);
    }
}