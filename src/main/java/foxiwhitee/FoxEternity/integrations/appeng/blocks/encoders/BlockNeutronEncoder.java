package foxiwhitee.FoxEternity.integrations.appeng.blocks.encoders;

import foxiwhitee.FoxEternity.blocks.AvaritiaBlock;
import foxiwhitee.FoxEternity.integrations.appeng.tile.encoders.TileNeutronEncoder;

public class BlockNeutronEncoder extends AvaritiaBlock {
    public BlockNeutronEncoder(String name) {
        super(name, TileNeutronEncoder.class);
    }

    @Override
    public String getFolder() {
        return "encoders/";
    }
}
