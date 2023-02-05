package com.me.dami.activabetterinterface.Profile.GUI;

import com.me.dami.activabetterinterface.Base.InventoryManager;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInfoGUIManager {

    public static void OnInventoryClick(InventoryClickEvent e, InventoryManager manager, Player player){
        int slot = e.getSlot();
        if(!(slot > 11) && !(slot < 17)){
            return;
        }

        if(slot == 12){
            //open kingdom menu
        }

        if(slot == 13){
            //open medal menu
        }

        if(slot == 14){
            //open playtime top
        }

        if(slot == 16){
            //close everything
        }

        return;
    }
}
