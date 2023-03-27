package com.me.dami.activabetterinterface.GUI;

import com.me.dami.activabetterinterface.Badge.Creator.GUI.BadgeCreatorGUI;
import com.me.dami.activabetterinterface.Kingom.GUI.KingdomGUI;
import com.me.dami.activabetterinterface.Profile.GUI.PlayerInfoGUI;
import me.map.ultimatekingdom.api.UltimateKingdom;
import me.map.ultimatekingdom.api.objects.Kingdom;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Gui {

    private final String name;
    private Map<UUID,String> players =  new LinkedHashMap<>();
    private Map<String, Inventory> openInventories = new LinkedHashMap<>();

    private final static GUIManager guim = GUIManager.getInstance();

    public Gui(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addPlayer(Player p, String name){
        boolean isAdmin = p.hasPermission("kingdom.admin");
        String oldname = name;
        name = isAdmin ? name + "- staff" : name;
        players.put(p.getUniqueId(),name);
        Inventory inv = getInventory(isAdmin, name, oldname);
        if(inv != null){
            p.openInventory(inv);
        }
    }

    public void removePlayer(UUID uuid){
        players.remove(uuid);
        if(players.isEmpty()){
            openInventories.clear();
        }
    }

    private Inventory getInventory(boolean isAdmin, String name, String base){
        if(openInventories.containsKey(this.name + " - " + name)){
            return openInventories.get(this.name + " - " + name);
        }
        switch (this.name){
            case "playermanager" : {
                Player p = Bukkit.getPlayer(base);
                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(base);
                if(p == null){
                    if(offlinePlayer == null){
                        System.out.println("[message] someone tried to load the profile of a player named (" + base + ")" + " we failed loading it");
                        return null;
                    }
                    if(isAdmin){
                        return PlayerInfoGUI.createInventory(offlinePlayer, name);
                    }
                    return PlayerInfoGUI.createInventory(offlinePlayer, name);
                }
                if(isAdmin){
                    return PlayerInfoGUI.createInventory(p, name);
                }
                return PlayerInfoGUI.createInventory(p, name);
            }
            case "kingdommanager"  : {
                Kingdom kd = UltimateKingdom.Kingdoms().getKingdom(base);
                if(kd == null){
                    System.out.println("[message] someone tried to load the profile of a kingdom named (" + base + ")" + " we failed loading it");
                    return null;
                }

                if(isAdmin){
                    return KingdomGUI.createInventory(kd, name);
                }
                return KingdomGUI.createInventory(kd, name);
            }

            case "badgemanager" : {
                //list of kingdom, list of player, list of existing badges
                if(isAdmin){
                    if(base == "creator"){
                        return BadgeCreatorGUI.openInventory(name);
                    }
                    if(base == "badges"){

                    }
                }

                //lijst van badges van...




            }
            default: {
                System.out.println("this is not supposed to happen check in class (gui) on method getInventory | unexpected argument:" + this.name);
                return null;
            }
        }


    }

}
