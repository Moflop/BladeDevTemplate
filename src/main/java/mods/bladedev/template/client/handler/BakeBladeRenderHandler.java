package mods.bladedev.template.client.handler;

import mods.bladedev.template.init.BdtItems;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModel;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static mods.flammpfeil.slashblade.client.ClientHandler.bakeBlade;

/**
 * 用于自动为拔刀剑类物品处理BAKE相关内容，没有这个的话拔刀剑将显示为紫黑块
 *
 * @author Arcomit
 * @since 2026-04-30
 */
@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
@OnlyIn(Dist.CLIENT)
public class BakeBladeRenderHandler {
	@SubscribeEvent
	public static void setModelUser(final FMLClientSetupEvent event) {
		BdtItems.ITEMS.getEntries().forEach(item -> {
			if (item.get() instanceof ItemSlashBlade blade) {
				ItemProperties.register(blade, ResourceLocation.parse("slashblade:user"),
					(stack, level, entity, seed) -> {
						BladeModel.user = entity;
						return 0;
					}
				);
			}
		});
	}

	@SubscribeEvent()
	public static void baked(final ModelEvent.ModifyBakingResult event) {
		BdtItems.ITEMS.getEntries().forEach(item -> {
			if (item.get() instanceof ItemSlashBlade blade) {
				bakeBlade(blade, event);
			}
		});
	}
}
