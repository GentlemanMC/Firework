package com.firework.client.Features.Modules.Client;

import com.firework.client.Features.Modules.Module;
import com.firework.client.Features.Modules.ModuleArgs;
import com.firework.client.Implementations.Events.PacketEvent;
import com.firework.client.Implementations.Mixins.MixinsList.ICPacketCustomPayload;
import io.netty.buffer.Unpooled;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@ModuleArgs(name="NoForge", category=Module.Category.CLIENT)
public class NoForge
extends Module {
    @SubscribeEvent
    public void onPacketSend(PacketEvent event) {
        if (!this.mc.isIntegratedServerRunning()) {
            if (event.getPacket().getClass().getName().equals("net.minecraftforge.fml.common.network.internal.FMLProxyPacket")) {
                event.setCanceled(true);
            } else if (event.getPacket() instanceof CPacketCustomPayload && ((CPacketCustomPayload)event.getPacket()).getChannelName().equalsIgnoreCase("MC|Brand")) {
                ((ICPacketCustomPayload)((Object)event.getPacket())).setData(new PacketBuffer(Unpooled.buffer()).writeString("vanilla"));
            }
        }
    }
}
