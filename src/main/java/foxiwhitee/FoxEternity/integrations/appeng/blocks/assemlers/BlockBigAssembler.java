package foxiwhitee.FoxEternity.integrations.appeng.blocks.assemlers;

import cpw.mods.fml.client.registry.RenderingRegistry;
import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileBigAssembler;

public class BlockBigAssembler extends BlockAssembler {
    private static final int renderId = RenderingRegistry.getNextAvailableRenderId();

    public BlockBigAssembler(String name) {
        super(name, TileBigAssembler.class);
        super.renderId = renderId;
    }

}
