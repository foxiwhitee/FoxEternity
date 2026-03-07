package foxiwhitee.FoxEternity;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import foxiwhitee.FoxEternity.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import static foxiwhitee.FoxEternity.FECore.*;

@Mod(modid = MODID, name = MODNAME, version = VERSION, dependencies = DEPEND)
public class FECore {
    public static final String
        MODID = "foxeternity",
        MODNAME = "FoxEternity",
        VERSION = "1.0.0",
        DEPEND = "required-after:foxlib;required-after:Avaritia;after:appliedenergistics2;";


    public static final CreativeTabs TAB = new CreativeTabs("FOX_ETERNITY_TAB") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.bedrock);
        }
    };

    @SidedProxy(clientSide = "foxiwhitee.FoxEternity.proxy.ClientProxy", serverSide = "foxiwhitee.FoxEternity.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
