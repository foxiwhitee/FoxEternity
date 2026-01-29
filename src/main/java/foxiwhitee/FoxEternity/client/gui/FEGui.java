package foxiwhitee.FoxEternity.client.gui;

import foxiwhitee.FoxEternity.FECore;
import foxiwhitee.FoxLib.client.gui.FoxBaseGui;
import net.minecraft.inventory.Container;

public abstract class FEGui extends FoxBaseGui {
    public FEGui(Container container, int xSize, int ySize) {
        super(container, xSize, ySize);
        setModID(FECore.MODID);
    }
}
