package com.me.dami.activabetterinterface.Base;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Player> players = new ArrayList<>();
    private final String name;
    private Inventory inv;

    private InventoryPerms perms;
    private InventoryType type;

    public InventoryManager(String _name, Inventory _inv, InventoryPerms _perms, InventoryType _type){
        name = _name;
        inv = _inv;
        perms = _perms;
        type = _type;
    }

    public boolean addPlayer(Player _p){
        players.add(_p);

        _p.openInventory(inv);
        return true;
    }

    public List<Player> getViewers(){
        return players;
    }

    public boolean removePlayer(Player _p){
        players.remove(_p);

        if(players.size() == 0){
            return true;
        }
        return false;
    }

    public String getName(){
        return name;
    }

    public void UpdateInventory(Inventory _inv){
        inv.setContents(_inv.getContents());
    }


}
