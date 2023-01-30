package com.me.dami.activabetterinterface.Profile.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Permissions.LuckPermManager;
import me.map.ultimatekingdom.API.UltimateKingdom;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.UserManager;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PlayerProfileCommand implements ICommand {

    public boolean Executed(Player _p, String[] _args) {

        ArrayList<String> perms = new ArrayList<String>() {
            {
                add("Admin");
                add("Mod");
            }
        };

        if(_args.length == 0){
            //open self info


            LuckPermManager.HasPermissions(_p, perms);

            return false;
        }


        //if(_args[1]) is an existing player stored in database
        //open other player
        //first look if player exists(may be the player needs to be online who knows)

        //feature idea compare player info's

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
