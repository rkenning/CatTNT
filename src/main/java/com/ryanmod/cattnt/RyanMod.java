package com.ryanmod.cattnt;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = RyanMod.MODID, version = RyanMod.VERSION)
public class RyanMod {
	public static final String MODID = "RyanMod";
	public static final String VERSION = "1.1";

	@EventHandler
	public void init(FMLInitializationEvent event) {
		// some example code
		//System.out.println("DIRT BLOCK >> " + Blocks.dirt.getUnlocalizedName());
	}
}
