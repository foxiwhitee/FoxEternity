package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.recipes.json.RecipeUtils;
import net.minecraft.item.ItemStack;

public class TileQuantumNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileQuantumNeutronCollector() {
        super(FEConfig.neutronCollectorQuantumTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = RecipeUtils.getItemStack(FEConfig.neutronCollectorQuantumProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiQuantumNeutronCollector";
    }
}
