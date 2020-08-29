package com.portalhunters;

import com.portalhunters.database.DataHandler;
import com.portalhunters.listeners.PlayerListener;
import com.portalhunters.weapons.sword.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Arrays;

public class PortalHunters extends JavaPlugin {
    public static PortalHunters instance;
    public static FileConfiguration config;
    public static FileConfiguration names;

    protected Utils utils;

    @Override
    public void onEnable() {
        getLogger().info(ChatColor.AQUA + "[PortalHunters]" + ChatColor.YELLOW + "is ready to go!");
        DataHandler.loadFiles();
        utils = new Utils();
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {}

    /**
     * later create a proper command class etc.
     * this is just for testing at the moment
     */
    @EventHandler
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("ph") || cmd.getName().equalsIgnoreCase("portalhunters")) {
            if(!(sender instanceof Player))
                return false;
            Player p = (Player)sender;

            if(args.length > 0) {
                if(args[0].equals("sword")) {
                    ItemStack weapon = new ItemStack(Material.IRON_SWORD, 1);
                    ItemMeta meta = weapon.getItemMeta();
                    meta.setDisplayName(ChatColor.BLUE + "Rusty long sword");
                    meta.setLore(Arrays.asList("Die Waffe von Tod selbst", "", "Stärke: 2", "Durability: 1/5"));
                    weapon.setItemMeta(meta);
                    p.getInventory().setItemInMainHand(weapon);
                    return true;
                }else if(args[0].equals("weapon")) {
                    if(args.length == 2) {
                        if(args[1].equals("axe")){
                            Axe axe = new Axe(10);
                            p.getInventory().setItemInMainHand(axe.getWeapon());
                        }else if(args[1].equals("dagger")){
                            Dagger dagger = new Dagger(12);
                            p.getInventory().setItemInMainHand(dagger.getWeapon());
                        }else if(args[1].equals("katana")){
                            Katana katana = new Katana(15);
                            p.getInventory().setItemInMainHand(katana.getWeapon());
                        }else if(args[1].equals("longsword")){
                            Longsword longsword = new Longsword(9);
                            p.getInventory().setItemInMainHand(longsword.getWeapon());
                        }else if(args[1].equals("spear")){
                            Spear spear = new Spear(7);
                            p.getInventory().setItemInMainHand(spear.getWeapon());
                        }
                    }
                    return true;
                }
            } else {
                p.sendMessage("=== PortalHunters ===");
                p.sendMessage("/ph sword : get a rusty long sword");
                p.sendMessage("/ph weapon <axe/dagger/katana/longsword/spear> : get a custom weapon");
            }
        }
        return false;
    }

    public static void saveConfigFile() {
        try {
            config.save("plugins/PortalHunters/config.yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveNamesFile() {
        try {
            names.save("plugins/PortalHunters/names.yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
