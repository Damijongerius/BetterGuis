package com.me.dami.activabetterinterface.Base;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public interface IOpenGui {

    void OpenInventory(Inventory _inv, Player _p);

    Inventory OpenInventory(Player _p, String _name);

}
