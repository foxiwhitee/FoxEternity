package foxiwhitee.FoxEternity.integrations.appeng.tile.encoders;

import fox.spiteful.avaritia.crafting.CompressorManager;
import fox.spiteful.avaritia.crafting.CompressorRecipe;
import foxiwhitee.FoxEternity.integrations.appeng.AE2Integration;
import foxiwhitee.FoxLib.integration.applied.tile.TileUniversalPatternEncoder;
import foxiwhitee.FoxLib.utils.helpers.ItemStackUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public class TileNeutronEncoder extends TileUniversalPatternEncoder {
    public TileNeutronEncoder() {
        super(1);
    }

    @Override
    protected ItemStack getItemFromTile(Object o) {
        return new ItemStack(AE2Integration.neutronEncoder);
    }

    @Override
    protected Item getEncodedPattern() {
        return AE2Integration.encodedNeutronPattern;
    }

    @Override
    public void updateRecipe() {
        ItemStack stack = getCraftingInventory().getStackInSlot(0);
        if (stack != null) {
            for (int i = 0; i < CompressorManager.getRecipes().size(); ++i) {
                CompressorRecipe r = CompressorManager.getRecipes().get(i);
                if (r != null) {
                    if (ItemStackUtil.matchesStackAndOther(stack, r.getIngredient())) {
                        getOutputInventory().setInventorySlotContents(0, r.getOutput().copy());
                        this.strictInputCount = r.getCost();
                        return;
                    }
                }
            }
        }
        getOutputInventory().setInventorySlotContents(0, null);
        this.strictInputCount = 0;
    }

    @Override
    public void overlayRecipe(NBTTagCompound nbtTagCompound, EntityPlayer entityPlayer) {
        List<List<ItemStack>> all = readIngredients(nbtTagCompound);
        if (!all.isEmpty()) {
            if (!all.get(0).isEmpty()) {
                ItemStack stack = all.get(0).get(0);
                this.getCraftingInventory().setInventorySlotContents(0, stack.copy());
            }
        }
    }
}
