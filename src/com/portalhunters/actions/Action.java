package com.portalhunters.actions;

import org.bukkit.entity.Player;

/**
 * An abstract class representing any kind of action
 * This includes skill-based actions, such as a buff, as well as spells
 * actions can have schedulers inside the method, they should then self-close/-dispose after the goal or timelimit has been reached
 */
public abstract class Action {
    public abstract void performPlayerAction(Player caster);
}
