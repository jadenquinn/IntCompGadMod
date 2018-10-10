package mod.mcreator;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.util.EnumHelper;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.Minecraft;

import java.util.Random;
import java.util.HashMap;

public class mcreator_pinkestarmor {

	public static Object instance;
	public static Item helmet;
	public static Item body;
	public static Item legs;
	public static Item boots;
	static {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("PINKESTARMOR", "9999909999999", 72, new int[]{3, 8, 12, 5}, 32, null,
				9.8999999999999995f);
		helmet = (new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD)).setUnlocalizedName("pinkestarmorhelmet");
		helmet.setMaxStackSize(1);
		body = (new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST) {

			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					mcreator_pinkitemsarmor.executeProcedure($_dependencies);
				}
			}
		}).setUnlocalizedName("pinkestarmorbody");
		body.setMaxStackSize(1);
		legs = (new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS)).setUnlocalizedName("pinkestarmorlegs");
		legs.setMaxStackSize(1);
		boots = (new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET)).setUnlocalizedName("pinkestarmorboots");
		boots.setMaxStackSize(1);
		helmet.setRegistryName("pinkestarmorhelmet");
		ForgeRegistries.ITEMS.register(helmet);
		body.setRegistryName("pinkestarmorbody");
		ForgeRegistries.ITEMS.register(body);
		legs.setRegistryName("pinkestarmorlegs");
		ForgeRegistries.ITEMS.register(legs);
		boots.setRegistryName("pinkestarmorboots");
		ForgeRegistries.ITEMS.register(boots);
	}

	public void load(FMLInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(helmet, 0, new ModelResourceLocation("testenvironmentmod:pinkestarmorhelmet", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(body, 0, new ModelResourceLocation("testenvironmentmod:pinkestarmorbody", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(legs, 0, new ModelResourceLocation("testenvironmentmod:pinkestarmorlegs", "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
					.register(boots, 0, new ModelResourceLocation("testenvironmentmod:pinkestarmorboots", "inventory"));
		}
		helmet.setCreativeTab(mcreator_tab23232.tab);
		body.setCreativeTab(mcreator_tab23232.tab);
		legs.setCreativeTab(mcreator_tab23232.tab);
		boots.setCreativeTab(mcreator_tab23232.tab);
	}

	public void generateNether(World world, Random random, int chunkX, int chunkZ) {
	}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	}

	public void serverLoad(FMLServerStartingEvent event) {
	}

	public void preInit(FMLPreInitializationEvent event) {
	}

	public void registerRenderers() {
	}

	public int addFuel(ItemStack fuel) {
		return 0;
	}
}
