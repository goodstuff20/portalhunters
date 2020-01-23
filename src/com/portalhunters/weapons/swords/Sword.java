package com.portalhunters.weapons.swords;

import com.portalhunters.PortalHunters;
import java.math.*;
import com.portalhunters.weapons.Weapon;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Sword extends Weapon {

    public Sword(ItemStack sword) {
        super(sword);
    }

    public Sword(Material material, int level) {
        super(material, level);
    }

    @Override
    protected void generateWeaponStats(int levels) {
    	int level = levels;
    	switch (rarity) {
        
        case COMMON:
        	
        	strength = (int) Math.ceil((10+materialdamage)*1.13^(level-1) + ((math.random()*3)-1)*1.13^(level-1)))
            break;
        	
        case UNCOMMON:
        	
        	strength = (int) Math.ceil((12+materialdamage)*1.13^(level-1) + ((math.random()*3)-1)*1.13^(level-1)))
        	
            break;
        	
        case RARE:
        	
        	strength = (int) Math.ceil((15+materialdamage)*1.13^(level-1) + ((math.random()*3)-1)*1.13^(level-1)))- 
            break;
        	
        case LEGENDARY:
        	
        	strength = (int) Math.ceil((19+materialdamage)*1.13^(level-1) + ((math.random()*3)-1)*1.13^(level-1)))
            break;
    }
    }

    @Override
    protected void loadWeaponData() {
        if(PortalHunters.database.contains("Weapons.Sword")) {
            // TODO update variables with data from config like so:
            // strength = PortalHunters.database.getInt("Weapons.Sword.Strength");
        } else {
            System.out.println("Error! Database empty!");
        }
    }
}
