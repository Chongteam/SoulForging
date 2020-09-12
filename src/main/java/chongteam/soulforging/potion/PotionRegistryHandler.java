package chongteam.soulforging.potion;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.item.ItemRegistryHandler;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.*;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class PotionRegistryHandler {
    public static final Potion POTION_DIRT_PROTECTION=new PotionDirtProtection();

    @SubscribeEvent
    public static void onPotionRegistry(RegistryEvent.Register<Potion> event){
        IForgeRegistry<Potion> registry=event.getRegistry();
        registry.register(POTION_DIRT_PROTECTION);
    }

    public static final PotionType POTION_TYPE_DIRT_PROTECTION=
            new PotionType(SoulForging.MODID + ".dirtProtection",
                    new PotionEffect(POTION_DIRT_PROTECTION, 3600))
                    .setRegistryName("dirt_protection");
    public static final PotionType POTION_TYPE_LONG_DIRT_PROTECTION=
            new PotionType(SoulForging.MODID + ".dirtProtection",
                    new PotionEffect(POTION_DIRT_PROTECTION, 9600))
                    .setRegistryName("long_dirt_protection");
    public static final PotionType POTION_TYPE_STRONG_DIRT_PROTECTION=
            new PotionType(SoulForging.MODID + ".dirtProtection",
                    new PotionEffect(POTION_DIRT_PROTECTION, 1800,1))
                    .setRegistryName("strong_dirt_protection");

    @SubscribeEvent
    public static void onPotionTypeRegistry(RegistryEvent.Register<PotionType> event){
        IForgeRegistry<PotionType> registry=event.getRegistry();
        registry.register(POTION_TYPE_DIRT_PROTECTION);
        registry.register(POTION_TYPE_LONG_DIRT_PROTECTION);
        registry.register(POTION_TYPE_STRONG_DIRT_PROTECTION);
    }

    public static void register(){
        PotionHelper.addMix(POTION_TYPE_DIRT_PROTECTION, Items.REDSTONE,POTION_TYPE_LONG_DIRT_PROTECTION);
        PotionHelper.addMix(POTION_TYPE_DIRT_PROTECTION,Items.GLOWSTONE_DUST,POTION_TYPE_STRONG_DIRT_PROTECTION);
        PotionHelper.addMix(PotionTypes.AWKWARD, ItemRegistryHandler.ITEM_COMPRESSED_DIRT,POTION_TYPE_DIRT_PROTECTION);
    }
}
