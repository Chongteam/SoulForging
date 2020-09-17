package chongteam.soulforging.client.renderer;

import chongteam.soulforging.entity.EntityDirtBall;
import chongteam.soulforging.entity.EntityDirtBallKing;
import chongteam.soulforging.item.ItemRegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderRegistryHandler {
    public static void register(){
        RenderingRegistry.registerEntityRenderingHandler(EntityDirtBallKing
            .class,RenderDirtBallKing::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityDirtBall.class,manager -> {
            RenderItem renderItem= Minecraft.getMinecraft().getRenderItem();
            return new RenderSnowball<EntityDirtBall>(manager, ItemRegistryHandler.DIRT_BALL,renderItem);
        });
    }
}
