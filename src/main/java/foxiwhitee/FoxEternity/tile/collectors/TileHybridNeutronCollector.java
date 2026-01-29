package foxiwhitee.FoxEternity.tile.collectors;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.recipes.json.RecipeUtils;
import net.minecraft.item.ItemStack;

public class TileHybridNeutronCollector extends TileNeutronCollector {
    private static ItemStack production;

    public TileHybridNeutronCollector() {
        super(FEConfig.neutronCollectorHybridTicks, getProduction());
    }

    private static ItemStack getProduction() {
        if (production == null) {
            production = RecipeUtils.getItemStack(FEConfig.neutronCollectorHybridProduction, false);
        }
        return production;
    }

    @Override
    public String getTextureName() {
        return "guiHybridNeutronCollector";
    }
}
