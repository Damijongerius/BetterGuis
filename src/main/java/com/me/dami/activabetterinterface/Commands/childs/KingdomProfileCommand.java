package com.me.dami.activabetterinterface.Commands.childs;

import com.dami.guimanager.GuiManager;
import me.map.ultimatekingdom.api.UltimateKingdom;
import org.bukkit.entity.Player;

import java.util.List;

public class KingdomProfileCommand{
    private final GuiManager gui;

    public KingdomProfileCommand(GuiManager gui){
        this.gui = gui;
    }
    public boolean Executed(Player p, String[] args) {

        if(args.length == 0){
            gui.openGuiFor(p,"kingdomView", UltimateKingdom.Players().getPlayer(p).getKingdom().getName());
        }
        if(args.length == 1){
            gui.openGuiFor(p,"kingdomView", UltimateKingdom.Kingdoms().getKingdom(args[0]).getName());
        }
        return false;
    }


    public List<String> TabExecutor(String[] args) {
        return null;
    }
}
