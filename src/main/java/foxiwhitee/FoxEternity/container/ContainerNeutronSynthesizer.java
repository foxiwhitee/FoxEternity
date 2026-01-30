package foxiwhitee.FoxEternity.container;

import foxiwhitee.FoxEternity.tile.TileNeutronSynthesizer;
import foxiwhitee.FoxEternity.utils.Filters;
import foxiwhitee.FoxLib.container.FoxBaseContainer;
import foxiwhitee.FoxLib.container.slots.SlotFiltered;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerNeutronSynthesizer extends FoxBaseContainer {
    public ContainerNeutronSynthesizer(EntityPlayer player, TileNeutronSynthesizer tileEntity) {
        super(player, tileEntity);

        bindPlayerInventory(17, 153);

        for (int i = 0; i < 9; i++) {
            addSlotToContainer(new SlotFiltered(Filters.COLLECTOR.getFilter(), tileEntity.getCollectorsInventory(), i, 25 + i * 18, 22));
        }

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 9; ++j) {
                addSlotToContainer(new Slot(tileEntity.getInternalInventory(), j + i * 9, 25 + j * 18, 58 + i * 18) {
                    @Override
                    public boolean isItemValid(ItemStack stack) {
                        return false;
                    }
                });
            }
        }
    }
}
