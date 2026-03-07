package foxiwhitee.FoxEternity.integrations.appeng.blocks.encoders;

import foxiwhitee.FoxEternity.blocks.AvaritiaBlock;
import foxiwhitee.FoxEternity.integrations.appeng.tile.encoders.TileBigEncoder;

public class BlockBigEncoder extends AvaritiaBlock {
    public BlockBigEncoder(String name) {
        super(name, TileBigEncoder.class);
    }

    @Override
    public String getFolder() {
        return "encoders/";
    }
}
