package foxiwhitee.FoxEternity.integrations.appeng;

import appeng.core.Api;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import foxiwhitee.FoxEternity.config.ContentConfig;
import foxiwhitee.FoxEternity.integrations.IIntegration;
import foxiwhitee.FoxEternity.integrations.Integration;
import foxiwhitee.FoxEternity.integrations.appeng.blocks.assemblers.BlockBigAssembler;
import foxiwhitee.FoxEternity.integrations.appeng.blocks.assemblers.BlockNeutronAssembler;
import foxiwhitee.FoxEternity.integrations.appeng.blocks.encoders.BlockBigEncoder;
import foxiwhitee.FoxEternity.integrations.appeng.blocks.encoders.BlockNeutronEncoder;
import foxiwhitee.FoxEternity.integrations.appeng.client.render.RenderBigAssembler;
import foxiwhitee.FoxEternity.integrations.appeng.client.render.RenderNeutronAssembler;
import foxiwhitee.FoxEternity.integrations.appeng.container.assemblers.ContainerAssembler;
import foxiwhitee.FoxEternity.integrations.appeng.container.encoders.ContainerBigEncoder;
import foxiwhitee.FoxEternity.integrations.appeng.container.encoders.ContainerNeutronEncoder;
import foxiwhitee.FoxEternity.integrations.appeng.items.patterns.ItemEncodedBigPattern;
import foxiwhitee.FoxEternity.integrations.appeng.items.patterns.ItemEncodedNeutronPattern;
import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileBigAssembler;
import foxiwhitee.FoxEternity.integrations.appeng.tile.assemlers.TileNeutronAssembler;
import foxiwhitee.FoxEternity.integrations.appeng.tile.encoders.TileBigEncoder;
import foxiwhitee.FoxEternity.integrations.appeng.tile.encoders.TileNeutronEncoder;
import foxiwhitee.FoxEternity.items.block.AllItemBlock;
import foxiwhitee.FoxLib.api.FoxLibApi;
import foxiwhitee.FoxLib.registries.RegisterUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

@Integration(modid = "appliedenergistics2")
public class AE2Integration implements IIntegration {
    public final static Item encodedNeutronPattern = new ItemEncodedNeutronPattern("encodedNeutronPattern");
    public final static Item encodedBigPattern = new ItemEncodedBigPattern("encodedBigPattern");

    public final static Block neutronEncoder = new BlockNeutronEncoder("neutronEncoder");
    public final static Block bigEncoder = new BlockBigEncoder("bigEncoder");

    public final static Block neutronAssembler = new BlockNeutronAssembler("neutronAssembler");
    public final static Block bigAssembler = new BlockBigAssembler("bigAssembler");

    @Override
    public void preInit(FMLPreInitializationEvent paramFMLPreInitializationEvent) {
        if (ContentConfig.enableNeutronAssembler) {
            RegisterUtils.registerItem(encodedNeutronPattern);
            RegisterUtils.registerBlock(neutronEncoder, AllItemBlock.class);
            RegisterUtils.registerBlock(AllItemBlock.class, neutronAssembler);
            RegisterUtils.registerTile(TileNeutronEncoder.class);
            RegisterUtils.registerTile(TileNeutronAssembler.class);
        }
        if (ContentConfig.enableBigMolecularAssembler) {
            RegisterUtils.registerItem(encodedBigPattern);
            RegisterUtils.registerBlock(bigEncoder, AllItemBlock.class);
            RegisterUtils.registerBlock(AllItemBlock.class, bigAssembler);
            RegisterUtils.registerTile(TileBigEncoder.class);
            RegisterUtils.registerTile(TileBigAssembler.class);
        }
    }

    @Override
    public void init(FMLInitializationEvent paramFMLInitializationEvent) {
        FoxLibApi.instance.registries().registerGui()
                .register(BlockBigEncoder.class, TileBigEncoder.class, ContainerBigEncoder.class)
                .register(BlockNeutronEncoder.class, TileNeutronEncoder.class, ContainerNeutronEncoder.class)
                .register(BlockBigAssembler.class, TileBigAssembler.class, ContainerAssembler.class, "GuiBigAssembler")
                .register(BlockNeutronAssembler.class, TileNeutronAssembler.class, ContainerAssembler.class, "GuiNeutronAssembler");
        if (ContentConfig.enableNeutronAssembler) {
            Api.INSTANCE.registries().interfaceTerminal().register(TileNeutronAssembler.class);
        }
        if (ContentConfig.enableBigMolecularAssembler) {
            Api.INSTANCE.registries().interfaceTerminal().register(TileBigAssembler.class);
        }
        if (isClient()) {
            clientInit();
        }
    }

    @SideOnly(Side.CLIENT)
    public void clientInit() {
        if (ContentConfig.enableNeutronAssembler) {
            MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(neutronAssembler), new RenderNeutronAssembler());
            ClientRegistry.bindTileEntitySpecialRenderer(TileNeutronAssembler.class, new RenderNeutronAssembler());
        }
        if (ContentConfig.enableBigMolecularAssembler) {
            MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(bigAssembler), new RenderBigAssembler());
            ClientRegistry.bindTileEntitySpecialRenderer(TileBigAssembler.class, new RenderBigAssembler());
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent paramFMLPostInitializationEvent) {

    }
}
