package foxiwhitee.FoxEternity.integrations.appeng.items.block;

import foxiwhitee.FoxEternity.config.FEConfig;
import foxiwhitee.FoxEternity.integrations.appeng.AE2Integration;
import foxiwhitee.FoxLib.items.ModItemBlock;
import foxiwhitee.FoxLib.utils.helpers.LocalizationUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBlockAssembler extends ModItemBlock {
    public ItemBlockAssembler(Block b) {
        super(b);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List<String> list, boolean p_77624_4_) {
        if (FEConfig.enableTooltips) {
            if (isBlock(AE2Integration.bigAssembler)) {
                list.add(LocalizationUtils.localizeF("tooltip.assembler.description", FEConfig.bigAssemblerSpeed));
            }
            if (isBlock(AE2Integration.neutronAssembler)) {
                list.add(LocalizationUtils.localizeF("tooltip.assembler.description", FEConfig.neutronAssemblerSpeed));
            }
        }
    }
}
