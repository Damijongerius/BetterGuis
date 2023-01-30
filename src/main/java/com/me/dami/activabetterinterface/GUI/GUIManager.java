package com.me.dami.activabetterinterface.GUI;

import com.me.dami.activabetterinterface.Base.InventoryManager;
import com.me.dami.activabetterinterface.Base.InventoryType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * redirects events to right GUI
 * saves location of player in menu's
 */
public class GUIManager implements Listener{
    private static List<InventoryManager> inventoryManagers = new ArrayList<>();

    @EventHandler
    private static void OnInventoryClick(InventoryClickEvent e){
        System.out.println("click");
    }

    @EventHandler
    private static void OnInventoryCloseEvent(InventoryCloseEvent e){
        System.out.println("another click");
    }

    public static void OpenInventory(Player _p, String _name, InventoryType _type){

    }

    public static void CloseInventory(Player _p){

    }
    public static void CloseInventory(String inventory){

    }
}
