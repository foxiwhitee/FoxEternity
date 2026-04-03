package foxiwhitee.FoxEternity.integrations.appeng.blocks.assemblers;

import cpw.mods.fml.client.registry.RenderingRegistry;
import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileNeutronAssembler;
import foxiwhitee.FoxLib.utils.helpers.LocalizationUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class BlockNeutronAssembler extends BlockAssembler {
    private static final int renderId = RenderingRegistry.getNextAvailableRenderId();

    public BlockNeutronAssembler(String name) {
        super(name, TileNeutronAssembler.class);
        super.renderId = renderId;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> list, boolean b) {
        list.add(LocalizationUtils.localizeF("tooltip.assembler.description", FEConfig.neutronAssemblerSpeed));
    }
}
