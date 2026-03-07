package foxiwhitee.FoxEternity.integrations.nei;

import codechicken.nei.PositionedStack;
import codechicken.nei.api.API;
import cpw.mods.fml.common.Optional;
import foxiwhitee.FoxEternity.FECore;
import foxiwhitee.FoxEternity.config.ContentConfig;
import foxiwhitee.FoxEternity.integrations.appeng.client.gui.encoders.GuiBigEncoder;
import foxiwhitee.FoxEternity.integrations.appeng.client.gui.encoders.GuiNeutronEncoder;
import foxiwhitee.FoxLib.nei.NeiConfiguration;
import foxiwhitee.FoxLib.nei.NeiConfigurationMethod;
import foxiwhitee.FoxLib.nei.NeiProcessor;

import java.util.*;

@SuppressWarnings("unused")
@NeiConfiguration(modName = FECore.MODNAME, modVersion = FECore.VERSION, modID = FECore.MODID, needMods = "Avaritia")
public class FEConfiguration extends NeiProcessor {

    @NeiConfigurationMethod(needMods = "appliedenergistics2")
    @Optional.Method(modid = "appliedenergistics2")
    public void configAE2() {
        if (ContentConfig.enableBigMolecularAssembler) {
            API.registerGuiOverlay(GuiBigEncoder.class, "extreme", 267, 15);
        }
        configuration()
            .addOverlay(GuiNeutronEncoder.class, "extreme_compression", ContentConfig.enableNeutronAssembler)
            .doNextIf(ContentConfig.enableBigMolecularAssembler)
            .addOverlay(GuiBigEncoder.class, "extreme")
            .addOverlaySorting(GuiBigEncoder.class, FEConfiguration::sort);
    }

    private static List<PositionedStack> sort(List<PositionedStack> items) {
        List<PositionedStack> result = new LinkedList<>();
        Map<Integer, PositionedStack> stacks = new HashMap<>();
        for (PositionedStack pStack : items) {
            if (pStack == null)
                continue;
            int x = pStack.relx / 18;
            int y = pStack.rely / 18;
            stacks.put(y * 9 + x, pStack);
        }

        for (int i = 0; i < 81; i++) {
            result.add(stacks.getOrDefault(i, null));
        }
        return result;
    }
}
