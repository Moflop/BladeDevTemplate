package mods.bladedev.template.data;

import mods.bladedev.template.init.BdtBlades;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.recipe.RequestDefinition;
import mods.flammpfeil.slashblade.recipe.SlashBladeIngredient;
import mods.flammpfeil.slashblade.recipe.SlashBladeShapedRecipeBuilder;
import mods.flammpfeil.slashblade.registry.SlashBladeItems;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

/**
 * 拔刀剑工作台合成配方数据包生成器
 *
 * @author Arcomit
 * @since 2026-04-29
 */
public class BdtRecipeProvider extends RecipeProvider implements IConditionBuilder {

	public BdtRecipeProvider(PackOutput output) {
		super(output);
	}

	@Override
	protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
		SlashBladeShapedRecipeBuilder.shaped(BdtBlades.TEMPLATE.location())
			.pattern("XXX")
			.pattern("XBX")
			.pattern("XXX")
			.define('B',
				SlashBladeIngredient.of(RequestDefinition.Builder.newInstance()
					.name(SlashBladeBuiltInRegistry.YAMATO.location())
					.killCount(99999)
					.proudSoul(10000)
					.refineCount(999)
					.addSwordType(
						SwordType.BEWITCHED
					)
					.addEnchantment(
						new EnchantmentDefinition(ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.POWER_ARROWS), 5),
						new EnchantmentDefinition(ForgeRegistries.ENCHANTMENTS.getKey(Enchantments.SHARPNESS), 4)
					)
					.build()))
			.define('X', Ingredient.of(Blocks.GOLD_BLOCK))
			.unlockedBy(getHasName(SBItems.slashblade), has(SBItems.slashblade))
			.save(consumer);

	}

	private static ResourceLocation getEnchantmentID(Enchantment enchantment) {
		return ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
	}
}
