package com.me.dami.activabetterinterface.Commands;

import com.me.dami.activabetterinterface.Kingom.command.KingdomProfileCommand;
import com.me.dami.activabetterinterface.Profile.command.PlayerProfileCommand;
import com.me.dami.activabetterinterface.Thropees.command.ThropyCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.K;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements TabExecutor {

    private PlayerProfileCommand playerProfileCommand = new PlayerProfileCommand();
    private KingdomProfileCommand kingdomProfileCommand = new KingdomProfileCommand();
    private ThropyCommand thropyCommand = new ThropyCommand();

    @Override
    public boolean onCommand(CommandSender sender,Command command,String label, String[] args) {

        if(!(sender instanceof Player && sender instanceof ConsoleCommandSender)){
            return false;
        }


        Player p = ((Player) sender).getPlayer();

        switch (command.getName()){
            case "profile" -> playerProfileCommand.Executed(p , args);
            case "kprofile" -> kingdomProfileCommand.Executed(p , args);
            case "trophy" -> thropyCommand.Executed(p , args);
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender,  Command command, String label, String[] args) {
        List<String> options = new ArrayList<>();
        switch (command.getName()){
            case "profile" -> options = playerProfileCommand.TabExecutor(args);
            case "kprofile" -> options = kingdomProfileCommand.TabExecutor(args);
            case "trophy" -> options = thropyCommand.TabExecutor(args);
        }
        return options;
    }
}
