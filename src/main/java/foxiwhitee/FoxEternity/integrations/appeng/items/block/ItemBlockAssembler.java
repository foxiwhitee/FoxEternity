package foxiwhitee.FoxEternity.integrations.appeng.items.block;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.items.ModItemBlock;
import net.minecraft.block.Block;

public class ItemBlockAssembler extends ModItemBlock {
    public ItemBlockAssembler(Block b) {
        super(b);
        this.enableTooltips = FEConfig.enableTooltips;
    }
}
