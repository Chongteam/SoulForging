package chongteam.soulforging.event;

import net.minecraft.entity.Entity;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler
{
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event)
    {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer)
        {
            String message = "Welcome to SoulForging, " + entity.getName() + "! ";
            TextComponentString text = new TextComponentString(message);
            entity.sendMessage(text);
        }
    }
}
