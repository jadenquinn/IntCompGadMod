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
import net.minecraft.init.Blocks;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.Minecraft;

import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;

public class mcreator_theCrapper0 {

	public static Object instance;
	public static int mobid = 3;
	public static int mobid2 = 4;

	public void preInit(FMLPreInitializationEvent event) {
		EntityRegistry.registerModEntity(new ResourceLocation("testenvironmentmod:thecrapper0"), EntitytheCrapper0.class, "thecrapper0", mobid,
				instance, 64, 1, true, -16750849, -13434829);
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntitytheCrapper0.class, 30, 5, 15, EnumCreatureType.MONSTER, spawnBiomes);
		DungeonHooks.addDungeonMob(new ResourceLocation("testenvironmentmod:thecrapper0"), 180);
		EntityRegistry.registerModEntity(new ResourceLocation("testenvironmentmod:entitybulletthecrapper0"), EntityArrowCustom.class,
				"entitybulletthecrapper0", mobid2, instance, 64, 1, true);
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
		RenderLiving customRender = new RenderLiving(Minecraft.getMinecraft().getRenderManager(), new ModelCreeper(), 0) {

			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("newskincreeper.png");
			}
		};
		RenderingRegistry.registerEntityRenderingHandler(EntitytheCrapper0.class, customRender);
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, new RenderSnowball<EntityArrowCustom>(Minecraft.getMinecraft()
				.getRenderManager(), null, Minecraft.getMinecraft().getRenderItem()) {

			public ItemStack getStackToRender(EntityArrowCustom entityIn) {
				return new ItemStack(Blocks.TORCH, (int) (1));
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

	public static class EntitytheCrapper0 extends EntityAnimal implements IRangedAttackMob {

		public EntitytheCrapper0(World world) {
			super(world);
			addRandomArmor();
			experienceValue = 19;
			this.isImmuneToFire = true;
			setNoAI(!true);
			this.tasks.addTask(1, new EntityAIWander(this, 1));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 0.5));
			this.tasks.addTask(5, new EntityAIPanic(this, 1.2));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(7, new EntityAIEatGrass(this));
			this.tasks.addTask(8, new EntityAIBreakDoor(this));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(mcreator_item0.block, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.bobber.splash"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.creeper.primed"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY
					.getObject(new ResourceLocation("item.chorus_fruit.teleport"));
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
				mcreator_diamondGiver1.executeProcedure($_dependencies);
			}
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			int x = (int) this.posX;
			int y = (int) this.posY;
			int z = (int) this.posZ;
			Entity entity = this;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				mcreator_dropBlockdiamond1.executeProcedure($_dependencies);
			}
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
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Blocks.PISTON_EXTENSION, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Blocks.PISTON_HEAD, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.MOB_SPAWNER, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(mcreator_pinkestarmor.body, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(mcreator_protectionImbuingChuteN.block, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(mcreator_item0.block, (int) (1)));
		}

		@Override
		public EntitytheCrapper0 createChild(EntityAgeable ageable) {
			return new EntitytheCrapper0(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Blocks.EMERALD_BLOCK, (int) (1)).getItem() == stack.getItem())
				return true;
			if (new ItemStack(Blocks.SLIME_BLOCK, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}

		protected void dropRareDrop(int par1) {
			this.dropItem(new ItemStack(mcreator_pinkestarmor.body, (int) (1)).getItem(), 1);
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
					double d0 = (double) ((float) i + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.4000000014901161D;
					double d1 = ((double) ((float) j + 0.7F) + (double) (random.nextFloat() - 0.5F) * 0.4000000014901161D * 100) + 0.5D;
					double d2 = (double) ((float) k + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.4000000014901161D;
					world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, d0 - 0.27000001072883606D, d1 + 0.2199999988079071D, d2, 0.0D, 0.0D, 0.0D);
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
