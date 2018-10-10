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

import java.util.Random;

public class mcreator_sugarCanetostickyy {

	public static Object instance;

	public mcreator_sugarCanetostickyy() {
	}

	public void load(FMLInitializationEvent event) {
		ItemStack recStack = new ItemStack(Items.STICK, (int) (3));
		Object[] recipe = {" 1 ", " 4 ", "   ", '1', Ingredient.fromStacks(new ItemStack(Items.REEDS, (int) (1))), '4',
				Ingredient.fromStacks(new ItemStack(Items.REEDS, (int) (1))),};
		GameRegistry.addShapedRecipe(new ResourceLocation("testenvironmentmod:sugarcanetostickyy"), new ResourceLocation("custom"), recStack, recipe);
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
