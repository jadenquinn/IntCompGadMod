package mod.mcreator;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.Minecraft;

import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

public class mcreator_thingybat {

	public static Object instance;
	public static int mobid = 5;
	public static int mobid2 = 6;

	public void preInit(FMLPreInitializationEvent event) {
		EntityRegistry.registerModEntity(new ResourceLocation("testenvironmentmod:thingybat"), Entitythingybat.class, "thingybat", mobid, instance,
				64, 1, true, -13312, -10092442);
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(Entitythingybat.class, 1, 3, 10, EnumCreatureType.AMBIENT, spawnBiomes);
		DungeonHooks.addDungeonMob(new ResourceLocation("testenvironmentmod:thingybat"), 180);
		EntityRegistry.registerModEntity(new ResourceLocation("testenvironmentmod:entitybulletthingybat"), EntityArrowCustom.class,
				"entitybulletthingybat", mobid2, instance, 64, 1, true);
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
				return new ResourceLocation("newskinbat.png");
			}
		};
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerHeldItem(customRender));
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerBipedArmor(customRender) {

			protected void initArmor() {
				this.modelLeggings = new ModelBiped();
				this.modelArmor = new ModelBiped();
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(Entitythingybat.class, customRender);
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, new RenderSnowball<EntityArrowCustom>(Minecraft.getMinecraft()
				.getRenderManager(), null, Minecraft.getMinecraft().getRenderItem()) {

			public ItemStack getStackToRender(EntityArrowCustom entityIn) {
				return new ItemStack(Items.GOLD_INGOT, (int) (1));
			}
		});
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}

	public static class Entitythingybat extends EntityAnimal implements IRangedAttackMob {

		public Entitythingybat(World world) {
			super(world);
			addRandomArmor();
			experienceValue = 45;
			this.isImmuneToFire = false;
			setNoAI(!true);
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAIAvoidEntity(this, mcreator_mCMOBreskinnedCorruptedSteve.EntitymCMOBreskinnedCorruptedSteve.class,
					(float) 15, 1, 1.6));
			this.tasks.addTask(4, new EntityAISwimming(this));
			this.tasks.addTask(5, new EntityAILeapAtTarget(this, (float) 0.8));
			this.tasks.addTask(6, new EntityAIPanic(this, 1.2));
			this.tasks.addTask(7, new EntityAIMoveIndoors(this));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Blocks.FLOWING_WATER, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("testenvironmentmod:cave13"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testenvironmentmod:corruptedsteve4"));
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
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				mcreator_playydoundd.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void applyEntityAttributes() {
			super.applyEntityAttributes();
			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
			if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
		}

		@Override
		public void setSwingingArms(boolean swingingArms) {
		}

		public void attackEntityWithRangedAttack(EntityLivingBase target, float flval) {
			EntityArrowCustom entityarrow = new EntityArrowCustom(this.world, this);
			double d0 = target.posY + (double) target.getEyeHeight() - 1.1;
			double d1 = target.posX - this.posX;
			double d2 = d0 - entityarrow.posY;
			double d3 = target.posZ - this.posZ;
			float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
			entityarrow.shoot(d1, d2 + (double) f, d3, 1.6F, 12.0F);
			this.world.spawnEntity(entityarrow);
		}

		protected void addRandomArmor() {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Blocks.EMERALD_BLOCK, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.DIAMOND_ORE, (int) (1)));
		}

		@Override
		public Entitythingybat createChild(EntityAgeable ageable) {
			return new Entitythingybat(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Blocks.LAPIS_ORE, (int) (1)).getItem() == stack.getItem())
				return true;
			if (new ItemStack(Blocks.LAPIS_BLOCK, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}

		protected void dropRareDrop(int par1) {
			this.dropItem(new ItemStack(Blocks.FLOWING_LAVA, (int) (1)).getItem(), 1);
		}

		@Override
		public void travel(float ti, float tj, float tk) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden() && this.canBeSteered()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.renderYawOffset = this.rotationYaw;
				this.rotationYawHead = this.rotationYaw;
				this.stepHeight = 1.0F;
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
				if (this.canPassengerSteer()) {
					float f = (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.225F;
					this.setAIMoveSpeed(f);
					super.travel(0.0F, 0.0F, 1.0F);
				} else {
					this.motionX = 0.0D;
					this.motionY = 0.0D;
					this.motionZ = 0.0D;
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.posX - this.prevPosX;
				double d0 = this.posZ - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
			} else {
				this.stepHeight = 0.5F;
				this.jumpMovementFactor = 0.02F;
				super.travel(ti, tj, tk);
			}
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 8; ++l) {
					double d0 = (double) ((float) i + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.2999999985098839D;
					double d1 = ((double) ((float) j + 0.7F) + (double) (random.nextFloat() - 0.5F) * 0.2999999985098839D) + 0.5D;
					double d2 = (double) ((float) k + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.2999999985098839D;
					world.spawnParticle(EnumParticleTypes.WATER_WAKE, d0 - 0.27000001072883606D, d1 + 0.2199999988079071D, d2, 0.0D, 0.0D, 0.0D);
				}
		}
	}

	public static class EntityArrowCustom extends EntityTippedArrow {

		public EntityArrowCustom(World a) {
			super(a);
		}

		public EntityArrowCustom(World worldIn, double x, double y, double z) {
			super(worldIn, x, y, z);
		}

		public EntityArrowCustom(World worldIn, EntityLivingBase shooter) {
			super(worldIn, shooter);
		}
	}
}
