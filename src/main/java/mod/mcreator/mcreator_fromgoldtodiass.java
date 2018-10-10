package mod.mcreator;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

import java.util.Random;

public class mcreator_fromgoldtodiass {

	public static Object instance;

	public mcreator_fromgoldtodiass() {
	}

	public void load(FMLInitializationEvent event) {
		ItemStack recStack = new ItemStack(Blocks.DIAMOND_BLOCK, (int) (1));
		Ingredient[] recipe = {Ingredient.fromStacks(new ItemStack(Blocks.GOLD_BLOCK, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.GOLD_BLOCK, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.GOLD_BLOCK, (int) (1))),
				Ingredient.fromStacks(new ItemStack(Blocks.GOLD_BLOCK, (int) (1))),
				Ingredient.fromStacks(new ItemStack(mcreator_catalystsItems.block, (int) (1))),};
		GameRegistry.addShapelessRecipe(new ResourceLocation("testenvironmentmod:fromgoldtodiass"), new ResourceLocation("custom"), recStack, recipe);
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
