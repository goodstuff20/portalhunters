package com.portalhunters.weapons;

import org.bukkit.Effect;
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

    public Weapon(Material material, int level) {
        //TODO nur für die Schwert klasse für jetzt getan, soll das bleiben? Was für standard types?
        this(material, level, 0, Rarity.COMMON, "", null, false);
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


    protected void generateWeaponStats(int levels) { // TODO based on level; Die Funktion scheint ähnlich zu sein -> vlt basis Funktion mit variablen die über common/unc./.. sich ändern?
    	int level = levels;
        switch (rarity) {
            case COMMON:
                strength = (int) Math.ceil((10)*Math.pow(1.13,(level-1)) + ((Math.random()*3)-1)*Math.pow(1.13,(level-1)));
                break;
            case UNCOMMON:
                strength = (int) Math.ceil((12)*Math.pow(1.13,(level-1)) + ((Math.random()*3)-1)*Math.pow(1.13,(level-1)));
                break;
            case RARE:
                strength = (int) Math.ceil((15)*Math.pow(1.13,(level-1)) + ((Math.random()*3)-1)*Math.pow(1.13,(level-1)));
                break;
            case LEGENDARY:
                strength = (int) Math.ceil((19)*Math.pow(1.13,(level-1)) + ((Math.random()*3)-1)*Math.pow(1.13,(level-1)));
                break;
        }
        // weapon = new ...; weapon.set...
    }

    protected void loadWeaponData() {}

    public ItemStack getWeapon() {
        return weapon;
    }
}