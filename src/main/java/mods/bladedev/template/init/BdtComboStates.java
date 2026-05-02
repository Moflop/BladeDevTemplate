package mods.bladedev.template.init;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.bladedev.template.specialtattacks.TemplateSa;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.compat.playerAnim.PlayerAnimationOverrider;
import mods.flammpfeil.slashblade.compat.playerAnim.VmdAnimation;
import mods.flammpfeil.slashblade.event.client.UserPoseOverrider;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * 连招注册类
 *
 * @author Arcomit
 * @since 2026-04-29
 */
public class BdtComboStates {
    public static final DeferredRegister<ComboState> COMBO_STATES =
            DeferredRegister.create(ComboState.REGISTRY_KEY, BladeDevTemplateMod.MODID);

    public static final RegistryObject<ComboState> SA_TEMPLATE = COMBO_STATES.register(
            "sa_template",
            ComboState.Builder.newInstance()
                    .startAndEnd(1100, 1122)
                    .priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(5, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> SlashBlade.prefix("aerial_rave_a1_end"))
                    .clickAction(TemplateSa::doSpecialAttack)
                    .addTickAction(UserPoseOverrider::resetRot)
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static void register(IEventBus modEventBus) {
        COMBO_STATES.register(modEventBus);
    }
}
