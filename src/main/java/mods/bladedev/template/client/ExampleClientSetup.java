package mods.bladedev.template.client;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.bladedev.template.init.BdtComboStates;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.compat.playerAnim.PlayerAnimationOverrider;
import mods.flammpfeil.slashblade.compat.playerAnim.VmdAnimation;
import mods.flammpfeil.slashblade.event.client.UserPoseOverrider;
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
@SuppressWarnings("removal")
@Mod.EventBusSubscriber(modid = BladeDevTemplateMod.MODID, value = Dist.CLIENT)
public class ExampleClientSetup {
	@SubscribeEvent
	public static void onClientSetup(final FMLClientSetupEvent event) {
		if (LoaderUtil.isClassAvailable("dev.kosmx.playerAnim.api.layered.AnimationStack")) {
			initPlayerAnimation();
		}
	}

	private static final ResourceLocation PLAYER_ANIM_LOCATION = new ResourceLocation(SlashBlade.MODID,
		"model/pa/player_motion.vmd");
	public static void initPlayerAnimation() {
		PlayerAnimationOverrider.getInstance().getAnimation().put(
			BdtComboStates.SA_TEMPLATE.getId(),
			new VmdAnimation(PLAYER_ANIM_LOCATION, 1100, 1132, false).setBlendLegs(false));
	}
}
