package mod.mcreator;

import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.common.DungeonHooks;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.BossInfo;
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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIAttackRanged;
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

public class mcreator_mCMOBreskinnedCorruptedSteve {

	public static Object instance;
	public static int mobid = 1;
	public static int mobid2 = 2;

	public void preInit(FMLPreInitializationEvent event) {
		EntityRegistry.registerModEntity(new ResourceLocation("testenvironmentmod:mcmobreskinnedcorruptedsteve"),
				EntitymCMOBreskinnedCorruptedSteve.class, "mcmobreskinnedcorruptedsteve", mobid, instance, 64, 1, true, -3407617, -16724788);
		Biome[] spawnBiomes = {Biome.REGISTRY.getObject(new ResourceLocation("ocean")), Biome.REGISTRY.getObject(new ResourceLocation("desert")),
				Biome.REGISTRY.getObject(new ResourceLocation("extreme_hills")), Biome.REGISTRY.getObject(new ResourceLocation("swampland")),
				Biome.REGISTRY.getObject(new ResourceLocation("hell")), Biome.REGISTRY.getObject(new ResourceLocation("sky")),
				Biome.REGISTRY.getObject(new ResourceLocation("savanna_rock")), Biome.REGISTRY.getObject(new ResourceLocation("mesa")),
				Biome.REGISTRY.getObject(new ResourceLocation("mutated_plains")),};
		EntityRegistry.addSpawn(EntitymCMOBreskinnedCorruptedSteve.class, 1, 1, 2, EnumCreatureType.MONSTER, spawnBiomes);
		DungeonHooks.addDungeonMob(new ResourceLocation("testenvironmentmod:mcmobreskinnedcorruptedsteve"), 180);
		EntityRegistry.registerModEntity(new ResourceLocation("testenvironmentmod:entitybulletmcmobreskinnedcorruptedsteve"),
				EntityArrowCustom.class, "entitybulletmcmobreskinnedcorruptedsteve", mobid2, instance, 64, 1, true);
	}

	public void load(FMLInitializationEvent event) {
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void registerRenderers() {
		RenderBiped customRender = new RenderBiped(Minecraft.getMinecraft().getRenderManager(), new ModelBiped(), 0) {

			protected ResourceLocation getEntityTexture(Entity par1Entity) {
				return new ResourceLocation("sure.png");
			}
		};
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerHeldItem(customRender));
		customRender.addLayer(new net.minecraft.client.renderer.entity.layers.LayerBipedArmor(customRender) {

			protected void initArmor() {
				this.modelLeggings = new ModelBiped();
				this.modelArmor = new ModelBiped();
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntitymCMOBreskinnedCorruptedSteve.class, customRender);
		RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, new RenderSnowball<EntityArrowCustom>(Minecraft.getMinecraft()
				.getRenderManager(), null, Minecraft.getMinecraft().getRenderItem()) {

			public ItemStack getStackToRender(EntityArrowCustom entityIn) {
				return new ItemStack(Items.ENDER_PEARL, (int) (1));
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

	public static class EntitymCMOBreskinnedCorruptedSteve extends EntityAnimal implements IRangedAttackMob {

		public EntitymCMOBreskinnedCorruptedSteve(World world) {
			super(world);
			addRandomArmor();
			experienceValue = 29;
			this.isImmuneToFire = true;
			setNoAI(!true);
			this.tasks.addTask(1, new EntityAIWander(this, 3));
			this.tasks.addTask(2, new EntityAILookIdle(this));
			this.tasks.addTask(3, new EntityAISwimming(this));
			this.tasks.addTask(4, new EntityAILeapAtTarget(this, (float) 1.9));
			this.tasks.addTask(5, new EntityAIPanic(this, 3.5));
			this.targetTasks.addTask(6, new EntityAIHurtByTarget(this, true));
			this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
			this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25D, 20, 10.0F));
		}

		@Override
		protected Item getDropItem() {
			return new ItemStack(Items.CHAINMAIL_CHESTPLATE, (int) (1)).getItem();
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testenvironmentmod:corruptedsteve0"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testenvironmentmod:corruptedsteve2"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
					"testenvironmentmod:corrupotedsteve3"));
		}

		@Override
		protected float getSoundVolume() {
			return 1.0F;
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
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.LAVA_BUCKET, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Blocks.BEDROCK, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS, (int) (1)));
			this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS, (int) (1)));
		}

		@Override
		public EntitymCMOBreskinnedCorruptedSteve createChild(EntityAgeable ageable) {
			return new EntitymCMOBreskinnedCorruptedSteve(world);
		}

		@Override
		public float getEyeHeight() {
			return this.isChild() ? this.height : 1.3F;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Items.PRISMARINE_CRYSTALS, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}

		protected void dropRareDrop(int par1) {
			this.dropItem(new ItemStack(Blocks.BEDROCK, (int) (1)).getItem(), 1);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final BossInfoServer bossInfo = (BossInfoServer) (new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED,
				BossInfo.Overlay.NOTCHED_12));

		@Override
		public void addTrackingPlayer(EntityPlayerMP player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(EntityPlayerMP player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

		public void onLivingUpdate() {
			super.onLivingUpdate();
			int i = (int) this.posX;
			int j = (int) this.posY;
			int k = (int) this.posZ;
			Random random = this.rand;
			if (true)
				for (int l = 0; l < 2; ++l) {
					double d0 = (double) ((float) i + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.4000000014901161D * 20;
					double d1 = ((double) ((float) j + 0.7F) + (double) (random.nextFloat() - 0.5F) * 0.4000000014901161D) + 0.5D;
					double d2 = (double) ((float) k + 0.5F) + (double) (random.nextFloat() - 0.5F) * 0.4000000014901161D * 20;
					world.spawnParticle(EnumParticleTypes.SPELL, d0 - 0.27000001072883606D, d1 + 0.2199999988079071D, d2, 0.0D, 0.0D, 0.0D);
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
