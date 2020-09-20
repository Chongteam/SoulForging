package chongteam.soulforging;

import chongteam.soulforging.capability.CapabilityRegistryHandler;
import chongteam.soulforging.client.renderer.RenderRegistryHandler;
import chongteam.soulforging.crafting.FurnaceRecipeRegistryHandler;
import chongteam.soulforging.potion.PotionRegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = SoulForging.MODID, name = SoulForging.NAME, version = SoulForging.VERSION,acceptedMinecraftVersions="[1.12,1.13)")
public class SoulForging {
    public static final String MODID = "soulforging";
    public static final String NAME = "SoulForging";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    @SideOnly(Side.CLIENT)
    public void preInitClient(FMLPreInitializationEvent event){
        RenderRegistryHandler.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FurnaceRecipeRegistryHandler.register();
        PotionRegistryHandler.register();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger=event.getModLog();
        CapabilityRegistryHandler.register();
    }
}
