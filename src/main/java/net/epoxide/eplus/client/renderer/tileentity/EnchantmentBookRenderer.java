package net.epoxide.eplus.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import net.epoxide.eplus.lib.util.RenderUtil;
import net.epoxide.eplus.tileentity.TileEntityEnchantmentBook;

public class EnchantmentBookRenderer extends TileEntitySpecialRenderer {
    
    private static ResourceLocation texture = new ResourceLocation("eplus:textures/entity/enchantingplus_book.png");
    
    @Override
    public void renderTileEntityAt (TileEntity tileEntity, double x, double y, double z, float tickPartial) {
        
        if (tileEntity instanceof TileEntityEnchantmentBook) {
            
            TileEntityEnchantmentBook book = (TileEntityEnchantmentBook) tileEntity;
            
            GL11.glPushMatrix();
            GL11.glTranslated(x, y, z);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            RenderUtil.renderBook(texture, book.tickCount, book.pageFlipPrev, book.pageFlip, book.rotation, book.prevRotation, book.foldAmount, book.prevFoldAmount, tickPartial);
            GL11.glPopMatrix();
        }
    }
}