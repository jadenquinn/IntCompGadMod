package mod.mcreator;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.client.model.obj.OBJLoader;

import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Random;

@Mod(modid = testenvironmentmod.MODID, version = testenvironmentmod.VERSION)
public class testenvironmentmod implements IFuelHandler, IWorldGenerator {

	public static final String MODID = "testenvironmentmod";
	public static final String VERSION = "1.0";
	@SidedProxy(clientSide = "mod.mcreator.ClientProxytestenvironmentmod", serverSide = "mod.mcreator.CommonProxytestenvironmentmod")
	public static CommonProxytestenvironmentmod proxy;
	@Instance(MODID)
	public static testenvironmentmod instance;
	mcreator_blocktab0w mcreator_0 = new mcreator_blocktab0w();
	mcreator_scanner mcreator_1 = new mcreator_scanner();
	mcreator_sendtodim109 mcreator_2 = new mcreator_sendtodim109();
	mcreator_sendtodimension0001 mcreator_3 = new mcreator_sendtodimension0001();
	mcreator_mceditnotworkwhy22 mcreator_4 = new mcreator_mceditnotworkwhy22();
	mcreator_tab23232 mcreator_5 = new mcreator_tab23232();
	mcreator_aNOTHERR mcreator_6 = new mcreator_aNOTHERR();
	mcreator_scannerblock1 mcreator_7 = new mcreator_scannerblock1();
	mcreator_compressedBlock100 mcreator_8 = new mcreator_compressedBlock100();
	mcreator_mCMOBreskinnedCorruptedSteve mcreator_9 = new mcreator_mCMOBreskinnedCorruptedSteve();
	mcreator_diamondGiver1 mcreator_10 = new mcreator_diamondGiver1();
	mcreator_greenCrystallitedropitem mcreator_11 = new mcreator_greenCrystallitedropitem();
	mcreator_maskedsFavOre1 mcreator_12 = new mcreator_maskedsFavOre1();
	mcreator_rightClickMaskedEvent2 mcreator_13 = new mcreator_rightClickMaskedEvent2();
	mcreator_batteryBlkx1001 mcreator_14 = new mcreator_batteryBlkx1001();
	mcreator_thirstoverlooy1001 mcreator_15 = new mcreator_thirstoverlooy1001();
	mcreator_misterrredstonesstoneblock mcreator_16 = new mcreator_misterrredstonesstoneblock();
	mcreator_xDBIOMEleaves0 mcreator_17 = new mcreator_xDBIOMEleaves0();
	mcreator_dropBlockdiamond mcreator_18 = new mcreator_dropBlockdiamond();
	mcreator_dropBlockdiamond0 mcreator_19 = new mcreator_dropBlockdiamond0();
	mcreator_struct0 mcreator_20 = new mcreator_struct0();
	mcreator_dropBlockdiamond1 mcreator_21 = new mcreator_dropBlockdiamond1();
	mcreator_creativeTabfluids mcreator_22 = new mcreator_creativeTabfluids();
	mcreator_newPotionEffectpot1 mcreator_23 = new mcreator_newPotionEffectpot1();
	mcreator_potionsByJa mcreator_24 = new mcreator_potionsByJa();
	mcreator_intillectualPotionCore mcreator_25 = new mcreator_intillectualPotionCore();
	mcreator_fluidCalledPortal1122 mcreator_26 = new mcreator_fluidCalledPortal1122();
	mcreator_doesn6tma55er mcreator_27 = new mcreator_doesn6tma55er();
	mcreator_item0 mcreator_28 = new mcreator_item0();
	mcreator_pinkitemsarmor mcreator_29 = new mcreator_pinkitemsarmor();
	mcreator_pinkestarmor mcreator_30 = new mcreator_pinkestarmor();
	mcreator_giveallarmor00 mcreator_31 = new mcreator_giveallarmor00();
	mcreator_command11436564retrefe mcreator_32 = new mcreator_command11436564retrefe();
	mcreator_jadenTems090 mcreator_33 = new mcreator_jadenTems090();
	mcreator_achievement222 mcreator_34 = new mcreator_achievement222();
	mcreator_protectionImbuingChuteN mcreator_35 = new mcreator_protectionImbuingChuteN();
	mcreator_protectionImbuingChuteE mcreator_36 = new mcreator_protectionImbuingChuteE();
	mcreator_applyEnchantments00 mcreator_37 = new mcreator_applyEnchantments00();
	mcreator_catalystsItems mcreator_38 = new mcreator_catalystsItems();
	mcreator_theCrapper0 mcreator_39 = new mcreator_theCrapper0();
	mcreator_fromgoldtodiass mcreator_40 = new mcreator_fromgoldtodiass();
	mcreator_oreIngot mcreator_41 = new mcreator_oreIngot();
	mcreator_tabForIngots mcreator_42 = new mcreator_tabForIngots();
	mcreator_tabForGems mcreator_43 = new mcreator_tabForGems();
	mcreator_extraCoal mcreator_44 = new mcreator_extraCoal();
	mcreator_fossilFuels mcreator_45 = new mcreator_fossilFuels();
	mcreator_extraCoalE mcreator_46 = new mcreator_extraCoalE();
	mcreator_fossilFuel mcreator_47 = new mcreator_fossilFuel();
	mcreator_fossilFuel0 mcreator_48 = new mcreator_fossilFuel0();
	mcreator_dimensionss mcreator_49 = new mcreator_dimensionss();
	mcreator_coalNugget0 mcreator_50 = new mcreator_coalNugget0();
	mcreator_cakCoalNuggetRecipeImplimentation mcreator_51 = new mcreator_cakCoalNuggetRecipeImplimentation();
	mcreator_ligniteOreP mcreator_52 = new mcreator_ligniteOreP();
	mcreator_smeltsble00 mcreator_53 = new mcreator_smeltsble00();
	mcreator_fuel2 mcreator_54 = new mcreator_fuel2();
	mcreator_diamondEncrustedSquidicite mcreator_55 = new mcreator_diamondEncrustedSquidicite();
	mcreator_squidicite0 mcreator_56 = new mcreator_squidicite0();
	mcreator_darkDiamondEncrustedSquidicite mcreator_57 = new mcreator_darkDiamondEncrustedSquidicite();
	mcreator_craftablefireCraftId mcreator_58 = new mcreator_craftablefireCraftId();
	mcreator_craftingplant1112 mcreator_59 = new mcreator_craftingplant1112();
	mcreator_craftablefire1 mcreator_60 = new mcreator_craftablefire1();
	mcreator_altemerald mcreator_61 = new mcreator_altemerald();
	mcreator_altemeraldDark mcreator_62 = new mcreator_altemeraldDark();
	mcreator_darkSquidicite mcreator_63 = new mcreator_darkSquidicite();
	mcreator_biomedcide mcreator_64 = new mcreator_biomedcide();
	mcreator_bucketblockdimm mcreator_65 = new mcreator_bucketblockdimm();
	mcreator_potionhealing00 mcreator_66 = new mcreator_potionhealing00();
	mcreator_potionPLANThealingg mcreator_67 = new mcreator_potionPLANThealingg();
	mcreator_fillblockk mcreator_68 = new mcreator_fillblockk();
	mcreator_bonerecc mcreator_69 = new mcreator_bonerecc();
	mcreator_sugarCanetostickyy mcreator_70 = new mcreator_sugarCanetostickyy();
	mcreator_guicrappy mcreator_71 = new mcreator_guicrappy();
	mcreator_playydoundd mcreator_72 = new mcreator_playydoundd();
	mcreator_allOurNewStuff mcreator_73 = new mcreator_allOurNewStuff();
	mcreator_paxels1 mcreator_74 = new mcreator_paxels1();
	mcreator_rawPaxelmats mcreator_75 = new mcreator_rawPaxelmats();
	mcreator_potioneffectintensehealing1 mcreator_76 = new mcreator_potioneffectintensehealing1();
	mcreator_cacclitegem111 mcreator_77 = new mcreator_cacclitegem111();
	mcreator_dark1cacclitegem1 mcreator_78 = new mcreator_dark1cacclitegem1();
	mcreator_caccliteOre0 mcreator_79 = new mcreator_caccliteOre0();
	mcreator_caccliteOre0smeltrecipe mcreator_80 = new mcreator_caccliteOre0smeltrecipe();
	mcreator_thingybat mcreator_81 = new mcreator_thingybat();
	mcreator_endermanitystage1 mcreator_82 = new mcreator_endermanitystage1();
	mcreator_dirtblock0 mcreator_83 = new mcreator_dirtblock0();
	mcreator_dirtblock1 mcreator_84 = new mcreator_dirtblock1();

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (mcreator_0.addFuel(fuel) != 0)
			return mcreator_0.addFuel(fuel);
		if (mcreator_1.addFuel(fuel) != 0)
			return mcreator_1.addFuel(fuel);
		if (mcreator_2.addFuel(fuel) != 0)
			return mcreator_2.addFuel(fuel);
		if (mcreator_3.addFuel(fuel) != 0)
			return mcreator_3.addFuel(fuel);
		if (mcreator_4.addFuel(fuel) != 0)
			return mcreator_4.addFuel(fuel);
		if (mcreator_5.addFuel(fuel) != 0)
			return mcreator_5.addFuel(fuel);
		if (mcreator_6.addFuel(fuel) != 0)
			return mcreator_6.addFuel(fuel);
		if (mcreator_7.addFuel(fuel) != 0)
			return mcreator_7.addFuel(fuel);
		if (mcreator_8.addFuel(fuel) != 0)
			return mcreator_8.addFuel(fuel);
		if (mcreator_9.addFuel(fuel) != 0)
			return mcreator_9.addFuel(fuel);
		if (mcreator_10.addFuel(fuel) != 0)
			return mcreator_10.addFuel(fuel);
		if (mcreator_11.addFuel(fuel) != 0)
			return mcreator_11.addFuel(fuel);
		if (mcreator_12.addFuel(fuel) != 0)
			return mcreator_12.addFuel(fuel);
		if (mcreator_13.addFuel(fuel) != 0)
			return mcreator_13.addFuel(fuel);
		if (mcreator_14.addFuel(fuel) != 0)
			return mcreator_14.addFuel(fuel);
		if (mcreator_15.addFuel(fuel) != 0)
			return mcreator_15.addFuel(fuel);
		if (mcreator_16.addFuel(fuel) != 0)
			return mcreator_16.addFuel(fuel);
		if (mcreator_17.addFuel(fuel) != 0)
			return mcreator_17.addFuel(fuel);
		if (mcreator_18.addFuel(fuel) != 0)
			return mcreator_18.addFuel(fuel);
		if (mcreator_19.addFuel(fuel) != 0)
			return mcreator_19.addFuel(fuel);
		if (mcreator_20.addFuel(fuel) != 0)
			return mcreator_20.addFuel(fuel);
		if (mcreator_21.addFuel(fuel) != 0)
			return mcreator_21.addFuel(fuel);
		if (mcreator_22.addFuel(fuel) != 0)
			return mcreator_22.addFuel(fuel);
		if (mcreator_23.addFuel(fuel) != 0)
			return mcreator_23.addFuel(fuel);
		if (mcreator_24.addFuel(fuel) != 0)
			return mcreator_24.addFuel(fuel);
		if (mcreator_25.addFuel(fuel) != 0)
			return mcreator_25.addFuel(fuel);
		if (mcreator_26.addFuel(fuel) != 0)
			return mcreator_26.addFuel(fuel);
		if (mcreator_27.addFuel(fuel) != 0)
			return mcreator_27.addFuel(fuel);
		if (mcreator_28.addFuel(fuel) != 0)
			return mcreator_28.addFuel(fuel);
		if (mcreator_29.addFuel(fuel) != 0)
			return mcreator_29.addFuel(fuel);
		if (mcreator_30.addFuel(fuel) != 0)
			return mcreator_30.addFuel(fuel);
		if (mcreator_31.addFuel(fuel) != 0)
			return mcreator_31.addFuel(fuel);
		if (mcreator_32.addFuel(fuel) != 0)
			return mcreator_32.addFuel(fuel);
		if (mcreator_33.addFuel(fuel) != 0)
			return mcreator_33.addFuel(fuel);
		if (mcreator_34.addFuel(fuel) != 0)
			return mcreator_34.addFuel(fuel);
		if (mcreator_35.addFuel(fuel) != 0)
			return mcreator_35.addFuel(fuel);
		if (mcreator_36.addFuel(fuel) != 0)
			return mcreator_36.addFuel(fuel);
		if (mcreator_37.addFuel(fuel) != 0)
			return mcreator_37.addFuel(fuel);
		if (mcreator_38.addFuel(fuel) != 0)
			return mcreator_38.addFuel(fuel);
		if (mcreator_39.addFuel(fuel) != 0)
			return mcreator_39.addFuel(fuel);
		if (mcreator_40.addFuel(fuel) != 0)
			return mcreator_40.addFuel(fuel);
		if (mcreator_41.addFuel(fuel) != 0)
			return mcreator_41.addFuel(fuel);
		if (mcreator_42.addFuel(fuel) != 0)
			return mcreator_42.addFuel(fuel);
		if (mcreator_43.addFuel(fuel) != 0)
			return mcreator_43.addFuel(fuel);
		if (mcreator_44.addFuel(fuel) != 0)
			return mcreator_44.addFuel(fuel);
		if (mcreator_45.addFuel(fuel) != 0)
			return mcreator_45.addFuel(fuel);
		if (mcreator_46.addFuel(fuel) != 0)
			return mcreator_46.addFuel(fuel);
		if (mcreator_47.addFuel(fuel) != 0)
			return mcreator_47.addFuel(fuel);
		if (mcreator_48.addFuel(fuel) != 0)
			return mcreator_48.addFuel(fuel);
		if (mcreator_49.addFuel(fuel) != 0)
			return mcreator_49.addFuel(fuel);
		if (mcreator_50.addFuel(fuel) != 0)
			return mcreator_50.addFuel(fuel);
		if (mcreator_51.addFuel(fuel) != 0)
			return mcreator_51.addFuel(fuel);
		if (mcreator_52.addFuel(fuel) != 0)
			return mcreator_52.addFuel(fuel);
		if (mcreator_53.addFuel(fuel) != 0)
			return mcreator_53.addFuel(fuel);
		if (mcreator_54.addFuel(fuel) != 0)
			return mcreator_54.addFuel(fuel);
		if (mcreator_55.addFuel(fuel) != 0)
			return mcreator_55.addFuel(fuel);
		if (mcreator_56.addFuel(fuel) != 0)
			return mcreator_56.addFuel(fuel);
		if (mcreator_57.addFuel(fuel) != 0)
			return mcreator_57.addFuel(fuel);
		if (mcreator_58.addFuel(fuel) != 0)
			return mcreator_58.addFuel(fuel);
		if (mcreator_59.addFuel(fuel) != 0)
			return mcreator_59.addFuel(fuel);
		if (mcreator_60.addFuel(fuel) != 0)
			return mcreator_60.addFuel(fuel);
		if (mcreator_61.addFuel(fuel) != 0)
			return mcreator_61.addFuel(fuel);
		if (mcreator_62.addFuel(fuel) != 0)
			return mcreator_62.addFuel(fuel);
		if (mcreator_63.addFuel(fuel) != 0)
			return mcreator_63.addFuel(fuel);
		if (mcreator_64.addFuel(fuel) != 0)
			return mcreator_64.addFuel(fuel);
		if (mcreator_65.addFuel(fuel) != 0)
			return mcreator_65.addFuel(fuel);
		if (mcreator_66.addFuel(fuel) != 0)
			return mcreator_66.addFuel(fuel);
		if (mcreator_67.addFuel(fuel) != 0)
			return mcreator_67.addFuel(fuel);
		if (mcreator_68.addFuel(fuel) != 0)
			return mcreator_68.addFuel(fuel);
		if (mcreator_69.addFuel(fuel) != 0)
			return mcreator_69.addFuel(fuel);
		if (mcreator_70.addFuel(fuel) != 0)
			return mcreator_70.addFuel(fuel);
		if (mcreator_71.addFuel(fuel) != 0)
			return mcreator_71.addFuel(fuel);
		if (mcreator_72.addFuel(fuel) != 0)
			return mcreator_72.addFuel(fuel);
		if (mcreator_73.addFuel(fuel) != 0)
			return mcreator_73.addFuel(fuel);
		if (mcreator_74.addFuel(fuel) != 0)
			return mcreator_74.addFuel(fuel);
		if (mcreator_75.addFuel(fuel) != 0)
			return mcreator_75.addFuel(fuel);
		if (mcreator_76.addFuel(fuel) != 0)
			return mcreator_76.addFuel(fuel);
		if (mcreator_77.addFuel(fuel) != 0)
			return mcreator_77.addFuel(fuel);
		if (mcreator_78.addFuel(fuel) != 0)
			return mcreator_78.addFuel(fuel);
		if (mcreator_79.addFuel(fuel) != 0)
			return mcreator_79.addFuel(fuel);
		if (mcreator_80.addFuel(fuel) != 0)
			return mcreator_80.addFuel(fuel);
		if (mcreator_81.addFuel(fuel) != 0)
			return mcreator_81.addFuel(fuel);
		if (mcreator_82.addFuel(fuel) != 0)
			return mcreator_82.addFuel(fuel);
		if (mcreator_83.addFuel(fuel) != 0)
			return mcreator_83.addFuel(fuel);
		if (mcreator_84.addFuel(fuel) != 0)
			return mcreator_84.addFuel(fuel);
		return 0;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		chunkX = chunkX * 16;
		chunkZ = chunkZ * 16;
		if (world.provider.getDimension() == -1)
			mcreator_0.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_0.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_1.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_1.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_2.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_2.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_3.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_3.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_4.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_4.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_5.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_5.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_6.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_6.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_7.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_7.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_8.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_8.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_9.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_9.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_10.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_10.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_11.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_11.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_12.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_12.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_13.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_13.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_14.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_14.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_15.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_15.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_16.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_16.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_17.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_17.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_18.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_18.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_19.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_19.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_20.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_20.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_21.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_21.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_22.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_22.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_23.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_23.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_24.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_24.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_25.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_25.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_26.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_26.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_27.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_27.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_28.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_28.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_29.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_29.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_30.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_30.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_31.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_31.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_32.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_32.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_33.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_33.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_34.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_34.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_35.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_35.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_36.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_36.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_37.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_37.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_38.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_38.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_39.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_39.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_40.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_40.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_41.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_41.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_42.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_42.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_43.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_43.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_44.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_44.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_45.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_45.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_46.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_46.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_47.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_47.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_48.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_48.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_49.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_49.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_50.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_50.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_51.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_51.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_52.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_52.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_53.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_53.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_54.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_54.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_55.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_55.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_56.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_56.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_57.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_57.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_58.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_58.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_59.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_59.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_60.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_60.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_61.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_61.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_62.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_62.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_63.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_63.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_64.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_64.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_65.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_65.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_66.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_66.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_67.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_67.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_68.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_68.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_69.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_69.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_70.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_70.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_71.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_71.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_72.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_72.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_73.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_73.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_74.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_74.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_75.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_75.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_76.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_76.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_77.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_77.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_78.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_78.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_79.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_79.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_80.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_80.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_81.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_81.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_82.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_82.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_83.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_83.generateSurface(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == -1)
			mcreator_84.generateNether(world, random, chunkX, chunkZ);
		if (world.provider.getDimension() == 0)
			mcreator_84.generateSurface(world, random, chunkX, chunkZ);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		GameRegistry.registerFuelHandler(this);
		GameRegistry.registerWorldGenerator(this, 5);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		mcreator_0.load(event);
		mcreator_1.load(event);
		mcreator_2.load(event);
		mcreator_3.load(event);
		mcreator_4.load(event);
		mcreator_5.load(event);
		mcreator_6.load(event);
		mcreator_7.load(event);
		mcreator_8.load(event);
		mcreator_9.load(event);
		mcreator_10.load(event);
		mcreator_11.load(event);
		mcreator_12.load(event);
		mcreator_13.load(event);
		mcreator_14.load(event);
		mcreator_15.load(event);
		mcreator_16.load(event);
		mcreator_17.load(event);
		mcreator_18.load(event);
		mcreator_19.load(event);
		mcreator_20.load(event);
		mcreator_21.load(event);
		mcreator_22.load(event);
		mcreator_23.load(event);
		mcreator_24.load(event);
		mcreator_25.load(event);
		mcreator_26.load(event);
		mcreator_27.load(event);
		mcreator_28.load(event);
		mcreator_29.load(event);
		mcreator_30.load(event);
		mcreator_31.load(event);
		mcreator_32.load(event);
		mcreator_33.load(event);
		mcreator_34.load(event);
		mcreator_35.load(event);
		mcreator_36.load(event);
		mcreator_37.load(event);
		mcreator_38.load(event);
		mcreator_39.load(event);
		mcreator_40.load(event);
		mcreator_41.load(event);
		mcreator_42.load(event);
		mcreator_43.load(event);
		mcreator_44.load(event);
		mcreator_45.load(event);
		mcreator_46.load(event);
		mcreator_47.load(event);
		mcreator_48.load(event);
		mcreator_49.load(event);
		mcreator_50.load(event);
		mcreator_51.load(event);
		mcreator_52.load(event);
		mcreator_53.load(event);
		mcreator_54.load(event);
		mcreator_55.load(event);
		mcreator_56.load(event);
		mcreator_57.load(event);
		mcreator_58.load(event);
		mcreator_59.load(event);
		mcreator_60.load(event);
		mcreator_61.load(event);
		mcreator_62.load(event);
		mcreator_63.load(event);
		mcreator_64.load(event);
		mcreator_65.load(event);
		mcreator_66.load(event);
		mcreator_67.load(event);
		mcreator_68.load(event);
		mcreator_69.load(event);
		mcreator_70.load(event);
		mcreator_71.load(event);
		mcreator_72.load(event);
		mcreator_73.load(event);
		mcreator_74.load(event);
		mcreator_75.load(event);
		mcreator_76.load(event);
		mcreator_77.load(event);
		mcreator_78.load(event);
		mcreator_79.load(event);
		mcreator_80.load(event);
		mcreator_81.load(event);
		mcreator_82.load(event);
		mcreator_83.load(event);
		mcreator_84.load(event);
		proxy.registerRenderers(this);
	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event) {
		mcreator_0.serverLoad(event);
		mcreator_1.serverLoad(event);
		mcreator_2.serverLoad(event);
		mcreator_3.serverLoad(event);
		mcreator_4.serverLoad(event);
		mcreator_5.serverLoad(event);
		mcreator_6.serverLoad(event);
		mcreator_7.serverLoad(event);
		mcreator_8.serverLoad(event);
		mcreator_9.serverLoad(event);
		mcreator_10.serverLoad(event);
		mcreator_11.serverLoad(event);
		mcreator_12.serverLoad(event);
		mcreator_13.serverLoad(event);
		mcreator_14.serverLoad(event);
		mcreator_15.serverLoad(event);
		mcreator_16.serverLoad(event);
		mcreator_17.serverLoad(event);
		mcreator_18.serverLoad(event);
		mcreator_19.serverLoad(event);
		mcreator_20.serverLoad(event);
		mcreator_21.serverLoad(event);
		mcreator_22.serverLoad(event);
		mcreator_23.serverLoad(event);
		mcreator_24.serverLoad(event);
		mcreator_25.serverLoad(event);
		mcreator_26.serverLoad(event);
		mcreator_27.serverLoad(event);
		mcreator_28.serverLoad(event);
		mcreator_29.serverLoad(event);
		mcreator_30.serverLoad(event);
		mcreator_31.serverLoad(event);
		mcreator_32.serverLoad(event);
		mcreator_33.serverLoad(event);
		mcreator_34.serverLoad(event);
		mcreator_35.serverLoad(event);
		mcreator_36.serverLoad(event);
		mcreator_37.serverLoad(event);
		mcreator_38.serverLoad(event);
		mcreator_39.serverLoad(event);
		mcreator_40.serverLoad(event);
		mcreator_41.serverLoad(event);
		mcreator_42.serverLoad(event);
		mcreator_43.serverLoad(event);
		mcreator_44.serverLoad(event);
		mcreator_45.serverLoad(event);
		mcreator_46.serverLoad(event);
		mcreator_47.serverLoad(event);
		mcreator_48.serverLoad(event);
		mcreator_49.serverLoad(event);
		mcreator_50.serverLoad(event);
		mcreator_51.serverLoad(event);
		mcreator_52.serverLoad(event);
		mcreator_53.serverLoad(event);
		mcreator_54.serverLoad(event);
		mcreator_55.serverLoad(event);
		mcreator_56.serverLoad(event);
		mcreator_57.serverLoad(event);
		mcreator_58.serverLoad(event);
		mcreator_59.serverLoad(event);
		mcreator_60.serverLoad(event);
		mcreator_61.serverLoad(event);
		mcreator_62.serverLoad(event);
		mcreator_63.serverLoad(event);
		mcreator_64.serverLoad(event);
		mcreator_65.serverLoad(event);
		mcreator_66.serverLoad(event);
		mcreator_67.serverLoad(event);
		mcreator_68.serverLoad(event);
		mcreator_69.serverLoad(event);
		mcreator_70.serverLoad(event);
		mcreator_71.serverLoad(event);
		mcreator_72.serverLoad(event);
		mcreator_73.serverLoad(event);
		mcreator_74.serverLoad(event);
		mcreator_75.serverLoad(event);
		mcreator_76.serverLoad(event);
		mcreator_77.serverLoad(event);
		mcreator_78.serverLoad(event);
		mcreator_79.serverLoad(event);
		mcreator_80.serverLoad(event);
		mcreator_81.serverLoad(event);
		mcreator_82.serverLoad(event);
		mcreator_83.serverLoad(event);
		mcreator_84.serverLoad(event);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		if (event.getSide() == Side.CLIENT) {
			OBJLoader.INSTANCE.addDomain("testenvironmentmod");
		}
		mcreator_0.instance = this.instance;
		mcreator_0.preInit(event);
		mcreator_1.instance = this.instance;
		mcreator_1.preInit(event);
		mcreator_2.instance = this.instance;
		mcreator_2.preInit(event);
		mcreator_3.instance = this.instance;
		mcreator_3.preInit(event);
		mcreator_4.instance = this.instance;
		mcreator_4.preInit(event);
		mcreator_5.instance = this.instance;
		mcreator_5.preInit(event);
		mcreator_6.instance = this.instance;
		mcreator_6.preInit(event);
		mcreator_7.instance = this.instance;
		mcreator_7.preInit(event);
		mcreator_8.instance = this.instance;
		mcreator_8.preInit(event);
		mcreator_9.instance = this.instance;
		mcreator_9.preInit(event);
		mcreator_10.instance = this.instance;
		mcreator_10.preInit(event);
		mcreator_11.instance = this.instance;
		mcreator_11.preInit(event);
		mcreator_12.instance = this.instance;
		mcreator_12.preInit(event);
		mcreator_13.instance = this.instance;
		mcreator_13.preInit(event);
		mcreator_14.instance = this.instance;
		mcreator_14.preInit(event);
		mcreator_15.instance = this.instance;
		mcreator_15.preInit(event);
		mcreator_16.instance = this.instance;
		mcreator_16.preInit(event);
		mcreator_17.instance = this.instance;
		mcreator_17.preInit(event);
		mcreator_18.instance = this.instance;
		mcreator_18.preInit(event);
		mcreator_19.instance = this.instance;
		mcreator_19.preInit(event);
		mcreator_20.instance = this.instance;
		mcreator_20.preInit(event);
		mcreator_21.instance = this.instance;
		mcreator_21.preInit(event);
		mcreator_22.instance = this.instance;
		mcreator_22.preInit(event);
		mcreator_23.instance = this.instance;
		mcreator_23.preInit(event);
		mcreator_24.instance = this.instance;
		mcreator_24.preInit(event);
		mcreator_25.instance = this.instance;
		mcreator_25.preInit(event);
		mcreator_26.instance = this.instance;
		mcreator_26.preInit(event);
		mcreator_27.instance = this.instance;
		mcreator_27.preInit(event);
		mcreator_28.instance = this.instance;
		mcreator_28.preInit(event);
		mcreator_29.instance = this.instance;
		mcreator_29.preInit(event);
		mcreator_30.instance = this.instance;
		mcreator_30.preInit(event);
		mcreator_31.instance = this.instance;
		mcreator_31.preInit(event);
		mcreator_32.instance = this.instance;
		mcreator_32.preInit(event);
		mcreator_33.instance = this.instance;
		mcreator_33.preInit(event);
		mcreator_34.instance = this.instance;
		mcreator_34.preInit(event);
		mcreator_35.instance = this.instance;
		mcreator_35.preInit(event);
		mcreator_36.instance = this.instance;
		mcreator_36.preInit(event);
		mcreator_37.instance = this.instance;
		mcreator_37.preInit(event);
		mcreator_38.instance = this.instance;
		mcreator_38.preInit(event);
		mcreator_39.instance = this.instance;
		mcreator_39.preInit(event);
		mcreator_40.instance = this.instance;
		mcreator_40.preInit(event);
		mcreator_41.instance = this.instance;
		mcreator_41.preInit(event);
		mcreator_42.instance = this.instance;
		mcreator_42.preInit(event);
		mcreator_43.instance = this.instance;
		mcreator_43.preInit(event);
		mcreator_44.instance = this.instance;
		mcreator_44.preInit(event);
		mcreator_45.instance = this.instance;
		mcreator_45.preInit(event);
		mcreator_46.instance = this.instance;
		mcreator_46.preInit(event);
		mcreator_47.instance = this.instance;
		mcreator_47.preInit(event);
		mcreator_48.instance = this.instance;
		mcreator_48.preInit(event);
		mcreator_49.instance = this.instance;
		mcreator_49.preInit(event);
		mcreator_50.instance = this.instance;
		mcreator_50.preInit(event);
		mcreator_51.instance = this.instance;
		mcreator_51.preInit(event);
		mcreator_52.instance = this.instance;
		mcreator_52.preInit(event);
		mcreator_53.instance = this.instance;
		mcreator_53.preInit(event);
		mcreator_54.instance = this.instance;
		mcreator_54.preInit(event);
		mcreator_55.instance = this.instance;
		mcreator_55.preInit(event);
		mcreator_56.instance = this.instance;
		mcreator_56.preInit(event);
		mcreator_57.instance = this.instance;
		mcreator_57.preInit(event);
		mcreator_58.instance = this.instance;
		mcreator_58.preInit(event);
		mcreator_59.instance = this.instance;
		mcreator_59.preInit(event);
		mcreator_60.instance = this.instance;
		mcreator_60.preInit(event);
		mcreator_61.instance = this.instance;
		mcreator_61.preInit(event);
		mcreator_62.instance = this.instance;
		mcreator_62.preInit(event);
		mcreator_63.instance = this.instance;
		mcreator_63.preInit(event);
		mcreator_64.instance = this.instance;
		mcreator_64.preInit(event);
		mcreator_65.instance = this.instance;
		mcreator_65.preInit(event);
		mcreator_66.instance = this.instance;
		mcreator_66.preInit(event);
		mcreator_67.instance = this.instance;
		mcreator_67.preInit(event);
		mcreator_68.instance = this.instance;
		mcreator_68.preInit(event);
		mcreator_69.instance = this.instance;
		mcreator_69.preInit(event);
		mcreator_70.instance = this.instance;
		mcreator_70.preInit(event);
		mcreator_71.instance = this.instance;
		mcreator_71.preInit(event);
		mcreator_72.instance = this.instance;
		mcreator_72.preInit(event);
		mcreator_73.instance = this.instance;
		mcreator_73.preInit(event);
		mcreator_74.instance = this.instance;
		mcreator_74.preInit(event);
		mcreator_75.instance = this.instance;
		mcreator_75.preInit(event);
		mcreator_76.instance = this.instance;
		mcreator_76.preInit(event);
		mcreator_77.instance = this.instance;
		mcreator_77.preInit(event);
		mcreator_78.instance = this.instance;
		mcreator_78.preInit(event);
		mcreator_79.instance = this.instance;
		mcreator_79.preInit(event);
		mcreator_80.instance = this.instance;
		mcreator_80.preInit(event);
		mcreator_81.instance = this.instance;
		mcreator_81.preInit(event);
		mcreator_82.instance = this.instance;
		mcreator_82.preInit(event);
		mcreator_83.instance = this.instance;
		mcreator_83.preInit(event);
		mcreator_84.instance = this.instance;
		mcreator_84.preInit(event);
		ResourceLocation sound0 = new ResourceLocation("testenvironmentmod", "cave13");
		ForgeRegistries.SOUND_EVENTS.register(new net.minecraft.util.SoundEvent(sound0).setRegistryName(sound0));
		ResourceLocation sound1 = new ResourceLocation("testenvironmentmod", "corruptedsteve0");
		ForgeRegistries.SOUND_EVENTS.register(new net.minecraft.util.SoundEvent(sound1).setRegistryName(sound1));
		ResourceLocation sound2 = new ResourceLocation("testenvironmentmod", "corruptedsteve1");
		ForgeRegistries.SOUND_EVENTS.register(new net.minecraft.util.SoundEvent(sound2).setRegistryName(sound2));
		ResourceLocation sound3 = new ResourceLocation("testenvironmentmod", "corruptedsteve2");
		ForgeRegistries.SOUND_EVENTS.register(new net.minecraft.util.SoundEvent(sound3).setRegistryName(sound3));
		ResourceLocation sound4 = new ResourceLocation("testenvironmentmod", "corrupotedsteve3");
		ForgeRegistries.SOUND_EVENTS.register(new net.minecraft.util.SoundEvent(sound4).setRegistryName(sound4));
		ResourceLocation sound5 = new ResourceLocation("testenvironmentmod", "corruptedsteve4");
		ForgeRegistries.SOUND_EVENTS.register(new net.minecraft.util.SoundEvent(sound5).setRegistryName(sound5));
	}

	public static class GuiHandler implements IGuiHandler {

		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == mcreator_guicrappy.GUIID)
				return new mcreator_guicrappy.GuiContainerMod(world, x, y, z, player);
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
			if (id == mcreator_guicrappy.GUIID)
				return new mcreator_guicrappy.GuiWindow(world, x, y, z, player);
			return null;
		}
	}
}
