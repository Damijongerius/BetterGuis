package com.me.dami.activabetterinterface;

import com.dami.guimanager.Gui.Gui;
import com.dami.guimanager.GuiManager;
import com.dami.guimanager.Item.Items;
import com.me.dami.activabetterinterface.GUI.Handlers.BadgeCreatorManager;
import com.me.dami.activabetterinterface.GUI.Handlers.KingdomManager;
import com.me.dami.activabetterinterface.GUI.Handlers.PlayerInfoManager;
import com.me.dami.activabetterinterface.Base.ConfigurationManager;
import com.me.dami.activabetterinterface.Base.DataBase;
import com.me.dami.activabetterinterface.Base.Saveable;
import com.me.dami.activabetterinterface.Commands.CommandManager;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class ActivaBetterInterface extends JavaPlugin {

    private static ActivaBetterInterface instance;

    private GuiManager gm;
    private CommandManager commandManager;

    private static Saveable saveable = new Saveable();

    private ConfigurationManager FailedSavables;

    private DataBase db;

    @Override
    public void onEnable() {
        gm = GuiManager.getInstance();
        instance = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        commandManager = new CommandManager(gm);

        FailedSavables = new ConfigurationManager(this,  "LostData");

        Objects.requireNonNull(getCommand("profile")).setExecutor(commandManager);
        Objects.requireNonNull(getCommand("kprofile")).setExecutor(commandManager);
        Objects.requireNonNull(getCommand("badge")).setExecutor(commandManager);


       initializeGm();
    }

    private void initializeGm(){
        Map<String, ItemStack> staticItems = new LinkedHashMap<>();
        staticItems.put("space",Items.generateItem("", Material.WHITE_STAINED_GLASS_PANE,true));
        staticItems.put("exit",Items.generateItem("Exit", Material.RED_CANDLE,"this is for exiting the inventory",true));

        List<Gui> guis = new ArrayList<>();
        guis.add(new Gui("playerView", new PlayerInfoManager()));
        guis.add(new Gui("kingdomView", new KingdomManager()));
        guis.add(new Gui("badgeCreator", new BadgeCreatorManager()));

        gm.onInitialize(guis,staticItems);

    }

    public static ActivaBetterInterface getInstance(){
        return instance;
    }
}
