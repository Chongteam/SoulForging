package chongteam.soulforging.entity;

import chongteam.soulforging.SoulForging;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityDirtBallKing extends EntityMob {
    public static final String ID="dirt_ball_king";
    public static final String NAME= SoulForging.MODID+".DirtBallKing";

    public EntityDirtBallKing(World worldIn){
        super(worldIn);
        this.setSize(1.2F,1.95F);
    }
}
