package foxiwhitee.FoxEternity.integrations.appeng.blocks.assemblers;

import foxiwhitee.FoxEternity.FECore;
import foxiwhitee.FoxEternity.integrations.appeng.blocks.AppliedBlock;
import net.minecraft.tileentity.TileEntity;

public abstract class BlockAssembler extends AppliedBlock {
    public BlockAssembler(String name, Class<? extends TileEntity> tileEntityClass) {
        super(name, tileEntityClass);
        setBlockTextureName(FECore.MODID + ":encoders/bigEncoderDown");
    }

    @Override
    public String getFolder() {
        return "assemblers/";
    }
}
