package com.portalhunters;

import com.portalhunters.classes.ClassType;
import org.bukkit.entity.Player;

public class User {
    private Player player;
    private ClassType classType;
    private int currentExp;
    private int currentLevel;

    public User(Player player) {
        this.player = player;
        player.sendMess
        //player.setDisplayName(""); // level and profession
    }

    public void gainExp(int exp) {
        if (PortalHunters.config.contains("classes.xp.baseXP") && PortalHunters.config.contains("classes.xp.exponent")) {
            currentExp += exp;
            int expNeeded = (int)Math.floor(PortalHunters.config.getInt("classes.xp.baseXP") * (Math.pow(currentLevel, PortalHunters.config.getDouble("classes.xp.exponent"))));
            if(currentExp >= expNeeded) {
                levelUp(expNeeded);
            }
        } else {
            System.err.println("config is not loaded properly!");
        }
    }

    public void levelUp(int levelUpExpNeeded) {
        currentExp -= levelUpExpNeeded;
        currentLevel++;
        player.sendMessage("level up!");
        // TODO add level up inventory etc.

    }
}
