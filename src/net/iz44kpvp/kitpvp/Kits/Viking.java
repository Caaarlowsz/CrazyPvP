package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Viking implements Listener
{
    @EventHandler
    public void aoviking(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getDamager();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Viking") && e.getEntity() instanceof Player && p.getItemInHand().getType() == Material.STONE_AXE) {
                e.setDamage(e.getDamage() * 1.66);
            }
        }
    }
}
