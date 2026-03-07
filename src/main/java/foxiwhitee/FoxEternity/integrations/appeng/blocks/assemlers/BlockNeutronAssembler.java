package foxiwhitee.FoxEternity.integrations.appeng.blocks.assemlers;

import cpw.mods.fml.client.registry.RenderingRegistry;
import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileNeutronAssembler;

public class BlockNeutronAssembler extends BlockAssembler {
    private static final int renderId = RenderingRegistry.getNextAvailableRenderId();

    public BlockNeutronAssembler(String name) {
        super(name, TileNeutronAssembler.class);
        super.renderId = renderId;
    }
}
