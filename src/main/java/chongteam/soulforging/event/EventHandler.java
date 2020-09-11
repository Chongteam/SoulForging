package chongteam.soulforging.event;

import chongteam.soulforging.enchantment.EnchantmentRegistryHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer) {
            String message = "Welcome to SoulForging, " + entity.getName() + "! ";
            TextComponentString text = new TextComponentString(message);
            entity.sendMessage(text);
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDamageEvent event){
        Entity source=event.getSource().getImmediateSource();
        if(source instanceof EntityPlayer && !source.world.isRemote){
            EntityPlayer player=(EntityPlayer) source;
            ItemStack heldItemMainhand=player.getHeldItemMainhand();
            int level=EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistryHandler.EXPLOSION,heldItemMainhand);
            if(level > 0){
                Entity target=event.getEntity();
                target.world.createExplosion(null,target.posX,target.posY,target.posZ,1*level,false);
            }
        }
    }
}
