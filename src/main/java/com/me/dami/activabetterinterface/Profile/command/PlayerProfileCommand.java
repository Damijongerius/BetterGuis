package com.me.dami.activabetterinterface.Profile.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import me.map.ultimatekingdom.API.UltimateKingdom;
import net.luckperms.api.LuckPerms;
import org.bukkit.entity.Player;

import java.util.List;

public class PlayerProfileCommand implements ICommand {

    public boolean Executed(Player _p, String[] _args) {

        if(_args.length == 0){
            //open self info
            return false;
        }


        if(_args[1] == UltimateKingdom.Players().get)
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
