package foxiwhitee.FoxEternity.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class NullContainer extends Container {
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return false;
    }
}
