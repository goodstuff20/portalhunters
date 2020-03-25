package com.portalhunters.classes;

import com.portalhunters.weapons.WeaponType;

import java.util.Map;

public class ClassManager {

    private Map<String, WeaponType> allowedWeapons;
    private Map<String, SkillTree> skillTrees;
    //double baseDamage = 0d;
    //double baseSpeed = 0d;

    public ClassManager(){
        // TODO init this in main class / onEnable
        // TODO load from config...

        //if config is empty
        fillWithDefaults();
    }

    void fillWithDefaults(){
        for(ClassType type : ClassType.values()) {
            switch(type) {
                case ARCHER:
                    break;
                case MAGE:
                    break;
                case TANK:
                    break;
                case ASSASSIN:
                    break;
                case DRUID:
                    break;
                case BERSERKER:
                    break;
                case JOUST:
                    break;
                case HEALER:
                    break;
                case HUNTER:
                    break;
                case KNIGHT:
                    break;
                case SAMURAI:
                    break;
                case MARKSMAN:
                    break;
                case GUNSLINGER:
                    break;
                case NECROMANCER:
                    break;
                case ELEMENTALIST:
                    break;
            }
        }
    }


}
