package com.ryanmod.cattnt;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

// Slight change to check push/commit works
// Second test commit to make sure it works from my other machine

public class BlockCatTNT extends BlockTNT
{
	  public int type;

	  public BlockCatTNT()
	  {
	    this.type = 1;
	  }

	  
	  
	    public void onBlockDestroyedByExplosion(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_)
	    {
	        if (!p_149723_1_.isRemote)
	        {
	        	EntityCatTNTPrimed entitytntprimed = new EntityCatTNTPrimed(p_149723_1_, (double)((float)p_149723_2_ + 0.5F), (double)((float)p_149723_3_ + 0.5F), (double)((float)p_149723_4_ + 0.5F), p_149723_5_.getExplosivePlacedBy());
	            entitytntprimed.fuse = p_149723_1_.rand.nextInt(entitytntprimed.fuse / 4) + entitytntprimed.fuse / 8;
	            p_149723_1_.spawnEntityInWorld(entitytntprimed);
	        }
	    }

	  public void func_150114_a(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_)
	  {
	    if (!p_150114_1_.isRemote)
	    {
	      if ((p_150114_5_ & 0x1) == 1)
	      {
	    	  EntityCatTNTPrimed entitytntprimed = new EntityCatTNTPrimed(p_150114_1_, p_150114_2_ + 0.5F, p_150114_3_ + 0.5F, p_150114_4_ + 0.5F, p_150114_6_);
	        entitytntprimed.type = this.type;
	        p_150114_1_.spawnEntityInWorld(entitytntprimed);
	        p_150114_1_.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
	      }
	    }
	  }		
	}



