package com.me.dami.activabetterinterface.Kingom.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import me.map.ultimatekingdom.api.UltimateKingdom;
import org.bukkit.entity.Player;

import java.util.List;

public class KingdomProfileCommand implements ICommand {

    public boolean Executed(Player p, String[] args) {

        if(args.length == 0){
            GUIManager.OpenInventory(p, UltimateKingdom.Players().getPlayer(p).getKingdom().getName(), InventoryType.KINGDOMPROFILE);
        }
        if(args.length == 1){
            GUIManager.OpenInventory(p, UltimateKingdom.Kingdoms().getKingdom(args[0]).getName(), InventoryType.KINGDOMPROFILE);
        }
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
