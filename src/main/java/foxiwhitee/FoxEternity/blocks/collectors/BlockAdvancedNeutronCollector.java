package foxiwhitee.FoxEternity.blocks.collectors;

import foxiwhitee.FoxEternity.client.gui.GuiNeutronCollector;
import foxiwhitee.FoxEternity.container.ContainerNeutronCollector;
import foxiwhitee.FoxEternity.tile.collectors.TileAdvancedNeutronCollector;
import foxiwhitee.FoxLib.utils.handler.SimpleGuiHandler;

@SimpleGuiHandler(tile = TileAdvancedNeutronCollector.class, container = ContainerNeutronCollector.class, gui = GuiNeutronCollector.class)
public class BlockAdvancedNeutronCollector extends BlockNeutronCollector {
    public BlockAdvancedNeutronCollector(String name) {
        super(name, TileAdvancedNeutronCollector.class);
    }
}
