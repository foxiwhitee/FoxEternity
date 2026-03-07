package foxiwhitee.FoxEternity.integrations.appeng.client.gui.assemlers;

import foxiwhitee.FoxEternity.client.gui.FEGui;
import foxiwhitee.FoxEternity.integrations.appeng.container.assemlers.ContainerAssembler;

@SuppressWarnings("unused")
public class GuiNeutronAssembler extends FEGui {
    public GuiNeutronAssembler(ContainerAssembler container) {
        super(container, 210, 199);
    }

    @Override
    protected String getBackground() {
        return "gui/guiNeutronAssembler.png";
    }
}
