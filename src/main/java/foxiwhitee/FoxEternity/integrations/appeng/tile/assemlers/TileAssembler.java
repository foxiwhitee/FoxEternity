package foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers;

import appeng.api.networking.GridFlags;
import appeng.api.networking.crafting.ICraftingPatternDetails;
import appeng.helpers.UltimatePatternHelper;
import appeng.items.misc.ItemEncodedPattern;
import foxiwhitee.FoxLib.integration.applied.tile.TilePatternMachine;
import foxiwhitee.FoxLib.tile.inventory.FoxInternalInventory;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Objects;

public abstract class TileAssembler extends TilePatternMachine {
    private static final int[] NO_SLOTS = new int[0];
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
        if (pattern instanceof UltimatePatternHelper) {
            return getPattenClass().isAssignableFrom(Objects.requireNonNull(pattern.getPattern().getItem()).getClass());
        }
        return false;
    }

    @Override
    public FoxInternalInventory getInternalInventory() {
        return (FoxInternalInventory) getPatterns();
    }

    @Override
    public int[] getAccessibleSlotsBySide(ForgeDirection whichSide) {
        return NO_SLOTS;
    }

}
