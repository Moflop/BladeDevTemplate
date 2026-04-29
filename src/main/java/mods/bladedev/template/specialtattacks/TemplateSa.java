package mods.bladedev.template.specialtattacks;

import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

/**
 * SA的逻辑代码
 *
 * @author Arcomit
 * @since 2026-04-29
 */
public class TemplateSa {
	public static void doSpecialAttack(LivingEntity user) {
		Level level = user.level();
		if (level.isClientSide) return;

		ItemStack handItem = user.getMainHandItem();
		if (!(handItem.getItem() instanceof ItemSlashBlade)) return;

		// 这里实现特殊攻击(SA)的代码逻辑，比如这里是召唤一个幻影剑向前射
		handItem.getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {
			EntityAbstractSummonedSword ss = new EntityAbstractSummonedSword(
				SlashBlade.RegistryEvents.SummonedSword, level);

			Vec3 pos = user.getEyePosition(1.0f);
			ss.setPos(pos.x, pos.y, pos.z);
			ss.setDamage(1);

			Vec3 dir = user.getViewVector(1.0f);

			// 朝着玩家正前方发射 (方向X, 方向Y, 方向Z, 速度, 散射度)
			ss.shoot(dir.x, dir.y, dir.z, 3.0f, 0.0f);

			ss.setOwner(user);
			ss.setColor(state.getColorCode());
			ss.setRoll(user.getRandom().nextFloat() * 360.0f);
			level.addFreshEntity(ss);
		});
	}
}
