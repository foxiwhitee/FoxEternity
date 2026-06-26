package foxiwhitee.FoxEternity.integrations.appeng.util;

import appeng.core.Api;
import appeng.items.misc.ItemEncodedPattern;
import foxiwhitee.FoxLib.container.slots.SlotFiltered;
import foxiwhitee.FoxLib.utils.inventory.ItemStackUtil;
import net.minecraft.item.ItemStack;

import java.util.function.Predicate;

public enum AppengFilters {
    PATTERNS("patterns", stack -> itemInstanceof(stack, ItemEncodedPattern.class)),
    EMPTY_PATTERNS("patternsEmpty", stack -> ItemStackUtil.stackEquals(stack, Api.INSTANCE.definitions().materials().blankPattern().maybeStack(1).orNull()));

    private final String filter;
    AppengFilters(String id, Predicate<ItemStack> filter) {
        this.filter = id;
        SlotFiltered.filters.put(id, filter);
    }

    public String getFilter() {
        return filter;
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
