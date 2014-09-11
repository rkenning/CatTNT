package com.ryanmod.cattnt;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.math.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;



	public class EntityCatTNTPrimed extends EntityTNTPrimed
	implements IEntityAdditionalSpawnData
	
	{
		  public int type;

		  public EntityCatTNTPrimed(World par1World)
		  {
		    super(par1World);
		  }

		  public EntityCatTNTPrimed(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase)
		  {
		    super(par1World, par2, par4, par6, par8EntityLivingBase);
		  }

		    public void onUpdate()
		    {
		        this.prevPosX = this.posX;
		        this.prevPosY = this.posY;
		        this.prevPosZ = this.posZ;
		        this.motionY -= 0.03999999910593033D;
		        this.moveEntity(this.motionX, this.motionY, this.motionZ);
		        this.motionX *= 0.9800000190734863D;
		        this.motionY *= 0.9800000190734863D;
		        this.motionZ *= 0.9800000190734863D;

		        if (this.onGround)
		        {
		            this.motionX *= 0.699999988079071D;
		            this.motionZ *= 0.699999988079071D;
		            this.motionY *= -0.5D;
		        }

		        if (this.fuse-- <= 0)
		        {
		            this.setDead();

		            if (!this.worldObj.isRemote)
		            {
		                modexplode();
		            }
		        }
		        else
		        {
		            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
		        }
		    }

		  private void modexplode()
		  {
		        float f = 4.0F;
		        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
		   
		        CatExplosion explosion = new CatExplosion(type, this.worldObj, riddenByEntity, this.posX, this.posY, this.posZ, f);
		        explosion.doExplosionA();
		        explosion.doExplosionB(false);
		  }

		@Override
		public void writeSpawnData(ByteBuf buffer) {
			// TODO Auto-generated method stub
		    buffer.writeInt(this.fuse);
		 
		}

		@Override
		public void readSpawnData(ByteBuf additionalData) {
			// TODO Auto-generated method stub
		 this.fuse = additionalData.readInt();
		 	
		}

		 
		}