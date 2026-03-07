package foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers;

import appeng.api.networking.GridFlags;
import appeng.api.networking.crafting.ICraftingPatternDetails;
import appeng.api.storage.data.IAEItemStack;
import appeng.api.storage.data.IAEStack;
import appeng.api.util.AECableType;
import appeng.items.misc.ItemEncodedPattern;
import foxiwhitee.FoxEternity.integrations.appeng.helpers.AdvancedPatternHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;
import java.util.Objects;

public abstract class TileAssembler extends TilePatternMachine {
    private final long maxCount;

    public TileAssembler(long maxCount) {
        this.maxCount = maxCount;
        getProxy().setFlags(GridFlags.REQUIRE_CHANNEL);
        getProxy().setIdlePowerUsage((long)Math.max(1, maxCount / 100D));
    }

    @Override
    protected long getMaxCount() {
        return maxCount - 1;
    }

    protected abstract Class<? extends ItemEncodedPattern> getPattenClass();

    @Override
    protected boolean isValidCraft(ICraftingPatternDetails pattern) {
        if (pattern instanceof AdvancedPatternHelper) {
            return getPattenClass().isAssignableFrom(Objects.requireNonNull(pattern.getPattern().getItem()).getClass());
        }
        return false;
    }

    @Override
    public AECableType getCableConnectionType(ForgeDirection dir) {
        return AECableType.SMART;
    }

    @Override
    public IInventory getInternalInventory() {
        return getPatterns();
    }

    @Override
    public int[] getAccessibleSlotsBySide(ForgeDirection whichSide) {
        return new int[0];
    }

    @Override
    public void getDrops(World w, int x, int y, int z, List<ItemStack> drops) {
        super.getDrops(w, x, y, z, drops);
        if (drops.isEmpty()) {
            for (int i = 0; i < getPatterns().getSizeInventory(); i++) {
                ItemStack stack = getPatterns().getStackInSlot(i);
                if (stack != null) {
                    drops.add(stack);
                }
            }
        }
        for (IAEStack<?> stack : needSend) {
            if (stack instanceof IAEItemStack iaeItemStack) {
                drops.add(iaeItemStack.getItemStack());
            }
        }
    }
}
