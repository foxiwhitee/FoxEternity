package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.json.core.JsonUtils;
import net.minecraft.item.ItemStack;

public class TileHybridNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileHybridNeutronCollector() {
        super(FEConfig.neutronCollectorHybridTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = JsonUtils.parseItemStackString(FEConfig.neutronCollectorHybridProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiHybridNeutronCollector";
    }
}
