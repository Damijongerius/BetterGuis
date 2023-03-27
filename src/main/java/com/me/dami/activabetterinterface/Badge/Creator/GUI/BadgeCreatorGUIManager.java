package com.me.dami.activabetterinterface.Badge.Creator.GUI;

import com.me.dami.activabetterinterface.Base.InventoryManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BadgeCreatorGUIManager {

    public static void onInventoryClick(InventoryClickEvent e, InventoryManager manager, Player player) {
        int slot = e.getSlot();
        if(e.getClickedInventory().getType() != InventoryType.CHEST){
            return;
        }

        if(e.getSlot() == 10){
            Player p = (Player) e.getWhoClicked();
            ItemStack book = new ItemStack(Material.WRITABLE_BOOK);
            BookMeta bookMeta = (BookMeta) book.getItemMeta();

            // Open the book GUI for the player
            p.openBook(book);
            System.out.println("11");
        }

        if(e.getSlot() == 12){
            System.out.println("12");
        }
        if(e.getSlot() == 11){
            System.out.println("13");
        }
    }
}
