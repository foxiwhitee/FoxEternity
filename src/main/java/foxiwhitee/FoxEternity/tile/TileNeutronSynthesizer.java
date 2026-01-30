package foxiwhitee.FoxEternity.tile;

import fox.spiteful.avaritia.items.LudicrousItems;
import foxiwhitee.FoxEternity.api.IHasNeutronSynthesizerIntegration;
import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.tile.FoxBaseInvTile;
import foxiwhitee.FoxLib.tile.event.TileEvent;
import foxiwhitee.FoxLib.tile.event.TileEventType;
import foxiwhitee.FoxLib.tile.inventory.FoxInternalInventory;
import foxiwhitee.FoxLib.tile.inventory.InvOperation;
import foxiwhitee.FoxLib.utils.helpers.InventoryUtils;
import foxiwhitee.FoxLib.utils.helpers.ItemStackUtil;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.ForgeDirection;

public class TileNeutronSynthesizer extends FoxBaseInvTile {
    private static ItemStack dust;
    private final FoxInternalInventory inventory = new FoxInternalInventory(this, 36);
    private final FoxInternalInventory collectors = new FoxInternalInventory(this, 9, FEConfig.neutronSynthesizerStackLimit);
    private final FoxInternalInventory production = new FoxInternalInventory(this, 9);
    private final int[] slots;
    private int[] ticks, ticksNeed;

    public TileNeutronSynthesizer() {
        this.slots = new int[inventory.getSizeInventory()];
        for (int i = 0; i < this.inventory.getSizeInventory(); i++) {
            slots[i] = i;
        }
        if (dust == null) {
            dust = new ItemStack(LudicrousItems.resource, 1, 2);
        }
        ticks = new int[collectors.getSizeInventory()];
        ticksNeed = new int[collectors.getSizeInventory()];
    }

    @TileEvent(TileEventType.TICK)
    public void tick() {
        if (worldObj.isRemote) {
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (production.getStackInSlot(i) != null && InventoryUtils.canInsert(inventory, production.getStackInSlot(i))) {
                if (ticks[i]++ >= ticksNeed[i]) {
                    ticks[i] = 0;
                    for (int j = 0; j < collectors.getStackInSlot(i).stackSize; j++) {
                        if (InventoryUtils.canInsert(inventory, production.getStackInSlot(i))) {
                            InventoryUtils.insert(inventory, production.getStackInSlot(i));
                        }
                    }
                }
            }
        }
    }

    @Override
    @TileEvent(TileEventType.SERVER_NBT_WRITE)
    public void writeToNBT_(NBTTagCompound data) {
        super.writeToNBT_(data);
        collectors.writeToNBT(data, "collectors");
        production.writeToNBT(data, "production");
        data.setIntArray("ticks", ticks);
        data.setIntArray("ticksNeed", ticksNeed);
    }

    @Override
    @TileEvent(TileEventType.SERVER_NBT_READ)
    public void readFromNBT_(NBTTagCompound data) {
        super.readFromNBT_(data);
        collectors.readFromNBT(data, "collectors");
        production.readFromNBT(data, "production");
        ticks = data.getIntArray("ticks");
        ticksNeed = data.getIntArray("ticksNeed");
    }

    @Override
    public FoxInternalInventory getInternalInventory() {
        return inventory;
    }

    public FoxInternalInventory getCollectorsInventory() {
        return collectors;
    }

    @Override
    public int[] getAccessibleSlotsBySide(ForgeDirection forgeDirection) {
        return slots;
    }

    @Override
    public boolean canInsertItem(int slotIndex, ItemStack insertingItem, int side) {
        return false;
    }

    @Override
    public void onChangeInventory(IInventory iInventory, int i, InvOperation invOperation, ItemStack itemStack, ItemStack itemStack1) {
        if (iInventory == collectors) {
            updateCollectors();
        }
    }

    private void updateCollectors() {
        for (int i = 0; i < collectors.getSizeInventory(); i++) {
            ItemStack collector = collectors.getStackInSlot(i);
            if (collector == null) {
                production.setInventorySlotContents(i, null);
                ticksNeed[i] = 0;
                ticks[i] = 0;
                continue;
            }
            int newTicks;
            ItemStack newProduction;
            if (collector.getItem() instanceof IHasNeutronSynthesizerIntegration item) {
                newTicks = item.getTicks();
                newProduction = item.getProduction();
            } else {
                newTicks = 7111;
                newProduction = dust.copy();
            }
            updateProduction(i, newTicks, newProduction);
        }
    }

    private void updateProduction(int i, int newTicks, ItemStack newProduction) {
        ItemStack oldProduction = production.getStackInSlot(i);
        if (ItemStackUtil.stackEquals(oldProduction, newProduction, true)) {
            return;
        }
        ticksNeed[i] = newTicks;
        ticks[i] = 0;
        production.setInventorySlotContents(i, newProduction);
    }
}
