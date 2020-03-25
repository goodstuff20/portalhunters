package com.portalhunters.classes;

import com.portalhunters.weapons.Weapon;
import com.portalhunters.weapons.WeaponType;

public enum ClassType {
    // knight subclasses
    KNIGHT{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.SPEAR, WeaponType.SWORD};
        }
    },
    MAGE{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
    },
    ARCHER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.BOW};
        }
    },
    TANK{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.SHIELD, WeaponType.SWORD};
        }
    },
    JOUST{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.SPEAR};
        }
    },
    SAMURAI{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.KATANA};
        }
    },
    BERSERKER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.DAGGER};
        }
    },
    ASSASSIN{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.DAGGER};
        }
    },
    // Mage subclasses
    NECROMANCER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
    },
    ELEMENTALIST{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
    },
    HEALER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
    },
    DRUID{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.STAFF};
        }
    },
    // Archer subclasses
    MARKSMAN{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.LONG_BOW};
        }
    },
    HUNTER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.BOW, WeaponType.TACTICAL_BOW};
        }
    },
    GUNSLINGER{
        @Override
        public WeaponType[] allowedWeapons() {
            return new WeaponType[]{WeaponType.GUN};
        }
    };

    public abstract WeaponType[] allowedWeapons();
}
