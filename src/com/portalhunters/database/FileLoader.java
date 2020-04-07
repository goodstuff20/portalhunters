package com.portalhunters.database;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileLoader {
    private File rawFile;
    private String path, fileName;

    @Deprecated
    public FileLoader(String path, String target, String res) {
        this.path = path;
        this.fileName = target;
    }

    public FileLoader(String path, String target) {
        this.path = path;
        this.fileName = target;
    }

    public FileConfiguration getFileConfiguration() {
        rawFile = new File(path, fileName);
        if(!rawFile.exists()) {
            new File(path).mkdirs();
            try {
                rawFile.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        FileConfiguration fc = new YamlConfiguration();
        try {
            fc.load(rawFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return fc;
    }

    /*public FileConfiguration getFileConfiguration() {
        rawFile = new File(path, fileName);
        boolean newfile = false;
        if(!rawFile.exists()) {
            new File(path).mkdirs();
            try {
                rawFile.createNewFile();
                newfile = true;
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        FileConfiguration fc = new YamlConfiguration();
        try {
            fc.load(rawFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        if(newfile)
            ConfigDefaults.configDefaults();
        return fc;
    }*/
}
