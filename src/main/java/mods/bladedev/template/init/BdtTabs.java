package mods.bladedev.template.init;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.flammpfeil.slashblade.SlashBladeCreativeGroup;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.registry.SlashBladeItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * 创造物品栏注册类
 *
 * @author Arcomit
 * @since 2026-04-29
 */
public class BdtTabs {
    private static final DeferredRegister<CreativeModeTab> TBAS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BladeDevTemplateMod.MODID);

    public static final RegistryObject<CreativeModeTab> EVIL_BLADE_TAB = TBAS.register("blade_dev_template_tab", () -> CreativeModeTab.builder()
            // 设置所要展示的页的名称
            .title(Component.translatable("item_group." + BladeDevTemplateMod.MODID + ".tab"))
            // 设置页图标
            .icon(() -> {
                ItemStack blade = new ItemStack(SlashBladeItems.SLASHBLADE.get());
                blade.getCapability(ItemSlashBlade.BLADESTATE).ifPresent(bladeState -> {
                    bladeState.setModel(BladeDevTemplateMod.prefix("model/blade/template.obj"));
                    bladeState.setTexture(BladeDevTemplateMod.prefix("model/blade/template.png"));
                });
                return blade;
            })
            // 物品栏在拔刀剑创造物品栏之后
            .withTabsBefore(SlashBladeCreativeGroup.SLASHBLADE_GROUP.getKey())
            .build()
    );

    public static void register(IEventBus modEventBus) {
        TBAS.register(modEventBus);
    }
}
