package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.recipes.json.RecipeUtils;
import net.minecraft.item.ItemStack;

public class TileUltimateNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileUltimateNeutronCollector() {
        super(FEConfig.neutronCollectorUltimateTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = RecipeUtils.getItemStack(FEConfig.neutronCollectorUltimateProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiUltimateNeutronCollector";
    }
}
