package com.me.dami.activabetterinterface.Commands.childs;

import com.dami.guimanager.GuiManager;
import org.bukkit.entity.Player;

import java.util.List;

public class BadgeCommand{
    private final GuiManager gui;

    public BadgeCommand(GuiManager gui){
        this.gui = gui;
    }

    public boolean Executed(Player p, String[] args) {
        if(args.length == 0){
            gui.openGuiFor(p, "badgeView", p.getName());
            //open self
        }

        if(args.length >= 1){
            switch (args[0].toLowerCase()) {
                case "create" -> gui.openGuiFor(p, "badgeCreator", "creator");
                case "open" -> gui.openGuiFor(p, "badgeView", p.getName());
                case "manage" -> gui.openGuiFor(p, "badgeManager", "page 1");
                default -> throw new IllegalStateException("Unexpected value: " + args[0].toLowerCase());
            }
        }
        return false;
    }


    public List<String> TabExecutor(String[] _args) {
        return null;
    }
}
