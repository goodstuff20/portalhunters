package com.portalhunters.listeners;

import com.portalhunters.actions.FireSpell;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerListener implements Listener {

    @EventHandler
    public void ShootSpell(PlayerInteractEvent e) {
        if (e.getHand() == EquipmentSlot.OFF_HAND) {
            return;
        }
        Player p = e.getPlayer();

        if(p.getInventory().getItemInMainHand().getType() == Material.STICK) {
            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                FireSpell spell = new FireSpell();
                spell.performPlayerAction(e.getPlayer());
                p.sendMessage("shot fireball!");
            }
        }
    }

}
