package foxiwhitee.FoxEternity.integrations.appeng.client.gui.encoders;

import foxiwhitee.FoxEternity.integrations.appeng.container.encoders.ContainerNeutronEncoder;

public class GuiNeutronEncoder extends GuiUniversalEncoder {
    public GuiNeutronEncoder(ContainerNeutronEncoder container) {
        super(container, 210, 199, 169, 49);
    }

    @Override
    protected String getBackground() {
        return "gui/guiNeutronCompressorEncoder.png";
    }
}
