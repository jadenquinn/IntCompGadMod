package mod.mcreator;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class mcreator_smeltsble00 {

	public static Object instance;

	public mcreator_smeltsble00() {
	}

	public void load(FMLInitializationEvent event) {
		ItemStack smeltStack = new ItemStack(mcreator_coalNugget0.block, (int) (1));
		GameRegistry.addSmelting(new ItemStack(mcreator_ligniteOreP.block, (int) (1)), smeltStack, 1.0f);
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
