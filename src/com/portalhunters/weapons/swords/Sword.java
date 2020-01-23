package com.portalhunters.weapons.swords;

import com.portalhunters.PortalHunters;
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
    protected void generateWeaponStats(int level) {
        super.generateWeaponStats(level);
    }

    @Override
    protected void loadWeaponData() {
        if(PortalHunters.config.contains("Weapons.Sword")) {
            // TODO update variables with data from config like so:
            // strength = PortalHunters.database.getInt("Weapons.Sword.Strength");
        } else {
            System.out.println("Error! Database empty!");
        }
    }
}
