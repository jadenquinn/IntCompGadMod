package mod.mcreator;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.Minecraft;

import java.util.Random;

public class mcreator_thirstoverlooy1001 {

	public static Object instance;

	public void load(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new GUIRenderEventClass());
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

	public static class GUIRenderEventClass {

		@SubscribeEvent(priority = EventPriority.LOW)
		public void eventHandler(RenderGameOverlayEvent event) {
			if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
				int posX = (event.getResolution().getScaledWidth()) / 2;
				int posY = (event.getResolution().getScaledHeight()) / 2;
				EntityPlayer entitySP = Minecraft.getMinecraft().player;
				MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
				World world = server.getWorld(entitySP.dimension);
				EntityPlayer entity = entitySP;
				for (EntityPlayer entityMP : world.playerEntities)
					if (entityMP.getName().equals(entitySP.getName()))
						entity = entityMP;
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				if ((world.isThundering())) {
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("34ygtgt4_boots.png"));
					Minecraft.getMinecraft().ingameGUI.drawTexturedModalRect(posX + -128, posY + 111, 0, 0, 256, 256);
					Minecraft.getMinecraft().fontRenderer.drawString("BootyFace Limit 100-1", posX + -197, posY + 93, -16737895);
				}
			}
		}
	}
}
