package mods.bladedev.template.data;

import mods.bladedev.template.BladeDevTemplateMod;
import mods.bladedev.template.init.BdtBlades;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * 拔刀剑数据包生成器
 *
 * @author Arcomit
 * @since 2026-04-29
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = BladeDevTemplateMod.MODID)
public class BdtDataGenerator {
        @SubscribeEvent
        public static void onGatherData(GatherDataEvent event) {
                DataGenerator generator = event.getGenerator();
                PackOutput output = generator.getPackOutput();
                ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
                CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

                RegistrySetBuilder bladeBuilder = new RegistrySetBuilder().add(SlashBladeDefinition.REGISTRY_KEY,
                        BdtBlades::registerAll);
                generator.addProvider(event.includeServer(),
                        new DatapackBuiltinEntriesProvider(output, lookupProvider, bladeBuilder, Set.of(BladeDevTemplateMod.MODID)) {

                                @Override
                                public String getName() {
                                        return "SlashBlade Addon Dev Template Definition Registry";
                                }

                        });

                generator.addProvider(event.includeServer(), new BdtRecipeProvider(output));
        }
}
