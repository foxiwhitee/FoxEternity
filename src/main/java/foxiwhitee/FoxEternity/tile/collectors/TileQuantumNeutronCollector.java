package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.json.core.JsonUtils;
import net.minecraft.item.ItemStack;

public class TileQuantumNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileQuantumNeutronCollector() {
        super(FEConfig.neutronCollectorQuantumTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = JsonUtils.parseItemStackString(FEConfig.neutronCollectorQuantumProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiQuantumNeutronCollector";
    }
}
