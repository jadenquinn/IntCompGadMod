package mod.mcreator;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

import java.util.Random;

public class mcreator_doesn6tma55er {

	public static Object instance;

	public mcreator_doesn6tma55er() {
	}

	public void load(FMLInitializationEvent event) {
		ItemStack smeltStack = new ItemStack(Blocks.SLIME_BLOCK, (int) (1));
		GameRegistry.addSmelting(new ItemStack(mcreator_intillectualPotionCore.block, (int) (1)), smeltStack, 1.0f);
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
