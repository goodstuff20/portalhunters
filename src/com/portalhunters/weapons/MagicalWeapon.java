package com.portalhunters.weapons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MagicalWeapon extends Weapon {
    public MagicalWeapon(Material material, int level, Rarity r, WeaponType weaponType) {
        super(material, level, r, weaponType);
    }

    public MagicalWeapon(Material material, int level, Rarity r, String title) {
        super(material, level, r, title);
    }
}
