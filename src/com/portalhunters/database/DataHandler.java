package com.portalhunters.database;

import com.portalhunters.PortalHunters;
import org.bukkit.configuration.file.FileConfiguration;

public class DataHandler {

    public static void loadFiles(){
        reloadConfigFile();
        reloadNamesFile();
    }

    public static void reloadConfigFile() {
        FileConfiguration c = new FileLoader("plugins/PortalHunters", "config.yml").getFileConfiguration();
        ConfigDefaults.configDefaults();
        PortalHunters.config = c;
    }

    public static void reloadNamesFile() {
        FileConfiguration c = new FileLoader("plugins/PortalHunters", "names.yml").getFileConfiguration();
        ConfigDefaults.namesDefaults();
        PortalHunters.names = c;
    }

}
