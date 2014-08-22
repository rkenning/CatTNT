package com.ryanmod.cattnt;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;









import java.math.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


	public class ModEntityTNTPrimed extends EntityTNTPrimed {

		
	   
		public ModEntityTNTPrimed(World par1World) {
	        super(par1World);
	        this.preventEntitySpawning = true;
	        this.setSize(0.98F, 0.98F);
	        this.yOffset = this.height / 2.0F;
		}
		
	   
	    public ModEntityTNTPrimed(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase)
	    {
	        this(par1World);
	        this.setPosition(par2, par4, par6);
	        float f = (float)(Math.random() * Math.PI * 2.0D);
	        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
	        this.motionY = 0.20000000298023224D;
	        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
	        this.fuse = 80;
	        this.prevPosX = par2;
	        this.prevPosY = par4;
	        this.prevPosZ = par6;
	        this.tntPlacedBy = par8EntityLivingBase;
	    }
		
		
		private void explode()
	    {
	        //float f = 224.0F;
	        float f = 8F;
	        //this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
	        
	        // Playing with Fireworks -- Not quite working yet!
	        //NBTTagCompound NBTTagCompound = null;
			//this.worldObj.makeFireworks(1,  this.posX, this.posY, this.posZ, 100, 100, NBTTagCompound);
	        
	        EntityOcelot entityocelot;
	        double volX = 0;
	        double volY = 0;
	        double volZ = 0;
	        
	        
	        String[] userList;
	        userList =  MinecraftServer.getServer().getConfigurationManager().getAllUsernames();
	        //EntityPlayer player =  MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(userList[0]);
	     
	      
	 
	        
	        
	        for (int i=1; i<21; i=i+1)
	        {
	        	entityocelot = new EntityOcelot(this.worldObj);
	        
	        
	        	
	        	volX = (double)(Math.random())*2; 
	        	volY = (double)(Math.random())*3;
	        	volZ = (double)(Math.random())*2;
	        	
	        	
	        	
	        	entityocelot.setTamed(true);
	        	entityocelot.setTameSkin(1 + this.worldObj.rand.nextInt(3));
	        	entityocelot.setOwner(userList[0]);
	           	entityocelot.worldObj.setEntityState(this, (byte)7);
	           	
	           	
	           	double R = (Math.random() * (500 + 500)) + -500;
	        	entityocelot.setGrowingAge((int) R);
	        	
	        	
	        	
	        	
	        	entityocelot.setLocationAndAngles(this.posX,this.posY,this.posZ,(float)volX ,(float)volY);
	        	
	        	//entityocelot.rotationPitch = (float)volX; 
	        	//entityocelot.rotationYaw = (float)volY;
	        	
		        
		        
		       
	        	entityocelot.addVelocity(volX/2,volY/2, volZ/2);
	        	
		        if (this.worldObj.isRemote==false)
		        {
		        	this.worldObj.spawnEntityInWorld(entityocelot);
		        	
		        };
		        this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);

	        
	        }
			
	    }

	 
	}

