package foxiwhitee.FoxEternity.blocks;

import foxiwhitee.FoxEternity.tile.TileNeutronSynthesizer;

public class BlockNeutronSynthesizer extends AvaritiaBlock {
    public BlockNeutronSynthesizer(String name) {
        super(name, TileNeutronSynthesizer.class);
    }

    @Override
    public String getFolder() {
        return "synthesizer/";
    }
}
