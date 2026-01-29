package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxLib.tile.FoxBaseInvTile;
import foxiwhitee.FoxLib.tile.event.TileEvent;
import foxiwhitee.FoxLib.tile.event.TileEventType;
import foxiwhitee.FoxLib.tile.inventory.FoxInternalInventory;
import foxiwhitee.FoxLib.tile.inventory.InvOperation;
import foxiwhitee.FoxLib.utils.helpers.InventoryUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class TileNeutronCollector extends FoxBaseInvTile {
    private final FoxInternalInventory inventory = new FoxInternalInventory(this, 1);
    private final int ticksNeed;
    private int tick;
    private final ItemStack production;

    public TileNeutronCollector(int ticksNeed, ItemStack production) {
        this.ticksNeed = ticksNeed;
        this.production = production;
    }

    @TileEvent(TileEventType.TICK)
    public void tick() {
        if (worldObj.isRemote) {
            return;
        }

        if (InventoryUtils.canInsert(inventory, production)) {
            if (tick++ >= ticksNeed) {
                tick = 0;
                InventoryUtils.insert(inventory, production.copy());
            }
        } else {
            tick = 0;
        }
        markForUpdate();
    }

    @Override
    @TileEvent(TileEventType.SERVER_NBT_WRITE)
    public void writeToNBT_(NBTTagCompound data) {
        super.writeToNBT_(data);
        data.setInteger("tick", tick);
    }

    @Override
    @TileEvent(TileEventType.SERVER_NBT_READ)
    public void readFromNBT_(NBTTagCompound data) {
        super.readFromNBT_(data);
        tick = data.getInteger("tick");
    }

    @TileEvent(TileEventType.CLIENT_NBT_WRITE)
    public void writeToStream(ByteBuf data) {
        data.writeInt(tick);
    }

    @TileEvent(TileEventType.CLIENT_NBT_READ)
    public boolean readFromStream(ByteBuf data) {
        int oldTick = this.tick;
        this.tick = data.readInt();
        return oldTick != this.tick;
    }

    @Override
    public FoxInternalInventory getInternalInventory() {
        return inventory;
    }

    @Override
    public int[] getAccessibleSlotsBySide(ForgeDirection forgeDirection) {
        return new int[] {0};
    }

    @Override
    public boolean canInsertItem(int slotIndex, ItemStack insertingItem, int side) {
        return false;
    }

    @Override
    public void onChangeInventory(IInventory iInventory, int i, InvOperation invOperation, ItemStack itemStack, ItemStack itemStack1) {

    }

    public abstract String getTextureName();
}
