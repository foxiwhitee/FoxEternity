package foxiwhitee.FoxEternity.blocks.collectors;

import foxiwhitee.FoxEternity.client.gui.GuiNeutronCollector;
import foxiwhitee.FoxEternity.container.ContainerNeutronCollector;
import foxiwhitee.FoxEternity.tile.collectors.TileUltimateNeutronCollector;
import foxiwhitee.FoxLib.utils.handler.SimpleGuiHandler;

@SimpleGuiHandler(tile = TileUltimateNeutronCollector.class, container = ContainerNeutronCollector.class, gui = GuiNeutronCollector.class)
public class BlockUltimateNeutronCollector extends BlockNeutronCollector {
    public BlockUltimateNeutronCollector(String name) {
        super(name, TileUltimateNeutronCollector.class);
    }
}
