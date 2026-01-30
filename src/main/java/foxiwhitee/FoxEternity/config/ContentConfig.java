package foxiwhitee.FoxEternity.config;

import foxiwhitee.FoxLib.config.Config;
import foxiwhitee.FoxLib.config.ConfigValue;

@Config(name = "FoxEternity-Content", folder = "Fox-Mods")
public class ContentConfig {
    @ConfigValue(category = "Content", desc = "Enable Basic Neutron Collector?")
    public static boolean enableBasicNeutronCollector = true;

    @ConfigValue(category = "Content", desc = "Enable Advanced Neutron Collector?")
    public static boolean enableAdvancedNeutronCollector = true;

    @ConfigValue(category = "Content", desc = "Enable Hybrid Neutron Collector?")
    public static boolean enableHybridNeutronCollector = true;

    @ConfigValue(category = "Content", desc = "Enable Ultimate Neutron Collector?")
    public static boolean enableUltimateNeutronCollector = true;

    @ConfigValue(category = "Content", desc = "Enable Quantum Neutron Collector?")
    public static boolean enableQuantumNeutronCollector = true;

    @ConfigValue(category = "Content", desc = "Enable Neutron Synthesizer?")
    public static boolean enableNeutronSynthesizer = true;
}
