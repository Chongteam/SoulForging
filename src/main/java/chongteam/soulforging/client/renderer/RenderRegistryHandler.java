package chongteam.soulforging.client.renderer;

import chongteam.soulforging.entity.EntityDirtBallKing;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderRegistryHandler {
    public static void register(){
        RenderingRegistry.registerEntityRenderingHandler(EntityDirtBallKing
            .class,RenderDirtBallKing::new);
    }
}
