package com.portalhunters.actions.spells;

import com.portalhunters.actions.Action;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class Spell extends Action {

    @Override
    public void trigger(Player caster) {
        performPlayerAction(caster);
    }

    public abstract void performPlayerAction(Player caster);

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface SpellInfo {
        String name() default ""; // "" defaults to class name
        String description() default "";
        int range() default 25;
        boolean goThroughWalls() default false;
        int cooldown() default 60;
        Material icon() default Material.STICK;
    }

    /**
     * Gets the name of this spell.
     *
     * @return the spell's name
     */
    public String getName() {
        SpellInfo info = this.getClass().getAnnotation(SpellInfo.class);
        return info == null ? this.getClass().getSimpleName() : info.name();
    }

    /**
     * Gets the range of the spell.
     *
     * @return the range
     */
    public int getRange() {
        SpellInfo info = this.getClass().getAnnotation(SpellInfo.class);
        return info == null ? 25 : info.range();
    }

    /**
     * Gets whether the spell can be cast through walls.
     *
     * @return {@code true} if the spel can be cast through walls.
     */
    public boolean canBeCastThroughWalls() {
        SpellInfo info = this.getClass().getAnnotation(SpellInfo.class);
        return info == null ? false : info.goThroughWalls();
    }

    /**
     * Gets the icon for this spell.
     *
     * @return the icon as a {@link Material}
     */
    public Material getIcon() {
        SpellInfo info = this.getClass().getAnnotation(SpellInfo.class);
        return info == null ? Material.STICK : info.icon();
    }

}
