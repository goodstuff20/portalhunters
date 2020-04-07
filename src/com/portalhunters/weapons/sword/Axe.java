package com.portalhunters.weapons.sword;

import com.portalhunters.weapons.Rarity;
import com.portalhunters.weapons.WeaponType;
import com.portalhunters.weapons.sword.Sword;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static com.portalhunters.weapons.Rarity.LEGENDARY;

public class Axe extends Sword {

    public Axe(int level) {
        super(Material.IRON_AXE, level, Rarity.LEGENDARY, WeaponType.AXE);
        // TODO rarity set via probabilities
    }

    public Axe(int level, String title, Rarity r) {
        super(Material.IRON_AXE, level, r, title);
        doublehand = true; // TODO
    }
}
