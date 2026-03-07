package foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers;

import appeng.items.misc.ItemEncodedPattern;
import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxEternity.integrations.appeng.AE2Integration;
import foxiwhitee.FoxEternity.integrations.appeng.items.patterns.ItemEncodedBigPattern;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class TileBigAssembler extends TileAssembler {
    public TileBigAssembler() {
        super(FEConfig.bigAssemblerSpeed);
    }

    @Nullable
    @Override
    protected ItemStack getItemFromTile(Object obj) {
        return new ItemStack(AE2Integration.bigAssembler);
    }

    @Override
    protected Class<? extends ItemEncodedPattern> getPattenClass() {
        return ItemEncodedBigPattern.class;
    }
}
