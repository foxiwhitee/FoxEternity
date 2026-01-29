package foxiwhitee.FoxEternity.blocks.collectors;

import foxiwhitee.FoxEternity.blocks.AvaritiaBlock;
import foxiwhitee.FoxLib.block.FoxBaseBlock;
import net.minecraft.tileentity.TileEntity;

public abstract class BlockNeutronCollector extends AvaritiaBlock {
    public BlockNeutronCollector(String name, Class<? extends TileEntity> tileEntityClass) {
        super(name, tileEntityClass);
    }

    @Override
    public String getFolder() {
        return "collectors/";
    }
}
