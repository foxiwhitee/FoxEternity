package foxiwhitee.FoxEternity.blocks;

import foxiwhitee.FoxEternity.FECore;
import foxiwhitee.FoxLib.block.FoxTileBlock;
import net.minecraft.tileentity.TileEntity;

public abstract class AvaritiaBlock extends FoxTileBlock {
    public AvaritiaBlock(String name, Class<? extends TileEntity> tileEntityClass) {
        super(FECore.MODID, name, tileEntityClass);
        setCreativeTab(FECore.TAB);
    }
}
