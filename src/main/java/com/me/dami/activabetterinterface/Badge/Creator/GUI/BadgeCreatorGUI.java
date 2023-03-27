package com.me.dami.activabetterinterface.Badge.Creator.GUI;

import com.me.dami.activabetterinterface.Base.IOpenGui;
import com.me.dami.activabetterinterface.GUI.StaticGuiItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BadgeCreatorGUI {

    static int space[] = {0,1,2,3,4,5,6,7,8,9,11,17,18,19,20,21,22,23,24,25,26};


    public static Inventory openInventory(String name) {
        Inventory inv = Bukkit.createInventory(null,27,name);

        for(int slot : space){
            inv.setItem(slot, StaticGuiItems.space);
        }

        inv.setItem(10,StaticGuiItems.generateItem("Item Display", Material.SUNFLOWER,null,true));

        inv.setItem(12,StaticGuiItems.generateItem("Item DisplayName", Material.WRITABLE_BOOK,null,true));

        inv.setItem(13,StaticGuiItems.generateItem("Item Description", Material.WRITABLE_BOOK,null,true));

        return inv;
    }
}
