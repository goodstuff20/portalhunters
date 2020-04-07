package com.portalhunters.weapons.sword;

import com.portalhunters.weapons.Rarity;
import com.portalhunters.weapons.WeaponType;
import com.portalhunters.weapons.sword.Sword;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Spear extends Sword {

    public Spear(int level) {
        super(Material.IRON_HOE, level, Rarity.COMMON, WeaponType.SPEAR);
    }

    public Spear(int level, String title, Rarity r) {
        super(Material.IRON_HOE, level, r, title);
    }
}