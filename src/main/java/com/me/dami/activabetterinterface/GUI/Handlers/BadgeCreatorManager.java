package com.me.dami.activabetterinterface.GUI.Handlers;

import com.dami.guimanager.Gui.GuiBehavior;
import com.dami.guimanager.Gui.GuiCreator;
import com.dami.guimanager.Item.Items;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public class BadgeCreatorManager implements GuiBehavior {

    @Override
    public void onInventoryClick(InventoryClickEvent e, String s) {
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

    @Override
    public Inventory updateInventory(Inventory inventory, String s) {
        return inventory;
    }

    @Override
    public Inventory buildInventory(String prefix, String name) {
        GuiCreator creator = new GuiCreator(prefix,name,27);

        creator.setItems(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26}, Items.definedItems.get("space"));
        creator.setItem(10,Items.generateItem("Item Display", Material.SUNFLOWER));
        creator.setItem(12,Items.generateItem("Item DisplayName", Material.WRITABLE_BOOK));
        creator.setItem(13,Items.generateItem("Item Description",Material.WRITABLE_BOOK));

        return creator.buildInventory();
    }
}
