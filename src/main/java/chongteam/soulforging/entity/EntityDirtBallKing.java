package chongteam.soulforging.entity;

import chongteam.soulforging.SoulForging;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityDirtBallKing extends EntityMob {
    public static final String ID="dirt_ball_king";
    public static final String NAME= SoulForging.MODID+".DirtBallKing";

    public EntityDirtBallKing(World worldIn){
        super(worldIn);
        this.setSize(1.2F,1.95F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0,new EntityAISwimming(this));
        this.tasks.addTask(1,new EntityAIAttackMelee(this,0.8,false));
        this.tasks.addTask(2,new EntityAIWanderAvoidWater(this,0.2));
        this.tasks.addTask(3,new AIChangeGrassToDirt(this));
        this.tasks.addTask(4,new EntityAIWatchClosest(this, EntityPlayer.class,8.0F));
        this.tasks.addTask(5,new EntityAILookIdle(this));

        this.targetTasks.addTask(0,new EntityAIHurtByTarget(this,false));
    }

    private static class AIChangeGrassToDirt extends EntityAIBase{
        private final EntityDirtBallKing entity;
        private AIChangeGrassToDirt(EntityDirtBallKing entity){
            this.entity=entity;
        }

        @Override
        public void updateTask(){
            BlockPos blockPos=new BlockPos(this.entity.posX,this.entity.posY-0.2,this.entity.posZ);
            this.entity.world.setBlockState(blockPos, Blocks.DIRT.getDefaultState());
        }

        @Override
        public boolean shouldExecute(){
            BlockPos blockPos=new BlockPos(this.entity.posX,this.entity.posY-0.2,this.entity.posZ);
            return this.entity.world.getBlockState(blockPos).getBlock()==Blocks.GRASS;
        }
    }
}
