package chongteam.soulforging.event;

import chongteam.soulforging.enchantment.EnchantmentRegistryHandler;
import chongteam.soulforging.potion.PotionRegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class EventHandler {
    @SideOnly(Side.CLIENT)
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

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event){
        DamageSource damageSource=event.getSource();
        if("fall".equals((damageSource.getDamageType()))){
            EntityLivingBase target=event.getEntityLiving();
            Potion potion= PotionRegistryHandler.POTION_DIRT_PROTECTION;
            if(target.isPotionActive(potion)){
                PotionEffect effect=target.getActivePotionEffect(potion);
                BlockPos pos=new BlockPos(target.posX,target.posY-0.2,target.posZ);
                Block block=target.world.getBlockState(pos).getBlock();
                if(block == Blocks.DIRT || block == Blocks.GRASS || block == Blocks.GRASS_PATH){
                    event.setAmount(effect.getAmplifier() > 0 ? 0 : event.getAmount() / 2);
                }
            }
        }
    }
}
