package com.me.dami.activabetterinterface.Base;

import org.bukkit.entity.Player;

import java.util.List;

public interface ICommand {

    boolean Executed(Player _p, String[] _args);

    void Action(Player _p, String _player);

    void UnImplementedArgument();

    List<String> TabExecutor(String[] _args);

}
