package com.me.dami.activabetterinterface.GUI.Handlers.tinyBehaviors;

import com.dami.guimanager.Gui.TinyBehavior;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public class BadgeName implements TinyBehavior {
    @Override
    public Inventory execute(Inventory inv, Object obj) {
        if(obj instanceof String){
            ItemStack item = inv.getItem(12);
            ItemMeta meta = Objects.requireNonNull(item).getItemMeta();
            assert meta != null;
            meta.setDisplayName((String) obj);
            item.setItemMeta(meta);

            inv.setItem(12, item);
        }
        return inv;
    }
}
