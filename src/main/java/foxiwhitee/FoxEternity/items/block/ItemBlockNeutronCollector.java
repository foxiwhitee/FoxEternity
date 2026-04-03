package foxiwhitee.FoxEternity.items.block;

import foxiwhitee.FoxEternity.ModBlocks;
import foxiwhitee.FoxEternity.api.IHasNeutronSynthesizerIntegration;
import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.items.ModItemBlock;
import foxiwhitee.FoxLib.recipes.json.RecipeUtils;
import foxiwhitee.FoxLib.utils.helpers.LocalizationUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBlockNeutronCollector extends ModItemBlock implements IHasNeutronSynthesizerIntegration {
    private final int ticks;
    private final String production;

    public ItemBlockNeutronCollector(Block b) {
        super(b);
        if (isBlock(ModBlocks.basicNeutronCollector)) {
            this.ticks = FEConfig.neutronCollectorBasicTicks;
            this.production = FEConfig.neutronCollectorBasicProduction;
        } else if (isBlock(ModBlocks.advancedNeutronCollector)) {
            this.ticks = FEConfig.neutronCollectorAdvancedTicks;
            this.production = FEConfig.neutronCollectorAdvancedProduction;
        } else if (isBlock(ModBlocks.hybridNeutronCollector)) {
            this.ticks = FEConfig.neutronCollectorHybridTicks;
            this.production = FEConfig.neutronCollectorHybridProduction;
        } else if (isBlock(ModBlocks.ultimateNeutronCollector)) {
            this.ticks = FEConfig.neutronCollectorUltimateTicks;
            this.production = FEConfig.neutronCollectorUltimateProduction;
        } else if (isBlock(ModBlocks.quantumNeutronCollector)) {
            this.ticks = FEConfig.neutronCollectorQuantumTicks;
            this.production = FEConfig.neutronCollectorQuantumProduction;
        } else {
            this.ticks = 0;
            this.production = null;
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List<String> list, boolean p_77624_4_) {
        ItemStack production = getProduction();
        list.add(LocalizationUtils.localize("tooltip.collector", production.stackSize, LocalizationUtils.localize(production.getUnlocalizedName() + ".name"), ticks));
    }

    private ItemStack getProduction(String name) {
        return RecipeUtils.getItemStack(name, false);
    }

    @Override
    public int getTicks() {
        return ticks;
    }

    @Override
    public ItemStack getProduction() {
        return getProduction(production).copy();
    }
}
