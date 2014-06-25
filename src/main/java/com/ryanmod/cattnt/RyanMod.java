
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

@Mod(modid = RyanMod.modid, version = RyanMod.version)
public class RyanMod {

	public static final String modid = "RyanMod";
	public static final String version = "1.1";
	
	public static Block catTNT;
	
	public static CreativeTabs scratchTab = new CreativeTabs("scratchforfunTab"){
		public Item getTabIconItem() {
			return Items.emerald;
		}		
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		catTNT = new CatTNT().setBlockName("blockRed").setCreativeTab(scratchTab);
		GameRegistry.registerBlock(catTNT, "blockRed");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e){
		
	}
	
}
