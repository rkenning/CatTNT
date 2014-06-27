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

@Mod(modid = CatTNT.modid, version = CatTNT.version)
public class CatTNT {

	public static final String modid = "CatTNT";
	public static final String version = "1.1";
	
	public static Block blockCatTNT;
	
	public static CreativeTabs ryanTab = new CreativeTabs("RyanMods"){
		public Item getTabIconItem() {
			return Items.emerald;
		}		
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		blockCatTNT = new BlockCatTNT().setBlockName("CatTNT").setCreativeTab(ryanTab);
		GameRegistry.registerBlock(blockCatTNT, "CatTNT");
	}
	
	
	@EventHandler
	public void init(FMLInitializationEvent e){
		
	}
	
}

