package com.firework.client.Features.CustomMainMenu;

import com.firework.client.Features.CustomMainMenu.FireworkMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OnGuiOpenEvent {
    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public void onGuiOpenEvent(GuiOpenEvent e) {
        if (e.getGui() instanceof GuiMainMenu) {
            e.setGui(new FireworkMenu());
        }
    }
}
