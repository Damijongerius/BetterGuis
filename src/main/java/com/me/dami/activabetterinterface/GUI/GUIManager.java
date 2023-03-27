package com.me.dami.activabetterinterface.GUI;

import com.me.dami.activabetterinterface.Base.InventoryType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryView;

import java.util.*;

/**
 * redirects events to right GUI
 * saves location of player in menu's
 */
public class GUIManager implements Listener{

    private static GUIManager instance;
    private List<Gui> guis = new ArrayList<>();

    private Map<UUID,Gui>  waitingfor = new LinkedHashMap<>();

    public GUIManager(){
        instance = this;
    }

    public void openInventory(Player p, String name, InventoryType type){
        String sType = type.toString().toLowerCase();
        Gui gui = getGui(sType);
        gui.addPlayer(p,name);
    }

    private Gui getGui(String name) {
        if (!guis.isEmpty()) {
            for (Gui gui : guis) {
                if (Objects.equals(gui.getName(), name)) {
                    return gui;
                }
            }
        }
        Gui newGui = new Gui(name);
        guis.add(newGui);
        System.out.println("return new gui size:" +  guis.size());
        return newGui;
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e){
        InventoryView view = e.getView();

        if(e.getInventory().getHolder() != null){
            return;
        }

        if(view.getTitle().startsWith("playermanager")){
            getGui("playermanager").getName();
        }
        if(view.getTitle().startsWith("kingdommanager")){
            getGui("kingdommanager").getName();
        }
        if(view.getTitle().startsWith("badgemanager")){
            getGui("badgemanager").getName();
        }
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
            getGui("kingdommanager").removePlayer(e.getPlayer().getUniqueId());
        }
        if(view.getTitle().startsWith("badgemanager")){
            getGui("badgemanager").removePlayer(e.getPlayer().getUniqueId());
        }
    }

    public static GUIManager getInstance(){
        return instance;
    }
}
