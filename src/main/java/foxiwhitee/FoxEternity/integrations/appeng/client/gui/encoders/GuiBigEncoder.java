package foxiwhitee.FoxEternity.integrations.appeng.client.gui.encoders;

import foxiwhitee.FoxEternity.integrations.appeng.container.encoders.ContainerBigEncoder;

public class GuiBigEncoder extends GuiUniversalEncoder {
    public GuiBigEncoder(ContainerBigEncoder container) {
        super(container, 308, 303, 267, 94);
    }

    @Override
    protected String getBackground() {
        return "gui/guiBigEncoder.png";
    }
}
