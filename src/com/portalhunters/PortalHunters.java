package com.portalhunters;

import com.portalhunters.actions.ActionListener;
import com.portalhunters.database.DataHandler;
import com.portalhunters.weapons.Rarity;
import com.portalhunters.weapons.sword.*;
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
    public ActionListener actionListener;

    protected Utils utils;

    @Override
    public void onEnable() {
        //getLogger().info(ChatColor.AQUA + "[Tntbow]" + ChatColor.YELLOW + "is ready to go!");
        //getServer().getPluginManager().registerEvents(this, this);
        DataHandler.loadFiles();
        utils = new Utils();
        actionListener = new ActionListener();
    }

    @Override
    public void onDisable() {}

    //just testing:
    @EventHandler
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("ph") || cmd.getName().equalsIgnoreCase("portalhunters")) {
            if(!(sender instanceof Player))
                return false;
            Player p = (Player)sender;

            if(args.length > 0) {
                if(args[0].equals("sword")) {
                    //testing:
                    ItemStack weapon = new ItemStack(Material.IRON_SWORD, 1);
                    ItemMeta meta = weapon.getItemMeta();
                    meta.setDisplayName(ChatColor.BLUE + "Rusty long sword");
                    meta.setLore(Arrays.asList("Die Waffe von Tod selbst", "", "Stärke: 2", "Durability: 1/5"));
                    weapon.setItemMeta(meta);
                    p.getInventory().setItemInMainHand(weapon);
                    return true;
                }else if(args[0].equals("weapon")) {
                    if(args.length == 2) { // /portalhunters weapon <axe/dagger/katana/longsword/spear>
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
