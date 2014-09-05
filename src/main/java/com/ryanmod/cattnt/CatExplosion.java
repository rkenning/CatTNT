package com.ryanmod.cattnt;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class CatExplosion extends Explosion
{
  private World worldObj;
  public int type;
  protected Random field_77290_i = new Random();

  public CatExplosion(int type, World par1World, Entity par2Entity, double par3, double par5, double par7, float par9)
  {
    super(par1World, par2Entity, par3, par5, par7, par9);
    this.type = type;
    this.worldObj = par1World;
  }
  

  /**
   * Does the second part of the explosion (sound, particles, drop spawn)
   */
  public void doExplosionB(boolean par1)
  {
      this.worldObj.playSoundEffect(this.explosionX, this.explosionY, this.explosionZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);

      if (this.explosionSize >= 2.0F && this.isSmoking)
      {
          this.worldObj.spawnParticle("hugeexplosion", this.explosionX, this.explosionY, this.explosionZ, 1.0D, 0.0D, 0.0D);
      }
      else
      {
          this.worldObj.spawnParticle("largeexplode", this.explosionX, this.explosionY, this.explosionZ, 1.0D, 0.0D, 0.0D);
      }

      Iterator iterator;
      ChunkPosition chunkposition;
      int i;
      int j;
      int k;
      Block block;

      if (this.isSmoking)
      {
          iterator = this.affectedBlockPositions.iterator();

          while (iterator.hasNext())
          {
              chunkposition = (ChunkPosition)iterator.next();
              i = chunkposition.chunkPosX;
              j = chunkposition.chunkPosY;
              k = chunkposition.chunkPosZ;
              block = this.worldObj.getBlock(i, j, k);

              if (par1)
              {
                  double d0 = (double)((float)i + this.worldObj.rand.nextFloat());
                  double d1 = (double)((float)j + this.worldObj.rand.nextFloat());
                  double d2 = (double)((float)k + this.worldObj.rand.nextFloat());
                  double d3 = d0 - this.explosionX;
                  double d4 = d1 - this.explosionY;
                  double d5 = d2 - this.explosionZ;
                  double d6 = (double)MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
                  d3 /= d6;
                  d4 /= d6;
                  d5 /= d6;
                  double d7 = 0.5D / (d6 / (double)this.explosionSize + 0.1D);
                  d7 *= (double)(this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3F);
                  d3 *= d7;
                  d4 *= d7;
                  d5 *= d7;
                  this.worldObj.spawnParticle("explode", (d0 + this.explosionX * 1.0D) / 2.0D, (d1 + this.explosionY * 1.0D) / 2.0D, (d2 + this.explosionZ * 1.0D) / 2.0D, d3, d4, d5);
                  this.worldObj.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
              }

              if (block.getMaterial() != Material.air)
              {
                  if (block.canDropFromExplosion(this))
                  {
                      block.dropBlockAsItemWithChance(this.worldObj, i, j, k, this.worldObj.getBlockMetadata(i, j, k), 1.0F / this.explosionSize, 0);
                  }

                  block.onBlockExploded(this.worldObj, i, j, k, this);
              }
          }
      }

      if (this.isFlaming)
      {
          iterator = this.affectedBlockPositions.iterator();

          while (iterator.hasNext())
          {
              chunkposition = (ChunkPosition)iterator.next();
              i = chunkposition.chunkPosX;
              j = chunkposition.chunkPosY;
              k = chunkposition.chunkPosZ;
              block = this.worldObj.getBlock(i, j, k);
              Block block1 = this.worldObj.getBlock(i, j - 1, k);

              if (block.getMaterial() == Material.air && block1.func_149730_j() )
              {
                  this.worldObj.setBlock(i, j, k, Blocks.fire);
              }
          }
      }
  }
  }

