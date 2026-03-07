package foxiwhitee.FoxEternity.integrations.appeng.blocks.assemlers;

import foxiwhitee.FoxEternity.FECore;
import foxiwhitee.FoxEternity.blocks.AvaritiaBlock;
import net.minecraft.tileentity.TileEntity;

public abstract class BlockAssembler extends AvaritiaBlock {
    public BlockAssembler(String name, Class<? extends TileEntity> tileEntityClass) {
        super(name, tileEntityClass);
        setLightLevel(1F);
        setBlockTextureName(FECore.MODID + ":encoders/bigEncoderDown");
    }

    @Override
    public String getFolder() {
        return "assemblers/";
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
