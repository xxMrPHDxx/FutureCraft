package com.mrphd.mod.items.block.machines;

import com.mrphd.mod.items.tileentity.SinteringFurnaceRecipes;
import com.mrphd.mod.items.tileentity.TileEntitySinteringFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerSinteringFurnace extends Container {

	private final TileEntitySinteringFurnace tileentity;
	private int cookTime, totalCookTime, burnTime, currentBurnTime;
	
	public ContainerSinteringFurnace(InventoryPlayer player, TileEntitySinteringFurnace entity) {
		this.tileentity = entity;

		this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
		this.addSlotToContainer(new FuelSlot(tileentity, 2, 23, 33));
		this.addSlotToContainer(new OutputSlot(player.player, tileentity, 3, 116, 35));
		
		for(int y=0; y<3; y++) {
			for(int x=0; x<9; x++) {
				this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		for(int x=0; x<9; x++) {
			this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
		}
	}
	
	@Override
	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.tileentity);
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for(int i=0; i<listeners.size(); i++) {
			IContainerListener listener = (IContainerListener) this.listeners.get(i);
			
			if(cookTime != tileentity.getField(2)) listener.sendWindowProperty(this, 2, tileentity.getField(2));
			if(burnTime != tileentity.getField(0)) listener.sendWindowProperty(this, 0, tileentity.getField(0));
			if(currentBurnTime != tileentity.getField(1)) listener.sendWindowProperty(this, 1, tileentity.getField(1));
			if(totalCookTime != tileentity.getField(3)) listener.sendWindowProperty(this, 3, tileentity.getField(3));
		}
		
		this.cookTime = tileentity.getField(2);
		this.burnTime = tileentity.getField(0);
		this.currentBurnTime = tileentity.getField(1);
		this.totalCookTime = tileentity.getField(3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data) {
		tileentity.setField(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return tileentity.isUsableByPlayer(playerIn);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = (Slot)inventorySlots.get(index);
		
		if(slot != null && slot.getHasStack()) {
			ItemStack stack1 = slot.getStack();
			stack = stack1.copy();
			
			if(index == 3) {
				if(!mergeItemStack(stack1, 4, 40, true)) return ItemStack.EMPTY;
				slot.onSlotChange(stack1, stack);
			} else if(index != 2 && index != 1 && index != 0) {
				Slot slot1 = (Slot)inventorySlots.get(index + 1);
				
				if(!SinteringFurnaceRecipes.getInstance().getSinteringResult(stack1, slot1.getStack()).isEmpty()) {
					if(!mergeItemStack(stack1, 0, 2, false)) {
						return ItemStack.EMPTY;
					} else if(TileEntitySinteringFurnace.isItemFuel(stack1)) {
						if(!mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
					} else if(index >= 4 && index < 31) {
						if(!mergeItemStack(stack1, 31, 40, false)) return ItemStack.EMPTY;
					} else if(index >= 31 && index < 40 && !mergeItemStack(stack1, 4, 31, false)) {
						return ItemStack.EMPTY;
					}
				}
			} else if(mergeItemStack(stack1, 4, 40, false)) {
				return ItemStack.EMPTY;
			}
			if(stack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return stack;
	}
	
	public static class FuelSlot extends Slot {

		public FuelSlot(IInventory inventory, int index, int x, int y) {
			super(inventory, index, x, y);
		}
		
		@Override
		public boolean isItemValid(ItemStack stack) {
			return TileEntitySinteringFurnace.isItemFuel(stack);
		}
		
		@Override
		public int getItemStackLimit(ItemStack stack) {
			return super.getItemStackLimit(stack);
		}
		
	}
	
	public static class OutputSlot extends Slot { 
		
		private final EntityPlayer player;
		private int removeCount;
		
		public OutputSlot(EntityPlayer player, IInventory inventory, int index, int x, int y) {
			super(inventory, index, x, y);
			this.player = player;
		}
		
		@Override
		public boolean isItemValid(ItemStack stack) {
			return false;
		}
		
		@Override
		public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
			this.onCrafting(stack);
			super.onTake(thePlayer, stack);
			return stack;
		}
		
		@Override
		public ItemStack decrStackSize(int amount) {
			if(this.getHasStack()) this.removeCount += Math.min(amount, this.getStack().getCount());
			return super.decrStackSize(amount);
		}
		
	}
	
}
