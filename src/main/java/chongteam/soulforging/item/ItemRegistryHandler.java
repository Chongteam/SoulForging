package chongteam.soulforging.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class ItemRegistryHandler {
    public static final ItemDirtBall DIRT_BALL=new ItemDirtBall();
    public static final ItemBrokenSoul BROKEN_SOUL=new ItemBrokenSoul();
    @SubscribeEvent
    public static void onRegistry(Register<Item> event){
        IForgeRegistry<Item> registry=event.getRegistry();
        registry.register(DIRT_BALL);
        registry.register(BROKEN_SOUL);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(DIRT_BALL, 0,
                new ModelResourceLocation(DIRT_BALL.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(BROKEN_SOUL, 0,
                new ModelResourceLocation(BROKEN_SOUL.getRegistryName(), "inventory"));
    }
}

