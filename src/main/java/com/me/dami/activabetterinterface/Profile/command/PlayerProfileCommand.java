package com.me.dami.activabetterinterface.Profile.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PlayerProfileCommand implements ICommand {

    public boolean Executed(Player _p, String[] _args) {

        if(_args.length == 0){
                GUIManager.OpenInventory(_p, _p.getName(), InventoryType.PLAYERPROFILE);
        }


        //if(_args[1]) is an existing player stored in database
        //open other player
        //first look if player exists

        return false;
    }

    public void Action(Player _p, String _player) {

    }


    public void UnImplementedArgument() {

    }


    public List<String> TabExecutor(String[] _args) {
        return null;
    }
}
