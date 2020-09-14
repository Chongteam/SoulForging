package chongteam.soulforging.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelDirtBallKing extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer leftLeg;
    private ModelRenderer rightLeg;

    public ModelDirtBallKing(){
        this.textureWidth=128;
        this.textureHeight=32;

        this.body=new ModelRenderer(this,0,0);
        this.head=new ModelRenderer(this,72,4);
        this.leftLeg=new ModelRenderer(this,54,0);
        this.rightLeg=new ModelRenderer(this,54,0);

        this.body.addBox(-9,0,-9,18,14,18)
                .setRotationPoint(0,6,0);
        this.head.addBox(-7,-14,-7,14,14,14)
                .setRotationPoint(0,8,0);
        this.leftLeg.addBox(-2,2,-6,4,6,12)
                .setRotationPoint(4,16,0);
        this.rightLeg.addBox(-2,2,-6,4,6,12)
                .setRotationPoint(-4,16,0);
    }

    @Override
    public void render(Entity entity, float a, float b, float c, float d, float e, float scale){
        this.body.render(scale);
        this.head.render(scale);
        this.leftLeg.render(scale);
        this.rightLeg.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float A=1.25F,w=9.6662F,pi= (float) Math.PI;
        this.head.rotateAngleX=pi / 180 * headPitch;
        this.head.rotateAngleY=pi / 180 * netHeadYaw;
        this.rightLeg.rotateAngleX=MathHelper.cos(limbSwing * w) * limbSwingAmount * A;
        this.leftLeg.rotateAngleX=MathHelper.cos(limbSwing * w + pi)* limbSwingAmount * A;
    }
}
