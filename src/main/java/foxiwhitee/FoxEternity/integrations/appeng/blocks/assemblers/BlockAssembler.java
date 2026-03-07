package foxiwhitee.FoxEternity.integrations.appeng.blocks.assemblers;

import foxiwhitee.FoxEternity.FECore;
import foxiwhitee.FoxEternity.integrations.appeng.blocks.AppliedBlock;
import net.minecraft.tileentity.TileEntity;

public abstract class BlockAssembler extends AppliedBlock {
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
