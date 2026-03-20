package foxiwhitee.FoxEternity.integrations.appeng.items.patterns;

import appeng.api.networking.crafting.ICraftingPatternDetails;
import appeng.helpers.UltimatePatternHelper;
import appeng.items.misc.ItemEncodedPattern;
import foxiwhitee.FoxEternity.FECore;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEncodedBigPattern extends ItemEncodedPattern {
    public ItemEncodedBigPattern(String name) {
        super();
        setUnlocalizedName(name);
        setCreativeTab(FECore.TAB);
        setTextureName(FECore.MODID + ":" + name);
    }

    @Override
    public ICraftingPatternDetails getPatternForItem(ItemStack is, World w) {
        try {
            return new UltimatePatternHelper(is);
        } catch (final Throwable t) {
            return null;
        }
    }
}
