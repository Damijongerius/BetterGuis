package com.me.dami.activabetterinterface.Badge.GUI;

import com.me.dami.activabetterinterface.Base.IOpenGui;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.StaticGuiItems;
import com.me.dami.activabetterinterface.Permissions.LuckPermManager;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BadgeGUI implements IOpenGui {

    int[] slots  = {1,2,3,4,5,6,7,10,11,12,13,14,15,16,19,20,21,22,23,24,25,28,29,30,31,32,33,34,37,38,39,40,41,42,43,46,47,48,49,50,51,52};
    int[] space = {0,8,9,17,18,36,44,45,53};
    int[] staffSlots = {4,5,6,7,14,15,16,23,24,25,32,33,34,41,42,43,50,51,52};
    int[] staffSpace = {4,13,22,31,40,49};
    int[] existingSlots = {1,2,3,10,11,13,19,20,21,28,29,30,37,38,39,46,47,48};
    @Override
    public void OpenInventory(Inventory _inv, Player _p) {
        Inventory inv = Bukkit.createInventory(null,54,_p.getDisplayName());

        for(int slot : space){
            inv.setItem(slot, StaticGuiItems.space);
        }
        ItemStack item = new ItemStack(Material.WRITABLE_BOOK);
        _p.openBook(item);
    }
    @Override
    public void OpenStaffInventory(Player _p, String _name) {
        Inventory inv = Bukkit.createInventory(null,54,_p.getDisplayName());
    }

    @Override
    public Inventory OpenInventory(Player _p, String _name) {
        return null;
    }
}
