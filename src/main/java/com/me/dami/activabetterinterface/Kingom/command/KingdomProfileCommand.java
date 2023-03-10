package com.me.dami.activabetterinterface.Kingom.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import me.map.ultimatekingdom.api.UltimateKingdom;
import org.bukkit.entity.Player;

import java.util.List;

public class KingdomProfileCommand implements ICommand {

    public boolean Executed(Player _p, String[] _args) {

        if(_args.length == 0){
            GUIManager.OpenInventory(_p, UltimateKingdom.Players().getPlayer(_p).getKingdom().getName(), InventoryType.KINGDOMPROFILE);
        }
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
