package mods.bladedev.template.client;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.bladedev.template.compat.playeranim.BdtPlayerAnimCompat;
import mods.bladedev.template.init.BdtComboStates;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.compat.playerAnim.PlayerAnimationOverrider;
import mods.flammpfeil.slashblade.compat.playerAnim.VmdAnimation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.util.LoaderUtil;

/**
 * TODO：描述
 *
 * @author Arcomit
 * @since 2026-05-02
 */
@Mod.EventBusSubscriber(modid = BladeDevTemplateMod.MODID, value = Dist.CLIENT)
public class ExampleClientSetup {
	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		if (LoaderUtil.isClassAvailable("dev.kosmx.playerAnim.api.layered.AnimationStack")) {
			BdtPlayerAnimCompat.initPlayerAnimation();
		}
	}

}
