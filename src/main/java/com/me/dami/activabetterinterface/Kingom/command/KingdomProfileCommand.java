package com.me.dami.activabetterinterface.Kingom.command;

import com.me.dami.activabetterinterface.Base.ICommand;
import org.bukkit.entity.Player;

import java.util.List;

public class KingdomProfileCommand implements ICommand {

    public boolean Executed(Player _p, String[] _args) {
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
