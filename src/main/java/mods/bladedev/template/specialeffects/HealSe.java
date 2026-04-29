package mods.bladedev.template.specialeffects;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.bladedev.template.init.BdtSpecialEffects;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * 一个示例SE，攻击时回血
 *
 * @author Arcomit
 * @since 2026-04-29
 */
@Mod.EventBusSubscriber(modid = BladeDevTemplateMod.MODID)
public class HealSe extends SpecialEffect {
	public HealSe() {
		// 这三个参数分别是需求等级，SE是否可复制，SE是否可移除
		super(10, false, true);
	}

	@SubscribeEvent
	public static void onEntityDamage(LivingDamageEvent event) {// 监听实体受伤事件
		// 确保逻辑只在服务端运行，避免客户端不同步问题
		if (event.getEntity().level().isClientSide()) {
			return;
		}

		// 判断伤害来源是否为玩家实体
		if (event.getSource().getEntity() instanceof Player player) {

			player.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent(state -> {// 获取玩家主手持有的刀状态
					if (state.hasSpecialEffect(BdtSpecialEffects.HEAL.getId())) {// 判断刀是否具有HEAL这个SE
						float damage = event.getAmount();// 获取伤害数值

						player.heal(damage / 2);// 给玩家回复生命值，回复的数值为伤害的一半
					}
				}
			);
		}
	}
}
