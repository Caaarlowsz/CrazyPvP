package net.iz44kpvp.kitpvp.Kits;

import net.iz44kpvp.kitpvp.Eventos.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.event.block.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;

public class Kangaroo extends CombatLog implements Listener
{
    public static ArrayList<Player> kanga;
    
    static {
        Kangaroo.kanga = new ArrayList<Player>();
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Kangaroo")) {
            if (p.getItemInHand().getType() == Material.FIREWORK && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) && CombatLog.emCombate(p)) {
                event.setCancelled(true);
                p.sendMessage(API.bloquearpvp);
                return;
            }
            if (p.getItemInHand().getType() == Material.FIREWORK && (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)) {
                event.setCancelled(true);
                if (!Kangaroo.kanga.contains(p)) {
                    if (!p.isSneaking()) {
                        p.setFallDistance(-3.0f);
                        final Vector vector = p.getEyeLocation().getDirection();
                        vector.multiply(0.6f);
                        vector.setY(1.0f);
                        p.setVelocity(vector);
                    }
                    else {
                        p.setFallDistance(-3.0f);
                        final Vector vector = p.getEyeLocation().getDirection();
                        vector.multiply(1.35f);
                        vector.setY(0.66);
                        p.setVelocity(vector);
                    }
                    Kangaroo.kanga.add(p);
                }
            }
        }
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (Kangaroo.kanga.contains(p)) {
            final Block b = p.getLocation().getBlock();
            if (b.getType() != Material.AIR || b.getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                Kangaroo.kanga.remove(p);
            }
        }
    }
    
    @EventHandler
    public void onDamage(final EntityDamageEvent event) {
        final Entity e = event.getEntity();
        if (e instanceof Player) {
            final Player player = (Player)e;
            if (Habilidade.getAbility(player).equalsIgnoreCase("Kangaroo") && event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getInventory().contains(Material.FIREWORK)) {
                event.setDamage(2.0);
            }
        }
    }
}