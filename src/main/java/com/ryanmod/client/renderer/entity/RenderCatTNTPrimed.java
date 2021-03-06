package com.ryanmod.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderTNTPrimed;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.ryanmod.cattnt.BlockCatTNT;
import com.ryanmod.cattnt.EntityCatTNTPrimed;

@SideOnly(Side.CLIENT)
public class RenderCatTNTPrimed extends RenderTNTPrimed{
	  private RenderBlocks blockRenderer = new RenderBlocks();
	   
	    public void doRender(EntityTNTPrimed par1EntityTNTPrimed, double par2, double par4, double par6, float par8, float par9)
	    {
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
	        float f2;

	        Block renderBlock = com.ryanmod.cattnt.CatTNT.blockCatTNT;     
	        
	        if ((float)par1EntityTNTPrimed.fuse - par9 + 1.0F < 10.0F)
	        {
	            f2 = 1.0F - ((float)par1EntityTNTPrimed.fuse - par9 + 1.0F) / 10.0F;

	            if (f2 < 0.0F)
	            {
	                f2 = 0.0F;
	            }

	            if (f2 > 1.0F)
	            {
	                f2 = 1.0F;
	            }

	            f2 *= f2;
	            f2 *= f2;
	            float f3 = 1.0F + f2 * 0.3F;
	            GL11.glScalef(f3, f3, f3);
	        }

	        f2 = (1.0F - ((float)par1EntityTNTPrimed.fuse - par9 + 1.0F) / 100.0F) * 0.8F;
	        this.bindEntityTexture(par1EntityTNTPrimed);
	        this.blockRenderer.renderBlockAsItem(renderBlock, 0, par1EntityTNTPrimed.getBrightness(par9));

	        if (par1EntityTNTPrimed.fuse / 5 % 2 == 0)
	        {
	            GL11.glDisable(GL11.GL_TEXTURE_2D);
	            GL11.glDisable(GL11.GL_LIGHTING);
	            GL11.glEnable(GL11.GL_BLEND);
	            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_DST_ALPHA);
	            GL11.glColor4f(1.0F, 1.0F, 1.0F, f2);
	            this.blockRenderer.renderBlockAsItem(renderBlock, 0, 1.0F);
	            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	            GL11.glDisable(GL11.GL_BLEND);
	            GL11.glEnable(GL11.GL_LIGHTING);
	            GL11.glEnable(GL11.GL_TEXTURE_2D);
	        }

	        GL11.glPopMatrix();
	    }


	    /**
	     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	     */
	    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	    {
	        this.doRender((EntityTNTPrimed)par1Entity, par2, par4, par6, par8, par9);
	    }
}
