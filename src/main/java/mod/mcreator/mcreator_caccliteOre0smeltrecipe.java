package mod.mcreator;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class mcreator_caccliteOre0smeltrecipe {

	public static Object instance;

	public mcreator_caccliteOre0smeltrecipe() {
	}

	public void load(FMLInitializationEvent event) {
		ItemStack recStack = new ItemStack(mcreator_cacclitegem111.block, (int) (1));
		Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(mcreator_caccliteOre0.block, (int) (1))),
				Ingredient.fromStacks(new ItemStack(mcreator_catalystsItems.block, (int) (1))),};
		GameRegistry.addShapelessRecipe(new ResourceLocation("testenvironmentmod:caccliteore0smeltrecipe"), new ResourceLocation("custom"), recStack,
				recipe);
		ItemStack smeltStack = new ItemStack(mcreator_cacclitegem111.block, (int) (1));
		GameRegistry.addSmelting(new ItemStack(mcreator_caccliteOre0.block, (int) (1)), smeltStack, 1.0f);
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
