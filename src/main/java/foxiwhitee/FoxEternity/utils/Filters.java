package foxiwhitee.FoxEternity.utils;

import fox.spiteful.avaritia.blocks.BlockNeutronCollector;
import foxiwhitee.FoxEternity.api.IHasNeutronSynthesizerIntegration;
import foxiwhitee.FoxLib.container.slots.SlotFiltered;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import java.util.function.Predicate;

public enum Filters {
    COLLECTOR("collectors", stack -> itemInstanceof(stack, IHasNeutronSynthesizerIntegration.class) || blockInstanceof(stack, BlockNeutronCollector.class));

    private final String filter;
    Filters(String id, Predicate<ItemStack> filter) {
        this.filter = id;
        SlotFiltered.filters.put(id, filter);
    }

    public String getFilter() {
        return filter;
    }

    @SafeVarargs
    private static boolean blockInstanceof(ItemStack stack, Class<? extends Block>... classes) {
        boolean b = false;
        for (Class<? extends Block> clazz : classes) {
            if (clazz.isInstance(Block.getBlockFromItem(stack.getItem()))) {
                b = true;
                break;
            }
        }
        return b;
    }

    private static boolean itemInstanceof(ItemStack stack, Class<?>... classes) {
        boolean b = false;
        for (Class<?> clazz : classes) {
            if (clazz.isInstance(stack.getItem())) {
                b = true;
                break;
            }
        }
        return b;
    }
}
