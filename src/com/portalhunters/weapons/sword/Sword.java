package com.portalhunters.weapons.sword;

import com.portalhunters.weapons.Rarity;
import com.portalhunters.weapons.Weapon;
import com.portalhunters.weapons.WeaponType;
import org.bukkit.Material;

public class Sword extends Weapon {

    public Sword(Material material, int level, Rarity r, WeaponType weaponType) {
        super(material, level, r, weaponType);
    }

    public Sword(Material material, int level, Rarity r, String title) {
        super(material, level, r, title);
    }
}
