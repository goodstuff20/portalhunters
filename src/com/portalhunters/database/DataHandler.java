package com.portalhunters.database;

import com.portalhunters.PortalHunters;
import org.bukkit.configuration.file.FileConfiguration;

public class DataHandler {

    public static void reloadConfigFile() {
        FileConfiguration c = new FileLoader("plugins/PortalHunters", "config.yml").getFileConfiguration();
        PortalHunters.config = c;
    }

}
