package com.me.dami.activabetterinterface.GUI;

import com.me.dami.activabetterinterface.Base.InventoryManager;
import com.me.dami.activabetterinterface.Base.InventoryPerms;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.Permissions.LuckPermManager;
import com.me.dami.activabetterinterface.Profile.GUI.PlayerInfoGUI;
import com.me.dami.activabetterinterface.Profile.GUI.PlayerInfoGUIManager;
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
    private static Map<Player,InventoryManager> inventoryManagers = new LinkedHashMap<>();

    private static PlayerInfoGUIManager playerInfoGUIManager = new PlayerInfoGUIManager();

    @EventHandler
    private static void OnInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        InventoryManager manager = inventoryManagers.get(p);
        if(manager != null){
            //the trophy creator doessnt need to be canceld untill we know item has not been put in
            e.setCancelled(true);
            //pass on event to manager
            switch (manager.getType()){
                case PLAYERPROFILE -> PlayerInfoGUIManager.OnInventoryClick(e,manager,p);
            }
        }
    }

    @EventHandler
    private static void OnInventoryCloseEvent(InventoryCloseEvent e){
        System.out.println("another click");
    }

    public static void OpenInventory(Player _p, String _name, InventoryType _type){
        switch (_type){
            case PLAYERPROFILE -> OpenPlayerInventory(_p, _name, _type);
        }
    }

    private static void OpenPlayerInventory(Player _p,String _name,InventoryType _type){
        //should be put in a yml config file
        ArrayList<String> perms = new ArrayList<String>() {
            {
                add("Admin");
                add("Mod");
            }
        };

        boolean perm = LuckPermManager.HasOneOfPermissions(_p, perms);

        InventoryManager manager = null;

        if(perm){
            manager = match(_name, InventoryPerms.MOD, _type);
            if(manager == null){
                inventoryManagers.put(_p,new InventoryManager(_name,new PlayerInfoGUI().OpenInventory(_p, _name),InventoryPerms.MOD, _type));
            }else{
                new PlayerInfoGUI().OpenInventory(manager.getInventory(),_p);
            }
        }
        else{
            manager = match(_name, InventoryPerms.PLAYER, _type);
            if(manager == null){
                inventoryManagers.put(_p,new InventoryManager(_name,new PlayerInfoGUI().OpenInventory(_p, _name),InventoryPerms.PLAYER, _type));
            }else{
                new PlayerInfoGUI().OpenInventory(manager.getInventory(),_p);
            }
        }
    }

    private static InventoryManager match(String _name, InventoryPerms _perm, InventoryType _type){
        if(inventoryManagers.isEmpty()){
            return  null;
        }

        InventoryManager matchingManger = null;

        for(Map.Entry<Player, InventoryManager> manger : inventoryManagers.entrySet()){
            if(manger.getValue().Compare(_name, _type, _perm)){
                matchingManger = manger.getValue();
                break;
            }
        }
        return  matchingManger;
    }

    public static void CloseInventory(Player _p){

    }

    public static void CloseInventory(String inventory){

    }
}
