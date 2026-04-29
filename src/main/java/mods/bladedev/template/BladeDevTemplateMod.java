package mods.bladedev.template;

import com.mojang.logging.LogUtils;
import mods.bladedev.template.init.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * 这是你的MOD主类，Forge会在加载MOD时创建这个类的实例
 *
 * @author Arcomit
 * @since 2026-04-29
 */
@SuppressWarnings("removal")// new ResourceLocation被标记为过时，但为了兼容旧版本Forge，所以应依旧使用new ResourceLocation，并使用该注解抑制相关警告
@Mod(BladeDevTemplateMod.MODID)
public class BladeDevTemplateMod {

    // 你的MOD ID，必须与gradle.properties中的modId一致，modid应当只包含小写字母、数字和下划线（_）
    // 后续若看到BDT、Bdt、bdt，其为本模板的简写，请替换为你自己的MODID简写
    public static final String MODID = "blade_dev_template";
    private static final Logger LOGGER = LogUtils.getLogger();

    // Forge会在加载MOD时创建这个类的实例。你可以在这里注册事件、物品、方块等内容
    public BladeDevTemplateMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        BdtItems.register(modEventBus);
        BdtTabs.register(modEventBus);
        BdtComboStates.register(modEventBus);
        BdtSpecialAttacks.register(modEventBus);
        BdtSpecialEffects.register(modEventBus);
    }

    // 一个工具方法，用于创建带有MOD ID前缀的资源位置，方便注册物品、方块等内容时使用
    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(BladeDevTemplateMod.MODID, path);
    }
}
