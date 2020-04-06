package com.portalhunters.database;

import com.portalhunters.PortalHunters;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

public class ConfigDefaults {

    public static void fillFile(FileConfiguration c) {
        String path = "classes.xp";
        c.addDefault(path + "baseXP", "625");
        c.addDefault(path + "exponent", "1.9");
        path = "weapons.sword.";
        c.addDefault(path + "material", Material.IRON_SWORD);
        c.addDefault(path + "name", "&b&lSword"); //TODO weitere daten in die default config rein tun
        c.addDefault(path + "katana.material", Material.GOLDEN_SWORD);
        c.addDefault(path + "spear.material", Material.TRIDENT);

        c.options().header( //TODO shit entfernen und neu schreiben
                "##### Portal Hunters Configuration #####\n" +
                        "\n" +
                        "How does this work?\n" +
                        "..." +
                        "\n" +
                        "What are the variables?\n" +
                        "You can use many variables. Here is a list:\n" +
                        "\n" +
                        "  %playing% - The current amount of players in a lobby!\n");



        c.options().copyDefaults(true);
        PortalHunters.saveConfigFile();
    }

}
