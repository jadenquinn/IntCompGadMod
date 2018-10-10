package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.client.model.ModelLoader;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;

import java.util.Random;
import java.util.HashMap;

public class mcreator_fluidCalledPortal1122 {

	public static Object instance;
	public static BlockFluidClassic block = null;
	public static Item item = null;
	private static Fluid fluid = null;
	static {
		FluidRegistry.enableUniversalBucket();
		ResourceLocation still = new ResourceLocation("blocks/lavaportalblock");
		ResourceLocation flowing = new ResourceLocation("blocks/lavaportalblock");
		fluid = new Fluid("fluidcalledportal1122", still, flowing).setLuminosity(4).setDensity(2345).setViscosity(239).setGaseous(false);
		FluidRegistry.registerFluid(fluid);
		block = new BlockFluidClassic(fluid, Material.LAVA) {

			@Override
			public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
				super.onEntityCollidedWithBlock(world, pos, state, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					mcreator_diamondGiver1.executeProcedure($_dependencies);
				}
			}
		};
	}

	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.addBucketForFluid(fluid);
		block.setUnlocalizedName("fluidCalledPortal1122");
		block.setRegistryName("fluid." + block.getFluid().getName());
		ForgeRegistries.BLOCKS.register(block);
		item = new ItemBlock(block);
		item.setRegistryName("fluidCalledPortal1122");
		ForgeRegistries.ITEMS.register(item);
		MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
		if (server != null && server.worlds.length > 0) {
			World world = server.worlds[0];
			if (!world.isRemote) {
				try {
					registerFluidModel();
				} catch (Exception ignored) {
				}
			}
		} else if (server == null) {
			try {
				registerFluidModel();
			} catch (Exception ignored) {
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private void registerFluidModel() {
		Item item = Item.getItemFromBlock(block);
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {

			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("testenvironmentmod:fluidcalledportal1122", "fluidcalledportal1122");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {

			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("testenvironmentmod:fluidcalledportal1122", "fluidcalledportal1122");
			}
		});
	}

	public void load(FMLInitializationEvent event) {
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void registerRenderers() {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}
}
