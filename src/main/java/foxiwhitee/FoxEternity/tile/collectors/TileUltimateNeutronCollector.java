package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.json.core.JsonUtils;
import net.minecraft.item.ItemStack;

public class TileUltimateNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileUltimateNeutronCollector() {
        super(FEConfig.neutronCollectorUltimateTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = JsonUtils.parseItemStackString(FEConfig.neutronCollectorUltimateProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiUltimateNeutronCollector";
    }
}
