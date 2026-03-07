package foxiwhitee.FoxEternity.integrations.appeng.blocks.encoders;

import foxiwhitee.FoxEternity.integrations.appeng.blocks.AppliedBlock;
import foxiwhitee.FoxEternity.integrations.appeng.tile.encoders.TileNeutronEncoder;

public class BlockNeutronEncoder extends AppliedBlock {
    public BlockNeutronEncoder(String name) {
        super(name, TileNeutronEncoder.class);
    }

    @Override
    public String getFolder() {
        return "encoders/";
    }
}
