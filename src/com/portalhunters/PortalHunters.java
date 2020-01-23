package com.portalhunters;

import com.portalhunters.database.DataHandler;
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

    protected Utils utils;

    @Override
    public void onEnable() {
        //getLogger().info(ChatColor.AQUA + "[Tntbow]" + ChatColor.YELLOW + "is ready to go!");
        //getServer().getPluginManager().registerEvents(this, this);
        DataHandler.reloadConfigFile();
        utils = new Utils();
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

    public static void saveConfigFile() {
        try {
            config.save("plugins/PortalHunters/config.yml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public void updateStatistics(MinigameUser u){ //TODO: only call this if no error occurs (or else it will save with money = 0 and unlocks = default
        Spaced.database.set("Minigame.PlayerData."+ u.getPlayer().getUniqueId() + ".money", u.getMoney());
        for(String s : Spaced.database.getStringList("Minigame.PlayerData."+ u.getPlayer().getUniqueId() + ".unlocked")) { //TODO: if this doesnt get called, maybe uniqueId().getString()
            System.out.println("anything to add? String: " + s);
            Spaced.database.getStringList("Minigame.PlayerData."+ u.getPlayer().getUniqueId() + ".unlocked").add(s);
        }
        Spaced.saveDataBase();
    }

    private void loadStatistics(MinigameUser user){
        //donateItem = Util.parseItemStack(Spaced.instance.getConfig().getString("Donate-Item"));
        if(Spaced.database.contains("Minigame.PlayerData." + user.getPlayer().getUniqueId())) {
            user.setMoney(Spaced.database.getInt("Minigame.PlayerData." + user.getPlayer().getUniqueId() + ".money"));
            List<String> unlocked = Spaced.database.getStringList("Minigame.PlayerData." + user.getPlayer().getUniqueId() + ".unlocked");
            for(String s : unlocked){
                System.out.println("yo: " + s);
                try{
                    MinigameShips ship = MinigameShips.valueOf(s);
                    user.getUnlocked().add(ship);
                }catch (Exception e){
                    System.out.println("such minigame ship does not exist!");
                }
            }
        } else {

            System.out.println(Spaced.database.get("Minigame.PlayerData.") + " : vs: " + user.getPlayer().getUniqueId());
            System.out.println("money: " + user.getMoney());
            Spaced.database.set("Minigame.PlayerData."+ user.getPlayer().getUniqueId() + ".money", 0);
            List<String> unlocks = new ArrayList<>();
            unlocks.add(MinigameShips.VENATOR.name());
            Spaced.database.set("Minigame.PlayerData."+ user.getPlayer().getUniqueId() + ".unlocked", unlocks);
            Spaced.saveDataBase();
            System.out.println("new statistic");
        }
    }
     */

}
