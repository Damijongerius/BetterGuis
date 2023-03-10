package com.me.dami.activabetterinterface;

import com.me.dami.activabetterinterface.Badge.DB.BadgeSchema;
import com.me.dami.activabetterinterface.Base.DataBase;
import com.me.dami.activabetterinterface.Commands.CommandManager;
import com.me.dami.activabetterinterface.GUI.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.sql.SQLException;

public final class ActivaBetterInterface extends JavaPlugin {

    private CommandManager commandManager = new CommandManager();
    private GUIManager  guiManager = new GUIManager();

    private DataBase db;

    private BadgeSchema bsc;

    @Override
    public void onEnable() {
        getCommand("profile").setExecutor(commandManager);
        getCommand("kprofile").setExecutor(commandManager);
        getCommand("badge").setExecutor(commandManager);

        getServer().getPluginManager().registerEvents(guiManager,this);

        db = new DataBase("customer_259613_coreprotect", "cDqUHpGB^7sqXMr7", "jdbc:mysql://customer_259613_coreprotect:cDqUHpGB^7sqXMr7@eu02-sql.pebblehost.com/customer_259613_coreprotect");

        bsc = new BadgeSchema(this);

        try {
            bsc.LoadSchema();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            bsc.ExecuteSchema();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
