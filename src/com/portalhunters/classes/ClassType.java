package com.portalhunters.classes;

import com.portalhunters.weapons.Weapon;
import com.portalhunters.weapons.WeaponType;

public enum ClassType {
    // knight subclasses
    KNIGHT{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.SPEAR, WeaponType.SWORD, WeaponType.LONG_SWORD};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.LONG_SWORD};
        }
    },
    MAGE{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{};
        }
    },
    ARCHER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.BOW};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{};
        }
    },
    TANK{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.SHIELD, WeaponType.SWORD};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.SHIELD};
        }
    },
    JOUST{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.SPEAR, WeaponType.SWORD};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.SPEAR};
        }
    },
    SAMURAI{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.KATANA, WeaponType.SWORD};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.KATANA};
        }
    },
    BERSERKER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.AXE, WeaponType.SWORD};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.AXE};
        }
    },
    ASSASSIN{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.DAGGER, WeaponType.SWORD};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.DAGGER};
        }
    },
    // Mage subclasses
    NECROMANCER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{};
        }
    },
    ELEMENTALIST{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{};
        }
    },
    HEALER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{};
        }
    },
    DRUID{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{};
        }
    },
    // Archer subclasses
    MARKSMAN{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.BOW, WeaponType.LONG_BOW};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.LONG_BOW};
        }
    },
    HUNTER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.BOW, WeaponType.TACTICAL_BOW};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.TACTICAL_BOW};
        }
    },
    GUNSLINGER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.GUN};
        }
        @Override
        public WeaponType[] specializedWeapons() {
            return new WeaponType[]{WeaponType.GUN};
        }
    };

    public abstract WeaponType[] allowedWeapons();
    public abstract WeaponType[] specializedWeapons();
}
