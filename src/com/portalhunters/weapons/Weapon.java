package com.portalhunters.weapons;

import org.bukkit.inventory.ItemStack;

public class Weapon {
    protected ItemStack weapon; //= new ItemStack(Material.BOW, 1);

    public Weapon(ItemStack weapon) {
        this.weapon = weapon;
    }

    public ItemStack getWeapon() {
        return weapon;
    }
}