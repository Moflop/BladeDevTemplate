package mods.bladedev.template.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.ISubtypeRegistration;
import mods.bladedev.template.BladeDevTemplateMod;
import mods.bladedev.template.init.BdtItems;
import mods.flammpfeil.slashblade.compat.jei.JEICompat;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.resources.ResourceLocation;

/**
 * JEI合成表兼容(一般无需修改)，用于在JEI中正确显示和区分不同的拔刀，防止因为NBT数据不同但ItemStack相同被视为一种拔刀而导致的显示问题
 *
 * @author Arcomit
 * @since 2026-04-29
 */
@SuppressWarnings("removal")
@JeiPlugin
public class BdtJeiCompat implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BladeDevTemplateMod.MODID, "jei_plugin");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        BdtItems.ITEMS.getEntries().forEach(item -> { // 遍历模组的所有物品注册项
            if (item.get() instanceof ItemSlashBlade blade) { // 如果是拔刀物品
                registration.registerSubtypeInterpreter(blade, JEICompat::syncSlashBlade); // 注册NBT数据解释器，使用NBT来区分不同的拔刀
            }
        });
    }
}
