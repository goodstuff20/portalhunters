package com.portalhunters.weapons.sword;

import com.portalhunters.weapons.Rarity;
import com.portalhunters.weapons.WeaponType;
import com.portalhunters.weapons.sword.Sword;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Longsword extends Sword {

    public Longsword(int level) {
        super(Material.IRON_SWORD, level, Rarity.COMMON, WeaponType.LONG_SWORD);
    }

    public Longsword(int level, String title, Rarity r) {
        super(Material.IRON_SWORD, level, r, title);
    }
}
