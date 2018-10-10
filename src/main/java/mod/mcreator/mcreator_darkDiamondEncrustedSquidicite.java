package mod.mcreator;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import java.util.Random;

public class mcreator_darkDiamondEncrustedSquidicite {

	public static Object instance;
	public static Block block;
	static {
		block = new BlockCustom().setHardness(3.8499999999999996F).setResistance(38F).setLightLevel(0F)
				.setUnlocalizedName("darkdiamondencrustedsquidicite").setLightOpacity(255).setCreativeTab(mcreator_blocktab0w.tab);
	}

	public void preInit(FMLPreInitializationEvent event) {
		block.setHarvestLevel("pickaxe", 3);
		block.setRegistryName("darkdiamondencrustedsquidicite");
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
							new ModelResourceLocation("testenvironmentmod:darkdiamondencrustedsquidicite", "inventory"));
		}
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
		for (int i = 0; i < 3; i++) {
			int x = chunkX + random.nextInt(16);
			int y = random.nextInt(16) + 8;
			int z = chunkZ + random.nextInt(16);
			(new WorldGenMinable(block.getDefaultState(), 2, BlockMatcher.forBlock(Blocks.NETHERRACK)))
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
			super(Material.ROCK);
			setSoundType(SoundType.STONE);
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
		public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
				net.minecraftforge.common.IPlantable plantable) {
			return true;
		}

		@Override
		public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
			return true;
		}

		@Override
		public Item getItemDropped(IBlockState state, Random random, int l) {
			return new ItemStack(Blocks.GOLD_BLOCK, (int) (1)).getItem();
		}
	}
}
