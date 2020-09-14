package chongteam.soulforging.client.renderer;

import chongteam.soulforging.SoulForging;
import chongteam.soulforging.client.model.ModelDirtBallKing;
import chongteam.soulforging.entity.EntityDirtBallKing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderDirtBallKing extends RenderLiving {
    private static final ResourceLocation ENTITY_DIRT_BALL_KING_TEXTURE=
            new ResourceLocation(SoulForging.MODID + ":textures/entity/"
                    + EntityDirtBallKing.ID + "/" + EntityDirtBallKing.ID + ".png");

    public RenderDirtBallKing(RenderManager manager){
        super(manager,new ModelDirtBallKing(),0.8F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity){
        return ENTITY_DIRT_BALL_KING_TEXTURE;
    }
}
