package mods.bladedev.template.item;

import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.item.SwordType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

/**
 * 这是一个自定义拔刀剑刀类的示例，ItemSlashBlade，重写了显示刀刃类型和稀有度的方法
 *
 * @author Arcomit
 * @since 2026-04-29
 */
public class BdtBladeItem extends ItemSlashBlade {
	public BdtBladeItem(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	@Override
	public void appendSwordType(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		EnumSet<SwordType> swordType = SwordType.from(stack);
		if (!swordType.contains(SwordType.SEALED)) { // 封印状态下的刀不显示类型
			if (swordType.contains(SwordType.BEWITCHED)) { // 如果是妖刀状态（有附魔+默认就是妖刀或者玩家重命名过的刀）则将类型显示为蓝色的示例
				tooltip.add(Component.translatable("blade_dev_template.sword_type.example") // 显示的类型，游戏中显示对应lang文件（如zh_cn.json）中的值
					.withStyle(ChatFormatting.BLUE)); // 颜色
			} else if (swordType.contains(SwordType.ENCHANTED)) { // 如果是附魔状态（有附魔但不是妖刀玩家未重命名）则将类型显示为青色的示例2
				tooltip.add(Component.translatable("blade_dev_template.sword_type.example_2")
					.withStyle(ChatFormatting.AQUA));
			} else { // 不是妖刀也没有附魔的普通状态
				tooltip.add(Component.translatable("slashblade.sword_type.noname")
					.withStyle(ChatFormatting.DARK_GRAY));
			}

		}
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.EPIC; // 将稀有度设置为史诗级，游戏中会显示紫色的名字
	}
}
