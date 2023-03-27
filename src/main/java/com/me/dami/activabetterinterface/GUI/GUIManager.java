package com.me.dami.activabetterinterface.GUI;

import com.me.dami.activabetterinterface.Base.InventoryType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryView;

import java.util.ArrayList;
import java.util.List;

/**
 * redirects events to right GUI
 * saves location of player in menu's
 */
public class GUIManager implements Listener{

    private List<Gui> guis = new ArrayList<>();

    public void openInventory(Player p, String name, InventoryType type){
        System.out.println("open inv");
        String sType = type.toString().toLowerCase();
        System.out.println(sType);
        Gui gui = getGui(sType);
        System.out.println("add player");
        gui.addPlayer(p,name);
    }

    private Gui getGui(String name) {
        if (!guis.isEmpty()) {
            for (Gui gui : guis) {
                if (gui.getName() == name) {
                    System.out.println("return existing gui");
                    return gui;
                }
            }
        }
        Gui newGui = new Gui(name);
        guis.add(newGui);
        System.out.println("return new gui");
        return newGui;
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e){

    }

    @EventHandler
    private void onInventoryClose(InventoryCloseEvent e){
        InventoryView view = e.getView();

        if(e.getInventory().getHolder() != null){
            return;
        }

        if(view.getTitle().startsWith("playermanager")){
            getGui("playermanager").removePlayer(e.getPlayer().getUniqueId());
        }
        if(view.getTitle().startsWith("kingdommanager")){
            getGui("playermanager").removePlayer(e.getPlayer().getUniqueId());
        }
        if(view.getTitle().startsWith("badgemanager")){
            getGui("playermanager").removePlayer(e.getPlayer().getUniqueId());
        }
    }
}
