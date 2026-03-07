package foxiwhitee.FoxEternity.integrations.appeng.container.assemblers;

import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileAssembler;
import foxiwhitee.FoxEternity.utils.Filters;
import foxiwhitee.FoxLib.container.FoxBaseContainer;
import foxiwhitee.FoxLib.container.slots.SlotFiltered;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerAssembler extends FoxBaseContainer {
    public ContainerAssembler(EntityPlayer player, TileAssembler tileEntity) {
        super(player, tileEntity);

        bindPlayerInventory(17, 117);

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 9; ++j) {
                addSlotToContainer(new SlotFiltered(Filters.PATTERNS.getFilter(), tileEntity.getInternalInventory(), j + i * 9, 25 + j * 18, 22 + i * 18));
            }
        }
    }
}
