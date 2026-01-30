package foxiwhitee.FoxEternity;

import foxiwhitee.FoxEternity.blocks.BlockNeutronSynthesizer;
import foxiwhitee.FoxEternity.blocks.collectors.*;
import foxiwhitee.FoxEternity.config.ContentConfig;
import foxiwhitee.FoxEternity.items.block.ItemBlockNeutronCollector;
import foxiwhitee.FoxEternity.tile.TileNeutronSynthesizer;
import foxiwhitee.FoxEternity.tile.collectors.*;
import foxiwhitee.FoxLib.registries.RegisterUtils;
import net.minecraft.block.Block;

public class ModBlocks {
    public static final Block basicNeutronCollector = new BlockBasicNeutronCollector("basicNeutronCollector");
    public static final Block advancedNeutronCollector = new BlockAdvancedNeutronCollector("advancedNeutronCollector");
    public static final Block hybridNeutronCollector = new BlockHybridNeutronCollector("hybridNeutronCollector");
    public static final Block ultimateNeutronCollector = new BlockUltimateNeutronCollector("ultimateNeutronCollector");
    public static final Block quantumNeutronCollector = new BlockQuantumNeutronCollector("quantumNeutronCollector");

    public static final Block neutronSynthesizer = new BlockNeutronSynthesizer("neutronSynthesizer");

    public static void registerBlocks() {
        registerCollectors();
        registerSynthesizer();
    }

    private static void registerCollectors() {
        if (ContentConfig.enableBasicNeutronCollector) {
            RegisterUtils.registerBlock(basicNeutronCollector, ItemBlockNeutronCollector.class);
            RegisterUtils.registerTile(TileBasicNeutronCollector.class);
        }
        if (ContentConfig.enableAdvancedNeutronCollector) {
            RegisterUtils.registerBlock(advancedNeutronCollector, ItemBlockNeutronCollector.class);
            RegisterUtils.registerTile(TileAdvancedNeutronCollector.class);
        }
        if (ContentConfig.enableHybridNeutronCollector) {
            RegisterUtils.registerBlock(hybridNeutronCollector, ItemBlockNeutronCollector.class);
            RegisterUtils.registerTile(TileHybridNeutronCollector.class);
        }
        if (ContentConfig.enableUltimateNeutronCollector) {
            RegisterUtils.registerBlock(ultimateNeutronCollector, ItemBlockNeutronCollector.class);
            RegisterUtils.registerTile(TileUltimateNeutronCollector.class);
        }
        if (ContentConfig.enableQuantumNeutronCollector) {
            RegisterUtils.registerBlock(quantumNeutronCollector, ItemBlockNeutronCollector.class);
            RegisterUtils.registerTile(TileQuantumNeutronCollector.class);
        }
    }

    private static void registerSynthesizer() {
        if (ContentConfig.enableNeutronSynthesizer) {
            RegisterUtils.registerBlock(neutronSynthesizer);
            RegisterUtils.registerTile(TileNeutronSynthesizer.class);
        }
    }

}
