package com.me.dami.activabetterinterface;

import com.dami.guimanager.Gui.Gui;
import com.dami.guimanager.GuiManager;
import com.dami.guimanager.Item.Items;
import com.me.dami.activabetterinterface.GUI.Handlers.*;
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

        db = new DataBase("customer_259613_coreprotect", "cDqUHpGB^7sqXMr7", "jdbc:mysql://customer_259613_coreprotect:cDqUHpGB^7sqXMr7@eu02-sql.pebblehost.com/customer_259613_coreprotect");

       initializeGm();
    }

    private void initializeGm(){
        Map<String, ItemStack> staticItems = new LinkedHashMap<>();
        staticItems.put("space",Items.generateItem("", Material.WHITE_STAINED_GLASS_PANE,true));
        staticItems.put("exit",Items.generateItem("Exit", Material.RED_CANDLE,"this is for exiting the inventory",true));

        List<Gui> guis = new ArrayList<>();
        guis.add(new Gui("playerView", new PlayerInfoManager(gm)));
        guis.add(new Gui("kingdomView", new KingdomManager(gm)));
        guis.add(new Gui("badgeCreator", new BadgeCreatorManager()));
        guis.add(new Gui("badgeList"));
        guis.add(new Gui("kingdomBadgeList", new KingdomBadgeListManager(gm)));//to show lists of kingdom badges
        guis.add(new Gui("kingdomBadgeList-staff", new KingdomBadgeListManagerStaff(gm)));
        guis.add(new Gui("playerBadgeList", new PlayerBadgeList()));//to show list of player badges
        guis.add(new Gui("playerBadgeList-staff"));
        guis.add(new Gui("playerView-staff"));//with annotations

        gm.onInitialize(guis,staticItems);

    }

    public static ActivaBetterInterface getInstance(){
        return instance;
    }
}
