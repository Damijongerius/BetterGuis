package com.me.dami.activabetterinterface.Badge.Command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import me.map.ultimatekingdom.api.UltimateKingdom;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

public class BadgeCommand  implements ICommand {
    @Override
    public boolean Executed(Player _p, String[] _args) {
        if(_args.length == 0){
            GUIManager.OpenInventory(_p, _p.getName(), InventoryType.BADGELIST);
            //open self
        }

        if(_args.length >= 1){
            if(Objects.equals(_args[0], "player")){
                if(_args.length == 2){
                    //open player name arg[1]
                }
                //open self

            }else if(Objects.equals(_args[0], "kingdom")){
                if(_args.length == 2){
                    //open kingdom arg[1]
                }
                //open self kd
            }
        }
        return false;
    }

    @Override
    public void Action(Player _p, String _player) {

    }

    @Override
    public void UnImplementedArgument() {

    }

    @Override
    public List<String> TabExecutor(String[] _args) {
        return null;
    }
}
