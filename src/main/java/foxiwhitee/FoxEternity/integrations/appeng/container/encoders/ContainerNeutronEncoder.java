package foxiwhitee.FoxEternity.integrations.appeng.container.encoders;

import foxiwhitee.FoxEternity.integrations.appeng.tile.encoders.TileNeutronEncoder;
import foxiwhitee.FoxLib.container.slots.SlotFake;
import foxiwhitee.FoxLib.container.slots.SlotFiltered;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import static foxiwhitee.FoxEternity.utils.Filters.*;

public class ContainerNeutronEncoder extends ContainerUniversalEncoder {
    public ContainerNeutronEncoder(EntityPlayer player, TileNeutronEncoder tileEntity) {
        super(player, tileEntity);

        bindPlayerInventory(17, 117);

        addSlotToContainer(new SlotFiltered(EMPTY_PATTERNS.getFilter(), tileEntity.getInternalInventory(), 0, 169, 26));
        addSlotToContainer(new SlotFiltered(PATTERNS.getFilter(), tileEntity.getInternalInventory(), 1, 169, 72));

        addSlotToContainer(new Slot(tileEntity.getOutputInventory(), 0, 109, 49) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }

            @Override
            public boolean canTakeStack(EntityPlayer p_82869_1_) {
                return false;
            }
        });

        addSlotToContainer(new SlotFake(tileEntity.getCraftingInventory(), 0, 42, 49));
    }
}
