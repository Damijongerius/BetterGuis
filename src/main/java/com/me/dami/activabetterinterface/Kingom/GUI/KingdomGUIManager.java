package com.me.dami.activabetterinterface.Kingom.GUI;

import com.me.dami.activabetterinterface.Base.InventoryManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class KingdomGUIManager {

    public static void OnInventoryClick(InventoryClickEvent e, InventoryManager manager, Player player) {
        int slot = e.getSlot();
    }
}
