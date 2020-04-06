package com.portalhunters.database;

import com.portalhunters.PortalHunters;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigDefaults {

    public static void configDefaults() {
        FileConfiguration c = new FileLoader("plugins/PortalHunters", "config.yml").getFileConfiguration();
        PortalHunters.config = c;
        String path = "classes.xp.";
        c.addDefault(path + "baseXP", "625");
        c.addDefault(path + "exponent", "1.9");
        path = "weapons.sword.";
        c.addDefault(path + "material", Material.IRON_SWORD);
        c.addDefault(path + "name", "&b&lSword"); //TODO weitere daten in die default config rein tun
        c.addDefault(path + "katana.material", Material.GOLDEN_SWORD);
        c.addDefault(path + "spear.material", Material.TRIDENT);

        c.options().header( //TODO shit entfernen und neu schreiben
                "##### Portal Hunters Main Configuration #####\n" +
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

    public static void namesDefaults() {
        FileConfiguration c = new FileLoader("plugins/PortalHunters", "names.yml").getFileConfiguration();
        PortalHunters.names = c;
        String path = "weapons.";
        List<String> axeCommonNameList = new ArrayList<String>(Arrays.asList( //TODO change into Common/Uncommon/Legendary name lists!
                "Axe of the dawn",
                "Choppy mcChop!",
                "Ol' fella",
                "Trusty companion"));
        c.addDefault(path + "axe", axeCommonNameList);

        List<String> daggerCommonNameList = new ArrayList<String>(Arrays.asList(
                "Swift dagger",
                "hidden one"));
        c.addDefault(path + "dagger", daggerCommonNameList);

        List<String> katanaCommonNameList = new ArrayList<String>(Arrays.asList(
                "dragon art companion",
                "5th generation blood-katana",
                "Chunchunmaru"));
        c.addDefault(path + "katana", katanaCommonNameList);

        List<String> longswordCommonNameList = new ArrayList<String>(Arrays.asList(
                "Knights blade",
                "Bluesteel"));
        c.addDefault(path + "longsword", longswordCommonNameList);

        List<String> spearCommonNameList = new ArrayList<String>(Arrays.asList(
                "Horse's third eye",
                "pokey"));
        c.addDefault(path + "spear", spearCommonNameList);

        c.options().header( //TODO shit entfernen und neu schreiben
                "##### Portal Hunters Names Configuration #####\n");
        c.options().copyDefaults(true);
        PortalHunters.saveNamesFile();
    }


}
