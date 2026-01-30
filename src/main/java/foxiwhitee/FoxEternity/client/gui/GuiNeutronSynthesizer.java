package foxiwhitee.FoxEternity.client.gui;

import foxiwhitee.FoxEternity.container.ContainerNeutronSynthesizer;

public class GuiNeutronSynthesizer extends FEGui {
    public GuiNeutronSynthesizer(ContainerNeutronSynthesizer container) {
        super(container, 210, 235);
    }

    @Override
    protected String getBackground() {
        return "gui/guiNeutronSynthesizer.png";
    }
}
