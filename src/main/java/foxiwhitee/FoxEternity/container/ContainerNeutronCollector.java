package foxiwhitee.FoxEternity.container;

import foxiwhitee.FoxEternity.tile.collectors.TileNeutronCollector;
import foxiwhitee.FoxLib.container.FoxBaseContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerNeutronCollector extends FoxBaseContainer {
    public ContainerNeutronCollector(EntityPlayer player, TileNeutronCollector tileEntity) {
        super(player, tileEntity);

        bindPlayerInventory(17, 117);

        addSlotToContainer(new Slot(tileEntity.getInternalInventory(), 0, 97, 49) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }
        });
    }
}
