package com.me.dami.activabetterinterface;

import com.me.dami.activabetterinterface.Commands.CommandManager;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;

public final class ActivaBetterInterface extends JavaPlugin {

    private CommandManager commandManager = new CommandManager();
    private GUIManager  guiManager = new GUIManager();

    @Override
    public void onEnable() {
        getCommand("profile").setExecutor(commandManager);
        getCommand("kprofile").setExecutor(commandManager);
        getCommand("tropy").setExecutor(commandManager);

        getServer().getPluginManager().registerEvents(guiManager,this);
    }
}
