package foxiwhitee.FoxEternity.blocks.collectors;

import foxiwhitee.FoxEternity.client.gui.GuiNeutronCollector;
import foxiwhitee.FoxEternity.container.ContainerNeutronCollector;
import foxiwhitee.FoxEternity.tile.collectors.TileHybridNeutronCollector;
import foxiwhitee.FoxLib.utils.handler.SimpleGuiHandler;

@SimpleGuiHandler(tile = TileHybridNeutronCollector.class, container = ContainerNeutronCollector.class, gui = GuiNeutronCollector.class)
public class BlockHybridNeutronCollector extends BlockNeutronCollector {
    public BlockHybridNeutronCollector(String name) {
        super(name, TileHybridNeutronCollector.class);
    }
}
