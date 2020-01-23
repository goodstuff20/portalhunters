package com.portalhunters.weapons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.math.*;

public class Weapon {
    protected ItemStack weapon; //= new ItemStack(Material.BOW, 1);
    protected Rarity rarity;
    protected Material material;
    protected String klasse;
    protected int schärfegrad, strength, attackspeed,materialdamage;
    protected Effect effect;
    protected boolean doublehand;
    
    // TODO add item properties, e.g.: protected int strength;

    public Weapon(ItemStack weapon) {
        this.weapon = weapon;
    }

    public Weapon(Material material, int level,int materialdamage, Rarity r, String klasse, Effect effekt, boolean doublehand ) {
    	this.rarity = r;
        this.material = material;
        this.materialdamage = materialdamage;
        this.klasse = klasse;
        this.effect = effect;
        this.doublehand = doublehand;
        generateWeaponStats(level);
        
    }
    
    public boolean getDoubleHand() {
    	return this.doublehand;
    }


    protected void generateWeaponStats(int levels) { // TODO based on level
    	int level = levels;
        switch (rarity) {
        
            case COMMON:
            	
            	strength = (int) Math.ceil((10+materialdamage)*1.13^(level-1) + ((math.random()*3)-1)*1.13^(level-1)))
                break;
            	
            case UNCOMMON:
            	
            	strength = (int) Math.ceil((12+materialdamage)*1.13^(level-1) + ((math.random()*3)-1)*1.13^(level-1)))
            	
                break;
            	
            case RARE:
            	
            	strength = (int) Math.ceil((15+materialdamage)*1.13^(level-1) + ((math.random()*3)-1)*1.13^(level-1)))- 
                break;
            	
            case LEGENDARY:
            	
            	strength = (int) Math.ceil((19+materialdamage)*1.13^(level-1) + ((math.random()*3)-1)*1.13^(level-1)))
                break;
        }
        // weapon = new ...; weapon.set...
    }

    protected void loadWeaponData() {}

    public ItemStack getWeapon() {
        return weapon;
    }
}