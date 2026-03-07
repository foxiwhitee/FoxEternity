package foxiwhitee.FoxEternity.integrations.appeng.container.encoders;

import foxiwhitee.FoxEternity.integrations.appeng.tile.encoders.TileBigEncoder;
import foxiwhitee.FoxLib.container.slots.SlotFake;
import foxiwhitee.FoxLib.container.slots.SlotFiltered;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import static foxiwhitee.FoxEternity.utils.Filters.EMPTY_PATTERNS;
import static foxiwhitee.FoxEternity.utils.Filters.PATTERNS;

public class ContainerBigEncoder extends ContainerUniversalEncoder {
    public ContainerBigEncoder(EntityPlayer player, TileBigEncoder tileEntity) {
        super(player, tileEntity);

        bindPlayerInventory(66, 221);

        addSlotToContainer(new SlotFiltered(EMPTY_PATTERNS.getFilter(), tileEntity.getInternalInventory(), 0, 267, 71));
        addSlotToContainer(new SlotFiltered(PATTERNS.getFilter(), tileEntity.getInternalInventory(), 1, 267, 117));

        addSlotToContainer(new Slot(tileEntity.getOutputInventory(), 0, 227, 94) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }

            @Override
            public boolean canTakeStack(EntityPlayer p_82869_1_) {
                return false;
            }
        });

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                addSlotToContainer(new SlotFake(tileEntity.getCraftingInventory(), j + i * 9, 22 + j * 18, 22 + i * 18));
            }
        }
    }
}
