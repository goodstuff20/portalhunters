package com.portalhunters.weapons;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.*;
import java.util.Arrays;

public class Weapon {
    protected ItemStack weapon; //= new ItemStack(Material.BOW, 1);
    protected Rarity rarity;
    protected Material material;
    protected int strength, attackspeed; // + elementschaden?
    protected boolean doublehand;
    protected String title;
    // effect?
    
    // TODO add item properties, e.g.: protected int strength;

    public Weapon(Material material, int level, String title) {
        //TODO nur für die Schwert klasse für jetzt getan, soll das bleiben? Was für standard types?
        this(material, level, Rarity.COMMON, false, title);
    }

    public Weapon(Material material, int level, Rarity r, boolean doublehand, String title) {
    	this.rarity = r;
        this.material = material;
        this.doublehand = doublehand;
        this.title = title;
        generateWeaponStats(level);
        generateItemStack();
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

    protected void generateItemStack(){
        weapon = new ItemStack(this.material, 1);
        ItemMeta meta = weapon.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + title);  //TODO util method to change & § to colors
        meta.setLore(Arrays.asList(rarity == Rarity.COMMON ? rarity.toString() :
                rarity == Rarity.UNCOMMON ? ChatColor.AQUA +  rarity.toString() :
                rarity == Rarity.RARE ? ChatColor.RED +  rarity.toString() :
                ChatColor.GOLD + "" + ChatColor.BOLD + rarity.toString(), // LEGENDARY
                "",
                "Strength: " + strength,
                "Attack speed: " + attackspeed));
        weapon.setItemMeta(meta);
    }

    protected void loadWeaponData() {}

    public ItemStack getWeapon() {
        return weapon;
    }
}