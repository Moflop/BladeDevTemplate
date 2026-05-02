package mods.bladedev.template.compat.playeranim;

import mods.bladedev.template.init.BdtComboStates;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.compat.playerAnim.PlayerAnimationOverrider;
import mods.flammpfeil.slashblade.compat.playerAnim.VmdAnimation;
import net.minecraft.resources.ResourceLocation;

/**
 * TODO：描述
 *
 * @author Arcomit
 * @since 2026-05-02
 */
@SuppressWarnings("removal")
public class BdtPlayerAnimCompat {
	private static final ResourceLocation PLAYER_ANIM_LOCATION = new ResourceLocation(SlashBlade.MODID,
		"model/pa/player_motion.vmd");
	public static void initPlayerAnimation() {
		PlayerAnimationOverrider.getInstance().getAnimation().put(
			BdtComboStates.SA_TEMPLATE.getId(),
			new VmdAnimation(PLAYER_ANIM_LOCATION, 1100, 1132, false).setBlendLegs(false));
	}
}
