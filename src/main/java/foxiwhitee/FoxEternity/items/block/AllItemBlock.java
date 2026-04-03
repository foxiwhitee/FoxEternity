package foxiwhitee.FoxEternity.items.block;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxLib.items.ModItemBlock;
import net.minecraft.block.Block;

public class AllItemBlock extends ModItemBlock {
    public AllItemBlock(Block b) {
        super(b);
        this.enableTooltips = FEConfig.enableTooltips;
    }
}
