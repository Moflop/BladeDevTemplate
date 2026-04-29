package mods.bladedev.template.init;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.bladedev.template.item.BdtBladeItem;
import mods.flammpfeil.slashblade.item.ItemTierSlashBlade;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 物品注册类
 *
 * @author Arcomit
 * @since 2026-04-29
 */
public class BdtItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BladeDevTemplateMod.MODID);

    public static final RegistryObject<Item> ELE_BLADE = ITEMS.register("dev_template_blade",
            () -> new BdtBladeItem(new ItemTierSlashBlade(40, 4F), 4, 0.0F, (new Item.Properties())));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
