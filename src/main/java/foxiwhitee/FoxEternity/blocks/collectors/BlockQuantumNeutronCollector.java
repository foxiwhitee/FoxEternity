package foxiwhitee.FoxEternity.blocks.collectors;

import foxiwhitee.FoxEternity.client.gui.GuiNeutronCollector;
import foxiwhitee.FoxEternity.container.ContainerNeutronCollector;
import foxiwhitee.FoxEternity.tile.collectors.TileQuantumNeutronCollector;
import foxiwhitee.FoxLib.utils.handler.SimpleGuiHandler;

@SimpleGuiHandler(tile = TileQuantumNeutronCollector.class, container = ContainerNeutronCollector.class, gui = GuiNeutronCollector.class)
public class BlockQuantumNeutronCollector extends BlockNeutronCollector {
    public BlockQuantumNeutronCollector(String name) {
        super(name, TileQuantumNeutronCollector.class);
    }
}
