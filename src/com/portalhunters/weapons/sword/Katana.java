package com.portalhunters.weapons.sword;

import com.portalhunters.weapons.Rarity;
import com.portalhunters.weapons.WeaponType;
import com.portalhunters.weapons.sword.Sword;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Katana extends Sword {

    public Katana(int level) {
        super(Material.IRON_BARS, level, Rarity.COMMON, WeaponType.KATANA);
    }

    public Katana(int level, String title, Rarity r) {
        super(Material.IRON_BARS, level, r, title);
    }
}
