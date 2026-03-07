package foxiwhitee.FoxEternity.integrations.appeng.client.render;

import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileBigAssembler;

public class RenderBigAssembler extends RenderAssembler<TileBigAssembler> {
    public RenderBigAssembler() {
        super(TileBigAssembler.class, "bigMolecularAssembler");
    }

    @Override
    protected float cubeTextureHeight() {
        return 1024;
    }
}
