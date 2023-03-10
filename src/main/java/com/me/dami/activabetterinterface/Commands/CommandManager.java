package com.me.dami.activabetterinterface.Commands;

import com.me.dami.activabetterinterface.Badge.Command.BadgeCommand;
import com.me.dami.activabetterinterface.Kingom.command.KingdomProfileCommand;
import com.me.dami.activabetterinterface.Profile.command.PlayerProfileCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements TabExecutor {

    private PlayerProfileCommand playerProfileCommand = new PlayerProfileCommand();
    private KingdomProfileCommand kingdomProfileCommand = new KingdomProfileCommand();
    private BadgeCommand badgeCommand = new BadgeCommand();

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label, String[] args) {
        if(!(sender instanceof Player || sender instanceof ConsoleCommandSender)){
            return false;
        }


        Player p = ((Player) sender).getPlayer();
        System.out.println("command executed");
        switch (command.getName()){
            case "profile" -> playerProfileCommand.Executed(p , args);
            case "kprofile" -> kingdomProfileCommand.Executed(p , args);
            case "trophy" -> badgeCommand.Executed(p , args);
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
        }
        return options;
    }
}
