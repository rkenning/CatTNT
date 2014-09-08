package com.ryanmod.cattnt;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid = CatTNT.modid, version = CatTNT.version)
public class CatTNT {

	public static final String modid = "ryanmod";
	public static final String version = "1.1";
	
	public static Block blockCatTNT;
	
	public static CreativeTabs ryanTab = new CreativeTabs("RyanMods"){
		public Item getTabIconItem() {
			return Items.beef;
		}		
	};
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e){
		blockCatTNT = new BlockCatTNT().setBlockName("CatTNT").setCreativeTab(ryanTab).setBlockTextureName(modid+ ":" + "cat_tnt_side");
		
		GameRegistry.registerBlock(blockCatTNT, "CatTNT");
	}
	
	  @Mod.EventHandler
	  public void init(FMLInitializationEvent event) {
	    loadRecipes();
	    loadRenderers();
	  }

	  public void loadRecipes() {
	    GameRegistry.addRecipe(new ItemStack(blockCatTNT, 1), new Object[] { "X#X", "#X#", "X#X", Character.valueOf('X'), Items.gunpowder, Character.valueOf('#'), Blocks.red_flower });
  }

	  public void loadRenderers() {
	    EntityRegistry.registerModEntity(EntityPlantTNTPrimed.class, "plantTntPrimed", 1, this, 80, 3, true);
	    if (FMLCommonHandler.instance().getSide().isClient())
	      RenderingRegistry.registerEntityRenderingHandler(EntityPlantTNTPrimed.class, new RenderPlantTNTPrimed());
	  }
	}
	
}

