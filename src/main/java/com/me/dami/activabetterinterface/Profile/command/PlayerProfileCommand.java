package com.me.dami.activabetterinterface.Profile.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import org.bukkit.entity.Player;

import java.util.List;


public class PlayerProfileCommand{
    private final GUIManager gui;

    public PlayerProfileCommand(GUIManager gui){
        this.gui = gui;
    }
    public boolean Executed(Player p, String[] args) {

        if(args.length == 0){
            gui.openInventory(p, p.getName(), InventoryType.PLAYERMANAGER);
        }
        if(args.length == 1){
            gui.openInventory(p, args[0], InventoryType.PLAYERMANAGER);
        }


        // is an existing player stored in database
        //open other player
        //first look if player exists

        return false;
    }


    public List<String> TabExecutor(String[] args) {
        return null;
    }
}
