package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.json.core.JsonUtils;
import net.minecraft.item.ItemStack;

public class TileAdvancedNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileAdvancedNeutronCollector() {
        super(FEConfig.neutronCollectorAdvancedTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = JsonUtils.parseItemStackString(FEConfig.neutronCollectorAdvancedProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiAdvancedNeutronCollector";
    }
}
