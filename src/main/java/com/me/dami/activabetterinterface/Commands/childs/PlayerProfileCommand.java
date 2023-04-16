package com.me.dami.activabetterinterface.Commands.childs;

import com.dami.guimanager.GuiManager;
import org.bukkit.entity.Player;

import java.util.List;


public class PlayerProfileCommand{
    private final GuiManager gui;

    public PlayerProfileCommand(GuiManager gui){
        this.gui = gui;
    }
    public boolean Executed(Player p, String[] args) {

        if(args.length == 0){
            gui.openGuiFor(p,"playerView", p.getName());
        }
        if(args.length == 1){
            gui.openGuiFor(p,"playerView", args[0]);
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
