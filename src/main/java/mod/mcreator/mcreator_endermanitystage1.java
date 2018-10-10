package mod.mcreator;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.Minecraft;

import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

public class mcreator_endermanitystage1 {

	public static Object instance;
	public static int mobid = 7;
	public static int mobid2 = 8;

	public void preInit(FMLPreInitializationEvent event) {
		EntityRegistry.registerModEntity(new ResourceLocation("testenvironmentmod:endermanitystage1"), Entityendermanitystage1.class,
				"endermanitystage1", mobid, instance, 64, 1, true, -16724737, -13434829);
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(Entityendermanitystage1.class, 1, 3, 20, EnumCreatureType.CREATURE, spawnBiomes);
		DungeonHooks.addDungeonMob(new ResourceLocation("testenvironmentmod:endermanitystage1"), 180);
	}

	private Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in) {
		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext()) {
			ls.add(itr.next());
		}
		return ls.toArray(new Biome[ls.size()]);
	}

	public void load(FMLInitializationEvent event) {
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void registerRenderers() {
		RenderBiped customRender = new RenderBiped(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0) {

			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("endermanity.png");
			}
		};
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerHeldItem(customRender));
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerBipedArmor(customRender) {

			protected void initArmor() {
				this.modelLeggings = new ModelBiped();
				this.modelArmor = new ModelBiped();
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(Entityendermanitystage1.class, customRender);
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public static class Entityendermanitystage1 extends EntityAnimal {

		public Entityendermanitystage1(World world) {
			super(world);
			addRandomArmor();
			experienceValue = 40;
			this.isImmuneToFire = true;
			setNoAI(!true);
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAIAvoidEntity(this, mcreator_thingybat.Entitythingybat.class, (float) 6, 1, 1.2));
			this.tasks.addTask(4, new EntityAIPanic(this, 1.2));
			this.tasks.addTask(5, new EntityAITempt(this, 3, new ItemStack(Blocks.GOLD_BLOCK, (int) (1)).getItem(), true));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, false));
			this.tasks.addTask(7, new EntityAIRestrictSun(this));
			this.tasks.addTask(8, new EntityAISwimming(this));
			this.tasks.addTask(9, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Blocks.REDSTONE_BLOCK, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.endermen.ambient"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.skeleton.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.endermite.death"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
		}

		@Override
		public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
			super.onStruckByLightning(entityLightningBolt);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				mcreator_dropBlockdiamond.executeProcedure($_dependencies);
			}
		}

		protected void addRandomArmor() {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Blocks.REDSTONE_BLOCK, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.TNT, (int) (1)));
		}

		@Override
		public Entityendermanitystage1 createChild(EntityAgeable ageable) {
			return new Entityendermanitystage1(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Blocks.GOLD_ORE, (int) (1)).getItem() == stack.getItem())
				return true;
			if (new ItemStack(Blocks.GOLD_BLOCK, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}

		protected void dropRareDrop(int par1) {
			this.dropItem(new ItemStack(Items.DIAMOND_SWORD, (int) (1)).getItem(), 1);
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 8; ++l) {
					double d0 = (double) ((float) i + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.3999999985098839D;
					double d1 = ((double) ((float) j + 0.7F) + (double) (random.nextFloat() - 0.5F) * 0.3999999985098839D * 100) + 0.5D;
					double d2 = (double) ((float) k + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.3999999985098839D;
					world.spawnParticle(EnumParticleTypes.PORTAL, d0 - 0.27000001072883606D, d1 + 0.2199999988079071D, d2, 0.0D, 0.0D, 0.0D);
				}
		}
	}
}
