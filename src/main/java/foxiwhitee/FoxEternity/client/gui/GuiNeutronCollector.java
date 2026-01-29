package foxiwhitee.FoxEternity.client.gui;

import foxiwhitee.FoxEternity.container.ContainerNeutronCollector;
import foxiwhitee.FoxEternity.tile.collectors.TileNeutronCollector;

public class GuiNeutronCollector extends FEGui {
    private final TileNeutronCollector tile;

    public GuiNeutronCollector(ContainerNeutronCollector container) {
        super(container, 210, 199);
        tile = (TileNeutronCollector) container.getTileEntity();
    }

    @Override
    protected String getBackground() {
        return "gui/" + tile.getTextureName() + ".png";
    }
}
