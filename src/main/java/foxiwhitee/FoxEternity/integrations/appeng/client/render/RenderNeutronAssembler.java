package foxiwhitee.FoxEternity.integrations.appeng.client.render;

import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileNeutronAssembler;

public class RenderNeutronAssembler extends RenderAssembler<TileNeutronAssembler> {
    public RenderNeutronAssembler() {
        super(TileNeutronAssembler.class, "neutronMolecularAssembler");
    }

    @Override
    protected float cubeTextureHeight() {
        return 640;
    }
}
