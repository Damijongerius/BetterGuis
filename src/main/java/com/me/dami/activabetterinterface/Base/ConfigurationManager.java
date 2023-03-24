package com.me.dami.activabetterinterface.Base;

import com.me.dami.activabetterinterface.ActivaBetterInterface;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigurationManager {

    private static Map<String,ConfigurationManager> managers = new LinkedHashMap<>();

    private File configFile;
    private static ActivaBetterInterface main;
    private FileConfiguration config;

    private String fileName;

    public ConfigurationManager(ActivaBetterInterface _main, String _fileName){
        this.main = _main;
        fileName = _fileName;
        managers.put(_fileName,this);

        startUp();
    }

    public ConfigurationManager(ActivaBetterInterface _main, String _fileName, boolean autoStartup){
        this.main = _main;
        fileName = _fileName;
        managers.put(_fileName,this);

        if(autoStartup) startUp();
    }

    //get config data
    public void startUp(){
        try {
            configFile = new File(main.getDataFolder(), fileName + ".yml");
        } catch (Exception e) {
            main.saveResource( fileName+".yml", false);
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void startUp(String customPathAddOn){
        try {
            configFile = new File(main.getDataFolder() + "/" + customPathAddOn, fileName + ".yml");
        } catch (Exception e) {
            main.saveResource( fileName+".yml", false);
        }

        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public ConfigurationSection getSection(String path) throws Exception {
        return config.getConfigurationSection(path);
    }

    public void setConfig(String _path, Object _info){
        config.set(_path, _info);
    }

    //saveConfigFile
    public void saveConfig() {
        try {
            this.config.save(this.configFile);
        } catch (IOException e) {
            main.getLogger().severe("Error saving config: " + e.getMessage());
        }
    }

    public static ConfigurationManager getConfigurationManager(String _fileName)
    {
        return managers.get(_fileName);
    }

}
