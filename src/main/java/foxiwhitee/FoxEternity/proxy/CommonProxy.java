package foxiwhitee.FoxEternity.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fox.spiteful.avaritia.crafting.Gregorizer;
import foxiwhitee.FoxEternity.ModBlocks;
import foxiwhitee.FoxEternity.ModItems;
import foxiwhitee.FoxEternity.ModRecipes;
import foxiwhitee.FoxEternity.blocks.BlockNeutronSynthesizer;
import foxiwhitee.FoxEternity.blocks.collectors.*;
import foxiwhitee.FoxEternity.container.ContainerNeutronCollector;
import foxiwhitee.FoxEternity.container.ContainerNeutronSynthesizer;
import foxiwhitee.FoxEternity.integrations.IntegrationLoader;
import foxiwhitee.FoxEternity.tile.TileNeutronSynthesizer;
import foxiwhitee.FoxEternity.tile.collectors.TileNeutronCollector;
import foxiwhitee.FoxLib.api.FoxLibApi;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        IntegrationLoader.preInit(event);
        if (Gregorizer.multiplier == 0) {
            Gregorizer.multiplier = 1;
        }
    }

    public void init(FMLInitializationEvent event) {
        FoxLibApi.instance.registries().registerGui()
                .register(BlockNeutronSynthesizer.class, TileNeutronSynthesizer.class, ContainerNeutronSynthesizer.class)
                .register(BlockAdvancedNeutronCollector.class, TileNeutronCollector.class, ContainerNeutronCollector.class)
                .register(BlockBasicNeutronCollector.class, TileNeutronCollector.class, ContainerNeutronCollector.class)
                .register(BlockHybridNeutronCollector.class, TileNeutronCollector.class, ContainerNeutronCollector.class)
                .register(BlockQuantumNeutronCollector.class, TileNeutronCollector.class, ContainerNeutronCollector.class)
                .register(BlockUltimateNeutronCollector.class, TileNeutronCollector.class, ContainerNeutronCollector.class);
        IntegrationLoader.init(event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModRecipes.initRecipes();
        IntegrationLoader.postInit(event);
    }
}
