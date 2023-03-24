package com.me.dami.activabetterinterface.GUI;

import com.me.dami.activabetterinterface.Base.InventoryManager;
import com.me.dami.activabetterinterface.Base.InventoryPerms;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.Kingom.GUI.KingdomGUI;
import com.me.dami.activabetterinterface.Kingom.GUI.KingdomGUIManager;
import com.me.dami.activabetterinterface.Profile.GUI.PlayerInfoGUI;
import com.me.dami.activabetterinterface.Profile.GUI.PlayerInfoGUIManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * redirects events to right GUI
 * saves location of player in menu's
 */
public class GUIManager implements Listener{
    private static Map<Player,InventoryManager> inventoryManagers = new LinkedHashMap<>();

    @EventHandler
    private static void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        InventoryManager manager = inventoryManagers.get(p);
        if(manager != null){
            //the trophy creator doessnt need to be canceld untill we know item has not been put in
            e.setCancelled(true);
            switch (manager.getType()){
                case PLAYERPROFILE -> PlayerInfoGUIManager.OnInventoryClick(e,manager,p);
                case KINGDOMPROFILE -> KingdomGUIManager.OnInventoryClick(e,manager,p);
                default -> p.sendMessage("something on our end failed try again later or contact a developer");
            }
        }
    }

    @EventHandler
    private static void onInventoryCloseEvent(InventoryCloseEvent e){
        if(inventoryManagers.isEmpty()){
            return;
        }
        inventoryManagers.remove(e.getPlayer());
    }

    public static void openInventory(Player p, String name, InventoryType type){
        switch (type){
            case PLAYERPROFILE -> openPlayerInventory(p, name, type);
            case KINGDOMPROFILE -> openKingdomInventory(p,name,type);
            default -> p.sendMessage("something on our end failed try again later or contact a developer");
        }
    }

    private static void openPlayerInventory(Player p,String name,InventoryType type){
        //should be put in a yml config file

        boolean perm = p.hasPermission("kingdom.admin");

        InventoryManager manager = null;

        if(perm){
            manager = match(name, InventoryPerms.MOD, type);
            if(manager == null){
                inventoryManagers.put(p,new InventoryManager(name,new PlayerInfoGUI().OpenInventory(p, name),InventoryPerms.MOD, type));
            }else{
                new PlayerInfoGUI().OpenInventory(manager.getInventory(),p);
            }
        }
        else{
            manager = match(name, InventoryPerms.PLAYER, type);
            if(manager == null){
                inventoryManagers.put(p,new InventoryManager(name,new PlayerInfoGUI().OpenInventory(p, name),InventoryPerms.PLAYER, type));
            }else{
                new PlayerInfoGUI().OpenInventory(manager.getInventory(),p);
            }
        }
    }

    private static InventoryManager match(String name, InventoryPerms perm, InventoryType type){
        if(inventoryManagers.isEmpty()){
            return  null;
        }

        InventoryManager matchingManger = null;

        for(Map.Entry<Player, InventoryManager> manager : inventoryManagers.entrySet()){
            if(manager.getValue().Compare(name, type, perm)){
                matchingManger = manager.getValue();
                break;
            }
        }
        return  matchingManger;
    }

    private static void openKingdomInventory(Player p,String name, InventoryType type){
        //should be put in a yml config file

        boolean perm = p.hasPermission("kingdom.admin");

        InventoryManager manager = null;
        if(perm){
            manager = match(name, InventoryPerms.ADMIN, type);
            if(manager == null){
                inventoryManagers.put(p,new InventoryManager(name,new KingdomGUI().OpenInventory(p, name),InventoryPerms.ADMIN, type));
            }else{
                new KingdomGUI().OpenInventory(manager.getInventory(),p);
            }
        }
        else{
            manager = match(name, InventoryPerms.PLAYER, type);
            if(manager == null){
                p.sendMessage("open");
                inventoryManagers.put(p,new InventoryManager(name,new KingdomGUI().OpenInventory(p, name),InventoryPerms.PLAYER, type));
            }else{
                p.sendMessage("open new");
                new KingdomGUI().OpenInventory(manager.getInventory(),p);
            }
        }
    }
    public static void closeInventory(String inventory){
        //to close a type of gui for everyone
    }
}
