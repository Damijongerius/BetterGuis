package com.me.dami.activabetterinterface.Commands;

import com.dami.guimanager.GuiManager;
import com.me.dami.activabetterinterface.Commands.childs.BadgeCommand;
import com.me.dami.activabetterinterface.Commands.childs.KingdomProfileCommand;
import com.me.dami.activabetterinterface.Commands.childs.PlayerProfileCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements TabExecutor {
    private final PlayerProfileCommand playerProfileCommand;
    private final KingdomProfileCommand kingdomProfileCommand;
    private final BadgeCommand badgeCommand;

    public CommandManager(GuiManager gm){
        playerProfileCommand =  new PlayerProfileCommand(gm);
        kingdomProfileCommand = new KingdomProfileCommand(gm);
        badgeCommand = new BadgeCommand(gm);
    }

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label, String[] args) {
        if(!(sender instanceof Player)){
            return false;
        }


        Player p = ((Player) sender).getPlayer();
        System.out.println("command executed");
        switch (command.getName()){
            case "profile" -> playerProfileCommand.Executed(p , args);
            case "kprofile" -> kingdomProfileCommand.Executed(p , args);
            case "badge" -> badgeCommand.Executed(p , args);
            default -> {
                return false;
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender,  Command command, String label, String[] args) {
        List<String> options = new ArrayList<>();
        switch (command.getName()){
            case "profile" -> options = playerProfileCommand.TabExecutor(args);
            case "kprofile" -> options = kingdomProfileCommand.TabExecutor(args);
            case "trophy" -> options = badgeCommand.TabExecutor(args);
            default -> throw new IllegalStateException("Unexpected value: " + command.getName());
        }
        return options;
    }
}
