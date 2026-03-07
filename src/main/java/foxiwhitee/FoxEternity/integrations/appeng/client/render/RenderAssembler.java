package foxiwhitee.FoxEternity.integrations.appeng.client.render;

import foxiwhitee.FoxEternity.FECore;
import foxiwhitee.FoxLib.client.render.TileEntitySpecialRendererObjWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public abstract class RenderAssembler<T extends TileEntity> extends TileEntitySpecialRendererObjWrapper<T> implements IItemRenderer {
    private final IModelCustom model;
    private final ResourceLocation cubeTexture;

    public RenderAssembler(Class<T> tile, String name) {
        super(tile, new ResourceLocation(FECore.MODID, "models/molecularAssembler.obj"), new ResourceLocation(FECore.MODID, "textures/blocks/assemblers/" + name + ".png"));
        this.model = AdvancedModelLoader.loadModel(new ResourceLocation(FECore.MODID, "models/molecularAssembler.obj"));
        this.cubeTexture = new ResourceLocation(FECore.MODID, "textures/blocks/assemblers/" + name + "Cube.png");
        this.createList("body");
        this.createList("cube");
    }

    public void renderAt(T tileEntity, double x, double y, double z, double f) {
        GL11.glPushMatrix();
        GL11.glEnable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glTranslated(x, y, z);
        GL11.glPushMatrix();
        GL11.glScaled(1, 1, 1);
        this.bindTexture();
        GL11.glTranslated(0.5, 0.0, 0.5);
        this.renderPart("body");

        this.bindTexture(cubeTexture);
        GL11.glMatrixMode(GL11.GL_TEXTURE);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        float textureWidth = 64;
        float textureHeight = cubeTextureHeight();
        float frameSize = 64;
        float scaleX = frameSize / textureWidth;
        float scaleY = frameSize / textureHeight;
        GL11.glScalef(scaleX, scaleY, 1.0F);
        int totalFrames = (int)(textureHeight / frameSize);
        long worldTime = Minecraft.getMinecraft().theWorld.getTotalWorldTime();
        int currentFrame = (int) ((worldTime / 2) % totalFrames);
        GL11.glTranslatef(0.0F, (float)currentFrame, 0.0F);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        this.renderPart("cube");
        GL11.glMatrixMode(GL11.GL_TEXTURE);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glDisable(3008);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }

    public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type) {
        return true;
    }

    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glTranslated(0, -0.5, 0);
        GL11.glScaled(1, 1, 1);
        switch (type) {
            case ENTITY:
                GL11.glScaled(1.35, 1.35, 1.35);
                GL11.glTranslated(0, 0, 0);
                break;
            case EQUIPPED, EQUIPPED_FIRST_PERSON:
                GL11.glScaled(1, 1, 1);
                GL11.glTranslated(0.5, 0.5, 0.5);
                break;
        }

        Minecraft.getMinecraft().renderEngine.bindTexture(this.getTexture());
        this.model.renderPart("body");

        Minecraft.getMinecraft().renderEngine.bindTexture(cubeTexture);
        GL11.glMatrixMode(GL11.GL_TEXTURE);
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        float textureWidth = 64;
        float textureHeight = cubeTextureHeight();
        float frameSize = 64;
        float scaleX = frameSize / textureWidth;
        float scaleY = frameSize / textureHeight;
        GL11.glScalef(scaleX, scaleY, 1.0F);
        int totalFrames = (int)(textureHeight / frameSize);
        long worldTime = Minecraft.getMinecraft().theWorld.getTotalWorldTime();
        int currentFrame = (int) ((worldTime / 2) % totalFrames);
        GL11.glTranslatef(0.0F, (float)currentFrame, 0.0F);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        this.model.renderPart("cube");
        GL11.glMatrixMode(GL11.GL_TEXTURE);
        GL11.glPopMatrix();
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    protected abstract float cubeTextureHeight();
}
