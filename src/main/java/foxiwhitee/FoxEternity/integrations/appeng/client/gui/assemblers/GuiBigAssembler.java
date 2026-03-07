package foxiwhitee.FoxEternity.integrations.appeng.client.gui.assemblers;

import foxiwhitee.FoxEternity.client.gui.FEGui;
import foxiwhitee.FoxEternity.integrations.appeng.container.assemblers.ContainerAssembler;

@SuppressWarnings("unused")
public class GuiBigAssembler extends FEGui {
    public GuiBigAssembler(ContainerAssembler container) {
        super(container, 210, 199);
    }

    @Override
    protected String getBackground() {
        return "gui/guiBigAssembler.png";
    }
}
