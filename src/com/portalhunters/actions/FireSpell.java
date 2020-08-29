package com.portalhunters.actions;

import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

public class FireSpell extends Action {
    @Override
    public void performPlayerAction(Player caster) {
        Location loc = caster.getEyeLocation().toVector().add(caster.getLocation().getDirection().multiply(2)).toLocation(caster.getWorld(), caster.getLocation().getYaw(), caster.getLocation().getPitch());
        Fireball fireball = caster.getWorld().spawn(loc, Fireball.class);
    }
}
