package chongteam.soulforging;

import chongteam.soulforging.crafting.FurnaceRecipeRegistryHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = SoulForging.MODID, name = SoulForging.NAME, version = SoulForging.VERSION)
public class SoulForging {
    public static final String MODID = "soulforging";
    public static final String NAME = "SoulForging";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FurnaceRecipeRegistryHandler.register();
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
