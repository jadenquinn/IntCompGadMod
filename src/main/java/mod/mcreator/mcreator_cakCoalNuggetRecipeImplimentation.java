package mod.mcreator;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.init.Enchantments;

import java.util.Random;

public class mcreator_cakCoalNuggetRecipeImplimentation {

	public static Object instance;

	public mcreator_cakCoalNuggetRecipeImplimentation() {
	}

	public void load(FMLInitializationEvent event) {
		ItemStack recStack = new ItemStack(mcreator_extraCoal.block, (int) (1));
		recStack.addEnchantment(Enchantments.EFFICIENCY, 1);
		Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(mcreator_coalNugget0.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Items.COAL, (int) (1))),};
		GameRegistry.addShapelessRecipe(new ResourceLocation("testenvironmentmod:cakcoalnuggetrecipeimplimentation"), new ResourceLocation("custom"),
				recStack, recipe);
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public void registerRenderers() {
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}
}
