package com.me.dami.activabetterinterface.Base;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private final String name;
    private final InventoryPerms perms;

    private final InventoryType type;
    private Inventory inv;

    public InventoryManager(String _name, Inventory _inv, InventoryPerms _perms, InventoryType _type){
        name = _name;
        inv = _inv;
        perms = _perms;
        type = _type;
    }

    public String getName(){
        return name;
    }

    public void UpdateInventory(Inventory _inv){
        inv.setContents(_inv.getContents());
    }

    public Inventory getInventory(){
        return this.inv;
    }

    public boolean Compare(String _name, InventoryType _type, InventoryPerms _perms){
        if(this.name != _name){
            return false;
        }

        if(this.type != _type){
            return  false;
        }

        if(this.perms == _perms){
            return true;
        }

        return false;
    }

    public InventoryPerms getPerms() {
        return perms;
    }

    public InventoryType getType() {
        return type;
    }

}
