package com.me.dami.activabetterinterface.Kingom.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import com.me.dami.activabetterinterface.Base.InventoryType;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import me.map.ultimatekingdom.api.UltimateKingdom;
import org.bukkit.entity.Player;

import java.util.List;

public class KingdomProfileCommand{
    private final GUIManager gui;

    public KingdomProfileCommand(GUIManager gui){
        this.gui = gui;
    }
    public boolean Executed(Player p, String[] args) {

        if(args.length == 0){
            gui.openInventory(p, UltimateKingdom.Players().getPlayer(p).getKingdom().getName(), InventoryType.KINGDOMMANAGER);
        }
        if(args.length == 1){
            gui.openInventory(p, UltimateKingdom.Kingdoms().getKingdom(args[0]).getName(), InventoryType.KINGDOMMANAGER);
        }
        return false;
    }


    public List<String> TabExecutor(String[] args) {
        return null;
    }
}
