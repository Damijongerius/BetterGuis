package com.me.dami.activabetterinterface.GUI;

import com.dami.guimanager.Item.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BadgeGUI {

    int[] slots  = {1,2,3,4,5,6,7,10,11,12,13,14,15,16,19,20,21,22,23,24,25,28,29,30,31,32,33,34,37,38,39,40,41,42,43,46,47,48,49,50,51,52};
    int[] space = {0,8,9,17,18,36,44,45,53};
    int[] staffSlots = {4,5,6,7,14,15,16,23,24,25,32,33,34,41,42,43,50,51,52};
    int[] staffSpace = {4,13,22,31,40,49};
    int[] existingSlots = {1,2,3,10,11,13,19,20,21,28,29,30,37,38,39,46,47,48};

    public void openInventory(Inventory inv, Player p) {
        inv = Bukkit.createInventory(null,54,p.getDisplayName());

        for(int slot : space){
            inv.setItem(slot, Items.definedItems.get("space"));
        }
        ItemStack item = new ItemStack(Material.WRITABLE_BOOK);
        p.openBook(item);
    }

    public void openStaffInventory(Player p, String name) {
        Inventory inv = Bukkit.createInventory(null,54,p.getDisplayName());
    }


    public Inventory openInventory(Player p, String name) {
        return null;
    }

}
