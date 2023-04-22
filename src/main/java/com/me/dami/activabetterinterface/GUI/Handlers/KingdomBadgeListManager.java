package com.me.dami.activabetterinterface.GUI.Handlers;

import com.dami.guimanager.Gui.GuiBehavior;
import com.dami.guimanager.Gui.GuiCreator;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class KingdomBadgeListManager implements GuiBehavior {
    @Override
    public void onInventoryClick(InventoryClickEvent e, String name) {

    }

    @Override
    public Inventory updateInventory(Inventory inv, String name) {

        return null;
    }

    @Override
    public Inventory buildInventory(String prefix, String name) {
        GuiCreator creator = new GuiCreator(prefix,name,54);

        return null;
    }
}
