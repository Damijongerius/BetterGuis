package com.me.dami.activabetterinterface.GUI.Handlers.tinyBehaviors;

import com.dami.guimanager.Gui.TinyBehavior;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BadgeDescription implements TinyBehavior {
    @Override
    public Inventory execute(Inventory inv, Object obj) {
        if(obj instanceof String){
            ItemStack item = inv.getItem(13);
            ItemMeta meta = Objects.requireNonNull(item).getItemMeta();
            assert meta != null;
            meta.setLore(List.of((String) ((String) obj).substring(0,20) + "..."));
            item.setItemMeta(meta);

            inv.setItem(13, item);
        }
        return inv;
    }
}
