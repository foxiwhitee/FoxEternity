package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.json.core.JsonUtils;
import net.minecraft.item.ItemStack;

public class TileBasicNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileBasicNeutronCollector() {
        super(FEConfig.neutronCollectorBasicTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = JsonUtils.parseItemStackString(FEConfig.neutronCollectorBasicProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiBasicNeutronCollector";
    }
}
