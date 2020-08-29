package com.portalhunters;

import com.portalhunters.classes.ClassManager;
import com.portalhunters.classes.ClassType;
import com.portalhunters.classes.SkillTree;
import org.bukkit.entity.Player;

public class User {
    private Player player;
    private ClassType classType;
    private int currentExp;
    private int currentLevel;
    private ClassManager selectedClass;
    private SkillTree skillTree;

    public User(Player player) {
        this.player = player;
        skillTree = selectedClass.getSkillTree().useThisAsBase();
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
        // TODO: add level up inventory
        currentExp -= levelUpExpNeeded;
        currentLevel++;
        player.sendMessage("level up!");
    }
}
