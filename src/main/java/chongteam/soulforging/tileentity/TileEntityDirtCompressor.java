package chongteam.soulforging.tileentity;

import chongteam.soulforging.SoulForging;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityDirtCompressor extends TileEntity {
    public static final String ID= SoulForging.MODID + ":dirt_compressor";

    private final ItemStackHandler up=new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntityDirtCompressor.this.markDirty();
        }
    };
    private final ItemStackHandler side=new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntityDirtCompressor.this.markDirty();
        }
    };
    private final ItemStackHandler down=new ItemStackHandler(1){
        @Override
        protected void onContentsChanged(int slot){
            TileEntityDirtCompressor.this.markDirty();
        }
    };

    @Override
    public void readFromNBT(NBTTagCompound compound){
        this.down.deserializeNBT(compound.getCompoundTag("Down"));
        this.side.deserializeNBT(compound.getCompoundTag("Side"));
        this.up.deserializeNBT(compound.getCompoundTag("Up"));
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        compound.setTag("Down",this.down.serializeNBT());
        compound.setTag("Side",this.side.serializeNBT());
        compound.setTag("Up",this.up.serializeNBT());
        return super.writeToNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing){
        Capability<IItemHandler> itemHandlerCapability= CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
        return itemHandlerCapability.equals(capability) || super.hasCapability(capability,facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability,@Nullable EnumFacing facing){
        Capability<IItemHandler> itemHandlerCapability=CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
        if(itemHandlerCapability.equals(capability)){
            if(EnumFacing.UP.equals(facing)){
                return itemHandlerCapability.cast(this.up);
            }
            if(EnumFacing.DOWN.equals(facing)){
                return itemHandlerCapability.cast(this.down);
            }
            return itemHandlerCapability.cast(this.side);
        }
        return super.getCapability(capability,facing);
    }
}
