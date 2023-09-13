package com.maciej916.indreb.common.network.packet;

import com.maciej916.indreb.common.block.impl.machine.t_super.replicator.BlockEntityReplicator;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketReplicatorPage {

    private final BlockPos blockPos;
    private final boolean next;

    public PacketReplicatorPage(BlockPos blockPos, boolean next) {
        this.blockPos = blockPos;
        this.next = next;
    }

    public PacketReplicatorPage(FriendlyByteBuf buf) {
        blockPos = buf.readBlockPos();
        next = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(blockPos);
        buf.writeBoolean(next);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            assert player != null;
            if (player.level().getBlockEntity(blockPos) instanceof BlockEntityReplicator be) {
                be.changePattern(next);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
