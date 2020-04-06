package com.portalhunters.weapons.sword;

import com.portalhunters.weapons.Weapon;
import org.bukkit.Material;

public class Sword extends Weapon {

    public Sword(Material material, int level, String title) {
        super(material, level, "Sword"); // TODO get title out of config etc.
    }
}
