package com.maciej916.indreb.common.block.impl.generator.reactor.nuclear_reactor;

import com.maciej916.indreb.common.api.blockentity.IndRebBlockEntity;
import com.maciej916.indreb.common.api.enums.EnergyTier;
import com.maciej916.indreb.common.api.enums.EnergyType;
import com.maciej916.indreb.common.api.enums.GuiSlotBg;
import com.maciej916.indreb.common.api.enums.InventorySlotType;
import com.maciej916.indreb.common.api.slot.BaseSlot;
import com.maciej916.indreb.common.blockentity.ModBlockEntities;
import com.maciej916.indreb.common.capability.ModCapabilities;
import com.maciej916.indreb.common.capability.reactor.IReactorComponentCapability;
import com.maciej916.indreb.common.item.ModItems;
import com.maciej916.indreb.common.multiblock.reactor.Reactor;
import com.maciej916.indreb.common.multiblock.reactor.ReactorPartIndex;
import com.maciej916.indreb.common.network.ModNetworking;
import com.maciej916.indreb.common.network.packet.PacketPlayPauseReactor;
import com.maciej916.indreb.common.tag.ModTagsItem;
import com.maciej916.indreb.common.util.BlockStateHelper;
import com.maciej916.indreb.common.util.CapabilityUtil;
import com.maciej916.indreb.common.util.StackHandlerHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class BlockEntityNuclearReactor extends IndRebBlockEntity {

    public static final int SYNC_DATA_SLOTS = 5;
    protected final ContainerData data;

    private final Reactor reactor = new Reactor();

    public BlockEntityNuclearReactor(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.NUCLEAR_REACTOR.get(), pos, blockState);
        createEnergyStorage(0, 0, EnergyType.EXTRACT, EnergyTier.BASIC);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> BlockEntityNuclearReactor.this.getReactor().getEnabled() ? 1 : 0;
                    case 1 -> BlockEntityNuclearReactor.this.getReactor().getVentedHeat();
                    case 2 -> BlockEntityNuclearReactor.this.getReactor().getCurrentIEOutput();
                    case 3 -> BlockEntityNuclearReactor.this.getReactor().getCurrentHeat();
                    case 4 -> BlockEntityNuclearReactor.this.getReactor().getMaxHeat();

                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> BlockEntityNuclearReactor.this.getReactor().setEnabled(value == 1);
                    case 1 -> BlockEntityNuclearReactor.this.getReactor().setVentedHeat(value);
                    case 2 -> BlockEntityNuclearReactor.this.getReactor().setCurrentIEOutput(value);
                    case 3 -> BlockEntityNuclearReactor.this.getReactor().setCurrentHeat(value);
                    case 4 -> BlockEntityNuclearReactor.this.getReactor().setMaxHeat(value);

                }
            }

            @Override
            public int getCount() {
                return SYNC_DATA_SLOTS;
            }
        };
    }

    @Override
    public boolean isBaseStorageItemValid(int slot, @NotNull ItemStack stack) {
        return stack.is(ModTagsItem.REACTOR_FUSION);
    }

    @Override
    public void tickWork() {
        boolean isFormed = getBlockState().getValue(BlockStateHelper.REACTOR_PART) != ReactorPartIndex.UNFORMED;

        if (baseSlotsChangedForTick.size() > 0) {
            for (int slotId: baseSlotsChangedForTick) {
                ItemStack stack = getBaseStorage().getStackInSlot(slotId);

                int colId = 0;
                int rowId = 0;
                int currentSlot = 0;
                for (int row = 0; row < 6; row++) {
                    boolean isBreak = false;
                    for (int col = 0; col < 9; col++) {
                        if (currentSlot == slotId) {
                            rowId = row;
                            colId = col;
                            isBreak = true;
                            break;
                        }
                        currentSlot++;
                    }
                    if (isBreak) {
                        break;
                    }
                }

                if (stack.isEmpty()) {
                    reactor.setComponentAt(rowId, colId, null, slotId);
                } else {
                    IReactorComponentCapability cap = CapabilityUtil.getCapabilityHelper(stack, ModCapabilities.REACTOR_ITEM).getValue();
                    if (cap != null) {
                        reactor.setComponentAt(rowId, colId, cap, slotId);
                    }
                }
            }
        }

        if (level.getGameTime() % 20 == 0 && isFormed) {
            reactor.clearVentedHeat();
            reactor.clearIEOutput();

            int totalRodCount = 0;
            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 9; col++) {
                    IReactorComponentCapability component = reactor.getComponentAt(row, col);
                    if (component != null) {
                        totalRodCount += component.getRodCount();
                    }
                }
            }

            activeState = reactor.getEnabled() && totalRodCount > 0;

            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 9; col++) {
                    IReactorComponentCapability component = reactor.getComponentAt(row, col);
                    if (component != null) {
                        component.preReactorTick();
                    }
                }
            }

            for (int row = 0; row < 6; row++) {
                for (int col = 0; col < 9; col++) {
                    IReactorComponentCapability component = reactor.getComponentAt(row, col);
                    if (component != null && !component.isBroken()) {
                        if (reactor.getEnabled()) {
                            component.generateHeat();
                        }
                        component.dissipate();
                        component.transfer();
                    }
                }
            }

            if (reactor.getEnabled()) {
                for (int row = 0; row < 6; row++) {
                    for (int col = 0; col < 9; col++) {
                        IReactorComponentCapability component = reactor.getComponentAt(row, col);
                        if (component != null && !component.isBroken()) {
                            component.generateEnergy();
                        }
                    }
                }
            }

            if (reactor.getEnabled()) {
                for (int row = 0; row < 6; row++) {
                    for (int col = 0; col < 9; col++) {
                        IReactorComponentCapability component = reactor.getComponentAt(row, col);
                        if (component != null) {
                            if (component.isBroken()) {
                                float random = level.getRandom().nextFloat();
                                if (random <= 0.25f && component.getRodCount() > 0) {
                                    ItemStack newStack = getBaseStorage().getStackInSlot(component.getSlotId()).copy();
                                    if (newStack.getItem() == ModItems.FUEL_ROD_URANIUM.get()) {
                                        newStack = new ItemStack(ModItems.FUEL_ROD_URANIUM.get());
                                    } else if (newStack.getItem() == ModItems.FUEL_ROD_URANIUM_DUAL.get()) {
                                        newStack = new ItemStack(ModItems.FUEL_ROD_URANIUM_DUAL_DEPLETED.get());
                                    } else if (newStack.getItem() == ModItems.FUEL_ROD_URANIUM_QUAD.get()) {
                                        newStack = new ItemStack(ModItems.FUEL_ROD_URANIUM_QUAD_DEPLETED.get());
                                    }

                                    getBaseStorage().setStackInSlot(component.getSlotId(), newStack);
                                } else {
                                    StackHandlerHelper.shrinkStack(getBaseStorage(), component.getSlotId(), 1);
                                }

                                reactor.setComponentAt(row, col, null, component.getSlotId());
                            }
                        }
                    }
                }
            }

            System.out.println(reactor.getCurrentHeat());
            System.out.println(reactor.getMaxHeat());


            if (reactor.getEnabled()) {
                if (reactor.getCurrentHeat() >= reactor.getMaxHeat()) {
                    reactor.explodeReactor((ServerLevel) level, getBlockPos(), totalRodCount);
                }
            }

            setChanged();

            for (EnergyTier tier: EnergyTier.values()) {
                if (tier.getBasicTransfer() > reactor.getCurrentIEOutput() / 20) {
                    getEnergyStorage().setMaxEnergy(tier.getBasicTransfer());
                    if (getEnergyStorage().energyTier() != tier) {
                        getEnergyStorage().setEnergyTier(tier);
                    }
                    break;
                }
            }
        }

        if (reactor.getCurrentIEOutput() > 0 && !reactor.isFluid()) {
            int generateEnergy = getEnergyStorage().generateEnergy(reactor.getCurrentIEOutput() / 20, true);
            if (generateEnergy > 0) {
                getEnergyStorage().generateEnergy(generateEnergy, false);
            }
        }
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new MenuNuclearReactor(this, containerId, playerInventory, player, data);
    }

    @Override
    public ArrayList<BaseSlot> addBaseSlots(ArrayList<BaseSlot> slots) {
        int startX = 7 + 18;
        int startY = 17 ;
        int slotId = 0;
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 9; i++) {
                slots.add(new BaseSlot(slotId, startX + (i * 18) + 1, startY + (j * 18) + 1, startX + (i * 18), startY + (j * 18), InventorySlotType.INPUT, GuiSlotBg.NORMAL));
                slotId++;
            }
        }

        return super.addBaseSlots(slots);
    }

    @Override
    public int getBaseStorageSlotLimit(int slot) {
        return 1;
    }

    @Override
    public boolean canExtractEnergyCustom(Direction side) {
        return true;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        reactor.deserializeNBT(tag.getCompound("reactor"));
        reactor.initComponents(getBaseStorage());
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("reactor", reactor.serializeNBT());
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {

        if (cap == ModCapabilities.ENERGY) {
            BlockState state = getBlockState();
            if (state.getValue(BlockStateHelper.REACTOR_PART) != ReactorPartIndex.UNFORMED) {
                return energyStorageCap.cast();
            }

            return LazyOptional.empty();
        }

        return super.getCapability(cap, side);
    }

    public Runnable clickPlayPauseClient() {
        return () -> ModNetworking.INSTANCE.sendToServer(new PacketPlayPauseReactor(getBlockPos()));
    }

    public void clickPlayPauseServer() {
        reactor.setEnabled(!reactor.getEnabled());
    }

    public Reactor getReactor() {
        return reactor;
    }
}
