package foxiwhitee.FoxEternity.blocks;

import foxiwhitee.FoxEternity.FECore;
import foxiwhitee.FoxLib.block.FoxBaseBlock;
import net.minecraft.tileentity.TileEntity;

public abstract class AvaritiaBlock extends FoxBaseBlock {
    public AvaritiaBlock(String name, Class<? extends TileEntity> tileEntityClass) {
        super(FECore.MODID, name);
        setTileEntityType(tileEntityClass);
        setCreativeTab(FECore.TAB);
    }
}
