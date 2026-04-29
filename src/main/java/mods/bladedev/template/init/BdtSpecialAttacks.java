package mods.bladedev.template.init;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.flammpfeil.slashblade.registry.ComboStateRegistry;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * SA注册类
 *
 * @author Arcomit
 * @since 2026-04-30
 */
public class BdtSpecialAttacks {
	public static final DeferredRegister<SlashArts> SPECIAL_ARTS =
		DeferredRegister.create(SlashArts.REGISTRY_KEY, BladeDevTemplateMod.MODID);

	public static final RegistryObject<SlashArts> TEMPLATE = SPECIAL_ARTS.register("template",
		() -> new SlashArts((livingEntity) ->BdtComboStates.SA_TEMPLATE.getId())// 设置SA默认触发的Combo（这里为我们添加的Combo）
			.setComboStateJust((livingEntity) -> ComboStateRegistry.JUDGEMENT_CUT.getId())// 设置完美SA触发的Combo（这里为原版的次元斩）
			.setComboStateSuper(livingEntity -> ComboStateRegistry.RAPID_SLASH_QUICK.getId())// 设置超SA触发的Combo（这里为疾走聚合【右键可无限续的Quick版】）
	);

	public static void register(IEventBus modEventBus) {
		SPECIAL_ARTS.register(modEventBus);
	}
}
