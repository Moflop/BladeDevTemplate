package mods.bladedev.template.init;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.bladedev.template.specialeffects.HealSe;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * SE注册类
 *
 * @author Arcomit
 * @since 2026-04-29
 */
public class BdtSpecialEffects {
	public static final DeferredRegister<SpecialEffect> SPECIAL_EFFECT =
		DeferredRegister.create(SpecialEffect.REGISTRY_KEY, BladeDevTemplateMod.MODID);

	public static final RegistryObject<SpecialEffect> HEAL = SPECIAL_EFFECT.register("heal",
		HealSe::new);

	public static void register(IEventBus modEventBus) {
		SPECIAL_EFFECT.register(modEventBus);
	}
}
