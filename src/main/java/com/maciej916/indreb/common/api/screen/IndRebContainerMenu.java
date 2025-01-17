package com.maciej916.indreb.common.api.screen;

import com.maciej916.indreb.common.api.blockentity.IndRebBlockEntity;
import com.maciej916.indreb.common.api.screen.data.CustomContainerData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;

public class IndRebContainerMenu extends AbstractContainerMenu {
//    private static final int HOTBAR_SLOT_COUNT = 9;
//    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
//    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
//    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
//    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
//    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
//    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;


    private final HashSet<ServerPlayer> listeners = new HashSet<>();
    private final CustomContainerData containerData;

    private final IndRebBlockEntity entity;
    private final Player player;
    private final IItemHandler playerInventory;
    public int playerInvLeft = 8;
    public int playerInvTop = 84;
    private final ContainerData data;

    protected IndRebContainerMenu(@Nullable MenuType<?> pMenuType, IndRebBlockEntity entity, int pContainerId, Inventory playerInventory, Player player, ContainerData data) {
        super(pMenuType, pContainerId);
        this.entity = entity;
        this.player = player;
        this.data = data;
        this.playerInventory = new InvWrapper(playerInventory);
        this.init();
        addDataSlots(data);
        this.containerData = entity.getContainerData();
    }

    public void addContainerListener(Player player) {
        listeners.add((ServerPlayer) player);
        containerData.broadcastToPlayer((ServerPlayer) player, containerId);
    }

    public void removeContainerListener(Player player) {
        listeners.remove((ServerPlayer) player);
    }

    @Override
    public void broadcastChanges() {
        if (listeners.size() > 0) containerData.broadcastChanges(listeners, containerId);
        super.broadcastChanges();
    }

    @Override
    public void broadcastFullState() {
        if (listeners.size() > 0) containerData.broadcastFullState(listeners, containerId);
        super.broadcastFullState();
    }

    public void init() {
        if (getEntity().hasBaseStorage()) getEntity().getBaseStorage().getSlotHandler().forEach(this::addSlot);
        if (getEntity().hasElectricStorage()) getEntity().getElectricStorage().getSlotHandler().forEach(this::addSlot);
        if (getEntity().hasUpgradesStorage()) getEntity().getUpgradesStorage().getSlotHandler().forEach(this::addSlot);

        addPlayerInventory();
    }

    public IndRebBlockEntity getEntity() {
        return entity;
    }

    public Player getPlayer() {
        return player;
    }

    public IItemHandler getPlayerInventory() {
        return playerInventory;
    }

    public ContainerData getData() {
        return data;
    }

    public CustomContainerData getContainerData() {
        return containerData;
    }

    @Override
    public boolean stillValid(Player player) {
        return getEntity().getLevel() != null && stillValid(ContainerLevelAccess.create(getEntity().getLevel(), getEntity().getBlockPos()), player, getEntity().getBlock());
    }

//    @Override
//    public ItemStack quickMoveStack(Player playerIn, int index) {
//        final int TE_INVENTORY_SLOT_COUNT =
//                (getEntity().hasBaseStorage() ? getEntity().getBaseStorage().getSlots() : 0) +
//                (getEntity().hasElectricStorage() ? getEntity().getElectricStorage().getSlots() : 0) +
//                (getEntity().hasUpgradesStorage() ? getEntity().getUpgradesStorage().getSlots() : 0);
//
//
//        System.out.println(TE_INVENTORY_SLOT_COUNT);
//
//        Slot sourceSlot = slots.get(index);
//        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
//        ItemStack sourceStack = sourceSlot.getItem();
//        ItemStack copyOfSourceStack = sourceStack.copy();
//
//        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
//            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
//                return ItemStack.EMPTY;
//            }
//        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
//            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
//                return ItemStack.EMPTY;
//            }
//        } else {
//            System.out.println("Invalid slotIndex:" + index);
//            return ItemStack.EMPTY;
//        }
//
//        if (sourceStack.getCount() == 0) {
//            sourceSlot.set(ItemStack.EMPTY);
//        } else {
//            sourceSlot.setChanged();
//        }
//
//        sourceSlot.onTake(playerIn, sourceStack);
//        return copyOfSourceStack;
//    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;

        int machineSlots = getEntity().hasBaseStorage() ? getEntity().getBaseStorage().getSlots() : 0;
        int batterySlots = machineSlots + (getEntity().hasElectricStorage() ? getEntity().getElectricStorage().getSlots() : 0);
        int upgradeSlots = batterySlots + (getEntity().hasUpgradesStorage() ? getEntity().getUpgradesStorage().getSlots() : 0);
        int totalSlots = upgradeSlots + 36;

        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();

            if (index < upgradeSlots) {
                if (!this.moveItemStackTo(stack, upgradeSlots, totalSlots, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (index < totalSlots) {
                if (!this.moveItemStackTo(stack, 0, upgradeSlots, true)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, stack);
        }

        return itemstack;
    }


    private void addPlayerInventory() {
        addSlotBox(playerInventory, 9, playerInvLeft, playerInvTop, 9, 18, 3, 18);
        addSlotRange(playerInventory, 0, playerInvLeft, playerInvTop + 58, 9, 18);
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }
}
