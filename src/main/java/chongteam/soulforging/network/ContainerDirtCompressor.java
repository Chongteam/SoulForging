package chongteam.soulforging.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.omg.CORBA.IDLTypeHelper;

public class ContainerDirtCompressor extends Container {
    private final World world;
    private final BlockPos pos;

    private final IItemHandler up;
    private final IItemHandler side;
    private final IItemHandler down;
    public ContainerDirtCompressor(EntityPlayer player,World world,int x,int y,int z){
        this.world=world;
        this.pos=new BlockPos(x,y,z);

        TileEntity tileEntity=world.getTileEntity(this.pos);
        Capability<IItemHandler> itemHandlerCapability= CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

        this.up=tileEntity.getCapability(itemHandlerCapability, EnumFacing.UP);
        this.down=tileEntity.getCapability(itemHandlerCapability, EnumFacing.DOWN);
        this.side=tileEntity.getCapability(itemHandlerCapability, EnumFacing.NORTH);

        InventoryPlayer inventoryPlayer=player.inventory;
        this.addSlotToContainer(new SlotItemHandler(this.up,0,80,32));
        this.addSlotToContainer(new SlotItemHandler(this.down,0,134,59));
        this.addSlotToContainer(new SlotItemHandler(this.side,0,26,59));
        int[] range=new int[] {0,1,2,3,4,5,6,7,8};
        for(int i : range){
            this.addSlotToContainer(new Slot(inventoryPlayer,i,8 + 18 * i,152));
            this.addSlotToContainer(new Slot(inventoryPlayer,i + 9,8 + 18 * i,94));
            this.addSlotToContainer(new Slot(inventoryPlayer,i + 18,8 + 18 * i,112));
            this.addSlotToContainer(new Slot(inventoryPlayer,i + 27,8 + 18 * i,130));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn,int index){
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn){
        return playerIn.world.equals(this.world) && playerIn.getDistanceSq(this.pos) <= 64.0;
    }
}
