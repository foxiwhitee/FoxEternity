package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.recipes.json.RecipeUtils;
import net.minecraft.item.ItemStack;

public class TileAdvancedNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileAdvancedNeutronCollector() {
        super(FEConfig.neutronCollectorAdvancedTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = RecipeUtils.getItemStack(FEConfig.neutronCollectorAdvancedProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiAdvancedNeutronCollector";
    }
}
