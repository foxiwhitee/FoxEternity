package foxiwhitee.FoxEternity.blocks.collectors;

import foxiwhitee.FoxEternity.client.gui.GuiNeutronCollector;
import foxiwhitee.FoxEternity.container.ContainerNeutronCollector;
import foxiwhitee.FoxEternity.tile.collectors.TileBasicNeutronCollector;
import foxiwhitee.FoxLib.utils.handler.SimpleGuiHandler;

@SimpleGuiHandler(tile = TileBasicNeutronCollector.class, container = ContainerNeutronCollector.class, gui = GuiNeutronCollector.class)
public class BlockBasicNeutronCollector extends BlockNeutronCollector {
    public BlockBasicNeutronCollector(String name) {
        super(name, TileBasicNeutronCollector.class);
    }
}
