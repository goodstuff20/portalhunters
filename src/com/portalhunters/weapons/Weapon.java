package com.portalhunters.weapons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Weapon {
    protected ItemStack weapon; //= new ItemStack(Material.BOW, 1);
    protected Rarity rarity;
    protected Material material;
    // TODO add item properties, e.g.: protected int strength;

    public Weapon(ItemStack weapon) {
        this.weapon = weapon;
    }

    public Weapon(Material material, int level) {
        this.material = material;
        generateWeaponStats(level);
    }


    protected void generateWeaponStats(int level) { // TODO based on level
        switch (rarity) {
            case COMMON:
                break;
            case UNCOMMON:
                break;
            case RARE:
                break;
            case LEGENDARY:
                break;
        }
        // weapon = new ...; weapon.set...
    }

    protected void loadWeaponData() {}

    public ItemStack getWeapon() {
        return weapon;
    }
}