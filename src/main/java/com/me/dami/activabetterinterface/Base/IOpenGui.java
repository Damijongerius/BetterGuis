package com.me.dami.activabetterinterface.Base;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface IOpenGui {

    void openInventory(Inventory inv, Player p);

    void openStaffInventory(Player p,  String name);

    Inventory openInventory(Player p, String name);

}
