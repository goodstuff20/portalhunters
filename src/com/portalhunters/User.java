package com.portalhunters;

import com.portalhunters.actions.Action;
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
        // player.sendMess
        //player.setDisplayName(""); // level and profession
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
        currentExp -= levelUpExpNeeded;
        currentLevel++;
        player.sendMessage("level up!");
        // TODO add level up inventory etc.
    }

    public void removeAction(Action action) {
        // TODO fill
    }

    private void userRunnable(){ //TODO new actions, do: action.setUser(this)!
        // all user runnables here in one scheduler vs. multiple schedulers? Can do fast scheduler and skip x ticks if waiting
        for(SkillTree.Skill skill : skillTree.getSkills()) {
            if(skill.getAction().hasRunnable()) {
                skill.getAction().actionRunnable(this);
            }
        }
    }
}
