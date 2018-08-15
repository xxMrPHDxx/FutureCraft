package com.mrphd.mod.items.block.machines;

import com.mrphd.mod.items.tileentity.TileEntitySinteringFurnace;
import com.mrphd.mod.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiSinteringFurnace extends GuiContainer {

	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID, "textures/gui/sintering_furnace.png");
	private final InventoryPlayer player;
	private final TileEntitySinteringFurnace tileentity;
	
	public GuiSinteringFurnace(InventoryPlayer player, TileEntitySinteringFurnace tileentity) {
		super(new ContainerSinteringFurnace(player, tileentity));
		this.player = player;
		this.tileentity = tileentity;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String tilename = this.tileentity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(tilename, (this.xSize / 2 - fontRenderer.getStringWidth(tilename) / 2) + 3, 8, Reference.FONT_COLOR);
		this.fontRenderer.drawString(player.getDisplayName().getUnformattedText(), 122, ySize - 96 + 2, Reference.FONT_COLOR);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		mc.getTextureManager().bindTexture(TEXTURES);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, xSize, ySize);
		
		if(TileEntitySinteringFurnace.isBurning(tileentity)) {
			int k = getBurnLeftScales(13);
			drawTexturedModalRect(guiLeft + 24, guiTop + 53 + 12 - k, 176, 12 - k, 14, k + 1);
		}
		
		int l = getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 35, 176, 14, l + 1, 16);
	}
	
	private int getBurnLeftScales(int pixels) {
		int i = tileentity.getField(1);
		if(i == 2) i = 200;
		return tileentity.getField(0) * pixels / i;
	}
	
	private int getCookProgressScaled(int pixels) {
		int i = tileentity.getField(2);
		int j = tileentity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}
	
	public static class GuiHandler implements IGuiHandler {

		@Override
		public ContainerSinteringFurnace getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			if(ID == Reference.GUI_SINTERING_FURNACE) return new ContainerSinteringFurnace(player.inventory, (TileEntitySinteringFurnace)world.getTileEntity(new BlockPos(x, y, z)));
			return null;
		}

		@Override
		public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
			if(ID == Reference.GUI_SINTERING_FURNACE) return new GuiSinteringFurnace(player.inventory, (TileEntitySinteringFurnace)world.getTileEntity(new BlockPos(x, y, z)));
			return null;
		}
		
	}
	
}
