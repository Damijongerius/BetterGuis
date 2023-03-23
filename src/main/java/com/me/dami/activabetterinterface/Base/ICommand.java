package com.me.dami.activabetterinterface.Base;

import org.bukkit.entity.Player;

import java.util.List;

public interface ICommand {

    boolean Executed(Player p, String[] args);

    void Action(Player p, String player);

    void UnImplementedArgument();

    List<String> TabExecutor(String[] args);

}
