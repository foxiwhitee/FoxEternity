package foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers;

import appeng.items.misc.ItemEncodedPattern;
import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxEternity.integrations.appeng.AE2Integration;
import foxiwhitee.FoxEternity.integrations.appeng.items.patterns.ItemEncodedNeutronPattern;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class TileNeutronAssembler extends TileAssembler {
    public TileNeutronAssembler() {
        super(FEConfig.neutronAssemblerSpeed);
    }

    @Nullable
    @Override
    protected ItemStack getItemFromTile(Object obj) {
        return new ItemStack(AE2Integration.neutronAssembler);
    }

    @Override
    protected Class<? extends ItemEncodedPattern> getPattenClass() {
        return ItemEncodedNeutronPattern.class;
    }
}
