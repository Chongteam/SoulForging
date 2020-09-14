package chongteam.soulforging.entity;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EntityRegistryHandler {
    public static final EntityEntry DIRT_BALL_KING= EntityEntryBuilder.create()
            .entity(EntityDirtBallKing.class).id(EntityDirtBallKing.ID,0)
            .name(EntityDirtBallKing.NAME)
            .tracker(80,3,true).build();

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<EntityEntry> event){
        IForgeRegistry<EntityEntry> registry=event.getRegistry();
        registry.register(DIRT_BALL_KING);
    }
}
