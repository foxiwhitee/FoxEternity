package foxiwhitee.FoxEternity.blocks;

import foxiwhitee.FoxEternity.client.gui.GuiNeutronSynthesizer;
import foxiwhitee.FoxEternity.container.ContainerNeutronSynthesizer;
import foxiwhitee.FoxEternity.tile.TileNeutronSynthesizer;
import foxiwhitee.FoxLib.utils.handler.SimpleGuiHandler;

@SimpleGuiHandler(tile = TileNeutronSynthesizer.class, container = ContainerNeutronSynthesizer.class, gui = GuiNeutronSynthesizer.class)
public class BlockNeutronSynthesizer extends AvaritiaBlock {
    public BlockNeutronSynthesizer(String name) {
        super(name, TileNeutronSynthesizer.class);
    }

    @Override
    public String getFolder() {
        return "synthesizer/";
    }
}
