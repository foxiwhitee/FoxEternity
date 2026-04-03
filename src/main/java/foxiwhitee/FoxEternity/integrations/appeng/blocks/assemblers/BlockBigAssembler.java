package foxiwhitee.FoxEternity.integrations.appeng.blocks.assemblers;

import cpw.mods.fml.client.registry.RenderingRegistry;
import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileBigAssembler;
import foxiwhitee.FoxLib.utils.helpers.LocalizationUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockBigAssembler extends BlockAssembler {
    private static final int renderId = RenderingRegistry.getNextAvailableRenderId();

    public BlockBigAssembler(String name) {
        super(name, TileBigAssembler.class);
        super.renderId = renderId;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean b) {
        list.add(LocalizationUtils.localizeF("tooltip.assembler.description", FEConfig.bigAssemblerSpeed));
    }
}
