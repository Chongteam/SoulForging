package chongteam.soulforging.block;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class BlockRegistryHandler {
    public static final BlockCompressedDirt BLOCK_COMPRESSED_DIRT=new BlockCompressedDirt();

    @SubscribeEvent
    public static void onRegistry(Register<Block> event){
        IForgeRegistry<Block> registry=event.getRegistry();
        registry.register(BLOCK_COMPRESSED_DIRT);
    }
}
