package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.event.entity.*;
import java.util.*;

public class Magma implements Listener
{
    @EventHandler
    public void damage(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Magma") && (e.getCause() == EntityDamageEvent.DamageCause.LAVA || e.getCause() == EntityDamageEvent.DamageCause.FIRE || e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void aoPassar(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Material block = p.getLocation().getBlock().getType();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Magma") && (block == Material.STATIONARY_WATER || block == Material.WATER)) {
            p.damage(1.0);
        }
    }
    
    @EventHandler
    public void Fogo(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        final Player s = (Player)e.getDamager();
        if (Habilidade.getAbility(s).equalsIgnoreCase("Magma") && s.getInventory().getItemInHand() != null) {
            final Random rand = new Random();
            final int percent = rand.nextInt(100);
            if (percent <= 33) {
                p.setFireTicks(50);
            }
        }
    }
}
