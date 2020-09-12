package chongteam.soulforging.potion;

import chongteam.soulforging.SoulForging;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class PotionDirtProtection extends Potion {
    public PotionDirtProtection(){
        super(false,0x806144);
        this.setRegistryName(SoulForging.MODID+":dirt_protection");
        this.setPotionName("effect."+SoulForging.MODID+".dirtProtection");
    }

    private static final ResourceLocation TEXTURE=new ResourceLocation(SoulForging.MODID+":textures/gui/potion.png");

    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect e, Minecraft mc){
        int duration=e.getDuration();
        int fIndex=(duration % 16) / 2;
        mc.getTextureManager().bindTexture(TEXTURE);
        mc.currentScreen.drawTexturedModalRect(x+6,y+7,fIndex*18,0,18,18);
    }

    @Override
    public void renderHUDEffect(int x,int y,PotionEffect e,Minecraft mc,float alpha){
        int duration=e.getDuration();
        int fIndex=(duration % 16) / 2;
        mc.getTextureManager().bindTexture(TEXTURE);
        mc.ingameGUI.drawTexturedModalRect(x+3,y+3,fIndex*18,0,18,18);
    }
}
