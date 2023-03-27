package com.me.dami.activabetterinterface.Badge.Command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import me.map.ultimatekingdom.api.UltimateKingdom;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

public class BadgeCommand{
    private final GUIManager gui;

    public BadgeCommand(GUIManager gui){
        this.gui = gui;
    }

    public boolean Executed(Player p, String[] args) {
        if(args.length == 0){
            gui.openInventory(p, p.getName(), InventoryType.BADGEMANAGER);
            //open self
        }

        if(args.length >= 1){
            switch (args[0].toLowerCase()){
                case "create" :{
                    gui.openInventory(p,"creator",InventoryType.BADGEMANAGER);
                }
                case "open" : {

                }
                case "manage": {
                    gui.openInventory(p,"badges",InventoryType.BADGEMANAGER);
                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + args[0].toLowerCase());
            }
        }
        return false;
    }


    public List<String> TabExecutor(String[] _args) {
        return null;
    }
}
