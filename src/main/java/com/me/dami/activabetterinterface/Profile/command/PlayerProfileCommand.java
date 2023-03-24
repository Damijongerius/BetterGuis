package com.me.dami.activabetterinterface.Profile.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import org.bukkit.entity.Player;

import java.util.List;


public class PlayerProfileCommand implements ICommand {

    public boolean Executed(Player p, String[] args) {

        if(args.length == 0){
                GUIManager.openInventory(p, p.getName(), InventoryType.PLAYERPROFILE);
        }
        if(args.length == 1){
            GUIManager.openInventory(p, args[0], InventoryType.PLAYERPROFILE);
        }


        // is an existing player stored in database
        //open other player
        //first look if player exists

        return false;
    }

    public void Action(Player p, String player) {

    }


    public void UnImplementedArgument() {

    }


    public List<String> TabExecutor(String[] args) {
        return null;
    }
}
