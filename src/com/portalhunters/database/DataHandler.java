package com.portalhunters.database;

import com.portalhunters.PortalHunters;
import org.bukkit.configuration.file.FileConfiguration;

public class DataHandler {

    public static void reloadDatabase() {
        FileConfiguration c = new FileLoader("plugins/PortalHunters", "database.yml").getFileConfiguration();
        PortalHunters.database = c;
    }

}
