package com.portalhunters;

import com.portalhunters.weapons.swords.Sword;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class PortalHunters extends JavaPlugin {

    @Override
    public void onEnable() {
        //getLogger().info(ChatColor.AQUA + "[Tntbow]" + ChatColor.YELLOW + "is ready to go!");
        //getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {}

    //just testing:
    @EventHandler
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("sword")) {
            if(!(sender instanceof Player))
                return false;
            Player p = (Player)sender;
            //testing:
            ItemStack weapon = new ItemStack(Material.IRON_SWORD, 1);
            ItemMeta meta = weapon.getItemMeta();
            meta.setDisplayName(ChatColor.BLUE + "Rusty long sword");
            meta.setLore(Arrays.asList("Die Waffe von Tod selbst", "", "Stärke: 2", "Durability: 1/5"));
            weapon.setItemMeta(meta);
            p.getInventory().setItemInMainHand(weapon);
            return true;
        }
        return false;
    }

}
