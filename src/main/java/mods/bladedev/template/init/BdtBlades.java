package mods.bladedev.template.init;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.flammpfeil.slashblade.client.renderer.CarryType;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.registry.SpecialEffectsRegistry;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.PropertiesDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.RenderDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;
import java.util.List;

/**
 * 拔刀注册类
 *
 * @author Arcomit
 * @since 2026-04-29
 */
public class BdtBlades {
    public static final ResourceKey<SlashBladeDefinition> TEMPLATE = createKey("template");

    public static void registerAll(BootstapContext<SlashBladeDefinition> bootstrap){
        bootstrap.register(TEMPLATE,
                new SlashBladeDefinition(
                        BdtItems.ELE_BLADE.getId(),
                        TEMPLATE.location(),
                        RenderDefinition.Builder.newInstance()
                                .textureName(BladeDevTemplateMod.prefix("model/blade/template.png"))
                                .modelName(BladeDevTemplateMod.prefix("model/blade/template.obj"))
                                .effectColor(Color.BLUE.getRGB())
                                .effectColorInverse(false)
                                .standbyRenderType(CarryType.DEFAULT)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                //.rootComboState()
                                .baseAttackModifier(4.0F)
                                .slashArtsType(BdtSpecialAttacks.TEMPLATE.getId())
                                .addSpecialEffect(BdtSpecialEffects.HEAL.getId())// 添加SE
                                .addSpecialEffect(SpecialEffectsRegistry.WITHER_EDGE.getId())// 添加拔刀剑原版的凋零性SE
                                .maxDamage(999)// 设置耐久
                                .setUnbreakable(false)// 设置是否无尽耐久（不可破坏）
                                .defaultSwordType(List.of(SwordType.BEWITCHED))// 设置默认刀的类型，这里设置为默认妖刀，无需改名只要有附魔就是妖刀了
                                .build(),
                        List.of( // 附魔列表
                                new EnchantmentDefinition(ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.POWER_ARROWS), 5),// 力量 5，抛瓦！！！！！
                                new EnchantmentDefinition(ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.SHARPNESS), 4)// 锋利 4
                        ),
                        BdtTabs.EVIL_BLADE_TAB.getId()// 所属创造物品栏标签 ID
                )
        );
    }

    public static ResourceKey<SlashBladeDefinition> createKey(String id) {
        ResourceKey<SlashBladeDefinition> loc = ResourceKey.create(SlashBladeDefinition.REGISTRY_KEY,
                BladeDevTemplateMod.prefix(id));
        return loc;
    }
}
