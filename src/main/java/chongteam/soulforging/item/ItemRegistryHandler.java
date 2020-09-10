package chongteam.soulforging.item;

import chongteam.soulforging.block.BlockRegistryHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class ItemRegistryHandler {
    public static final ItemDirtBall DIRT_BALL=new ItemDirtBall();
    public static final ItemBlock ITEM_COMPRESSED_DIRT=withRegistryName(new ItemBlock(BlockRegistryHandler.BLOCK_COMPRESSED_DIRT));
    public static final ItemBrokenSoul BROKEN_SOUL=new ItemBrokenSoul();
    public static final ItemPureSoul PURE_SOUL=new ItemPureSoul();
    public static final ItemSoulBottle SOUL_BOTTLE=new ItemSoulBottle();
    public static final Item.ToolMaterial DIRT_TOOL_MATERIAL= EnumHelper.addToolMaterial("DIRT",1,44,3.0F,1.0F,5);
    public static final ItemDirtPickaxe DIRT_PICKAXE=new ItemDirtPickaxe();

    private static ItemBlock withRegistryName(ItemBlock item){
        item.setRegistryName(item.getBlock().getRegistryName());
        return item;
    }

    @SubscribeEvent
    public static void onRegistry(Register<Item> event){
        IForgeRegistry<Item> registry=event.getRegistry();
        registry.register(DIRT_BALL);
        registry.register(ITEM_COMPRESSED_DIRT);
        registry.register(BROKEN_SOUL);
        registry.register(PURE_SOUL);
        registry.register(SOUL_BOTTLE);
        registry.register(DIRT_PICKAXE);
    }

    @SideOnly(Side.CLIENT)
    private static void registerModel(Item item){
        ModelResourceLocation modelResourceLocation=new ModelResourceLocation(item.getRegistryName(),"inventory");
        ModelLoader.setCustomModelResourceLocation(item,0,modelResourceLocation);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        registerModel(DIRT_BALL);
        registerModel(ITEM_COMPRESSED_DIRT);
        registerModel(BROKEN_SOUL);
        registerModel(PURE_SOUL);
        registerModel(SOUL_BOTTLE);
        registerModel(DIRT_PICKAXE);
    }
}
