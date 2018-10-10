package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import java.util.Random;

public class mcreator_misterrredstonesstoneblock {

	public static Object instance;
	public static Block block;
	static {
		block = new BlockCustom().setHardness(1.5F).setResistance(20F).setLightLevel(0F).setUnlocalizedName("misterrredstonesstoneblock")
				.setLightOpacity(0).setCreativeTab(mcreator_blocktab0w.tab);
	}

	public void preInit(FMLPreInitializationEvent event) {
		block.setHarvestLevel("shovel", 0);
		block.setRegistryName("misterrredstonesstoneblock");
		ForgeRegistries.BLOCKS.register(block);
		ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	public void load(FMLInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			Minecraft
					.getMinecraft()
					.getRenderItem()
					.getItemModelMesher()
					.register(Item.getItemFromBlock(block), 0,
							new ModelResourceLocation("testenvironmentmod:misterrredstonesstoneblock", "inventory"));
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 4; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(117) + 44;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.NETHERRACK)))
					.generate(world, random, new BlockPos(x, y, z));
		}
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

	public static class BlockCustom extends Block {

		private boolean red = false;

		public BlockCustom() {
			super(Material.GRASS);
			setSoundType(SoundType.WOOD);
		}

		@SideOnly(Side.CLIENT)
		@Override
		public BlockRenderLayer getBlockLayer() {
			return BlockRenderLayer.SOLID;
		}

		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
			return new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
		}

		@Override
		public int tickRate(World world) {
			return 10;
		}

		@Override
		public int quantityDropped(Random random) {
			return 1;
		}

		@Override
		public int getWeakPower(IBlockState state, IBlockAccess baccess, BlockPos pos, EnumFacing side) {
			return red ? 15 : 0;
		}

		@Override
		public int getStrongPower(IBlockState state, IBlockAccess baccess, BlockPos pos, EnumFacing side) {
			return red ? 15 : 0;
		}

		@Override
		public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random random) {
			EntityPlayer entity = Minecraft.getMinecraft().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Block block = this;
			int i = x;
			int j = y;
			int k = z;
			if (true)
				for (int l = 0; l < 2; ++l) {
					double d0 = (double) ((float) i + random.nextFloat());
					double d1 = (double) ((float) j + random.nextFloat());
					double d2 = (double) ((float) k + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = ((double) random.nextFloat() - 0.5D) * 0.4999999985098839D;
					double d4 = ((double) random.nextFloat() - 0.5D) * 0.4999999985098839D;
					double d5 = ((double) random.nextFloat() - 0.5D) * 0.4999999985098839D;
					world.spawnParticle(EnumParticleTypes.NOTE, d0, d1, d2, d3, d4, d5);
				}
		}
	}
}
