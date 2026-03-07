package foxiwhitee.FoxEternity.integrations.appeng.tile.encoders;

import fox.spiteful.avaritia.crafting.ExtremeCraftingManager;
import foxiwhitee.FoxEternity.integrations.appeng.AE2Integration;
import foxiwhitee.FoxEternity.utils.NullContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.List;

public class TileBigEncoder extends TileUniversalPatternEncoder {
    public TileBigEncoder() {
        super(81);
    }

    @Override
    protected Item getEncodedPattern() {
        return AE2Integration.encodedBigPattern;
    }

    @Override
    public void updateRecipe() {
        InventoryCrafting ic = new InventoryCrafting(new NullContainer(), 9, 9);

        for (int x = 0; x < ic.getSizeInventory(); x++) {
            ic.setInventorySlotContents(x, getCraftingInventory().getStackInSlot(x));
        }

        IRecipe recipe = findMatchingRecipe(ic, worldObj);
        ItemStack is = recipe == null ? null : recipe.getRecipeOutput();
        this.getOutputInventory().setInventorySlotContents(0, is);
    }

    private IRecipe findMatchingRecipe(InventoryCrafting matrix, World world) {
        for(int j = 0; j < ExtremeCraftingManager.getInstance().getRecipeList().size(); j++) {
            IRecipe iRecipe = ExtremeCraftingManager.getInstance().getRecipeList().get(j);
            if (iRecipe.matches(matrix, world)) {
                return iRecipe;
            }
        }

        return null;
    }

    @Override
    public void overlayRecipe(NBTTagCompound nbtTagCompound, EntityPlayer entityPlayer) {
        clearCraftingInventory();
        List<List<ItemStack>> all = readIngredients(nbtTagCompound);
        for (int i = 0; i < all.size(); i++) {
            List<ItemStack> list = all.get(i);
            if (list != null && !list.isEmpty()) {
                getCraftingInventory().setInventorySlotContents(i, list.get(0));
            }
        }
    }

    private void clearCraftingInventory() {
        for (int i = 0; i < getCraftingInventory().getSizeInventory(); i++) {
            getCraftingInventory().setInventorySlotContents(i, null);
        }
    }
}
