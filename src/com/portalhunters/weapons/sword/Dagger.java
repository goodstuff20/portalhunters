package com.portalhunters.weapons.sword;

import com.portalhunters.weapons.Rarity;
import com.portalhunters.weapons.WeaponType;
import com.portalhunters.weapons.sword.Sword;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Dagger extends Sword {

    public Dagger(int level) {
        super(Material.IRON_SHOVEL, level, Rarity.COMMON, WeaponType.DAGGER);
    }

    public Dagger(int level, String title, Rarity r) {
        super(Material.IRON_SHOVEL, level, r, title);
    }
}
