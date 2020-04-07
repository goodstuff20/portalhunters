package com.portalhunters.weapons;

import com.portalhunters.PortalHunters;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.math.*;
import java.util.Arrays;
import java.util.Random;

public class Weapon {
    protected ItemStack weapon; //= new ItemStack(Material.BOW, 1);
    protected Rarity rarity;
    protected Material material;
    protected int strength, attackspeed; // + elementschaden?
    protected boolean doublehand;
    protected String title;
    // effect?
    
    // TODO add item properties, e.g.: protected int strength;

    public Weapon(Material material, int level, Rarity r, WeaponType weaponType) {
        this(material, level, r, null, weaponType);
    }

    public Weapon(Material material, int level, Rarity r, String title) {
        this(material, level, r, title, null);
    }

    private Weapon(Material material, int level, Rarity r, String title, WeaponType weaponType) {
    	this.rarity = r;
        this.material = material;
        this.title = title;
        if(title == null)
            this.title = randomWeaponName(weaponType);
        System.out.println("title = " + this.title);
        generateWeaponStats(level);
        generateItemStack();
    }
    
    public String randomWeaponName(WeaponType weaponType){
        String path = "weapons.";
        switch(weaponType){
            case AXE: path = path + "axe"; break;
            case DAGGER: path = path + "dagger"; break;
            case KATANA: path = path + "katana"; break;
            case LONG_SWORD: path = path + "longsword"; break;
            case SPEAR: path = path + "spear"; break;
            default: System.out.println("Error!"); return null;
        }
        System.out.println("path = " + path);
        return PortalHunters.names.getStringList(path).get(new Random().nextInt(PortalHunters.names.getStringList(path).size())); //TODO if called often, use global vars
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

    public boolean getDoubleHand() {
        return this.doublehand;
    }
}