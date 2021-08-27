package net.iz44kpvp.kitpvp.Sistemas;

import java.util.*;
import org.bukkit.block.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

public class BlocosJump implements Listener
{
    public static ArrayList<String> naotomardanoqueda;
    
    static {
        BlocosJump.naotomardanoqueda = new ArrayList<String>();
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void aoBlocoJump(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) {
            BlocosJump.naotomardanoqueda.add(p.getName());
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector v = p.getVelocity().setY(4).multiply(2);
            p.setVelocity(v);
            p.playSound(loc, Sound.ENDERMAN_TELEPORT, 6.0f, 1.0f);
            p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, (Object)null);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    BlocosJump.naotomardanoqueda.remove(p.getName());
                }
            }, 100L);
        }
    }
    
    @EventHandler
    public void aoCair(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && BlocosJump.naotomardanoqueda.contains(p.getName())) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void aoMorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (BlocosJump.naotomardanoqueda.contains(p.getName())) {
            BlocosJump.naotomardanoqueda.remove(p.getName());
        }
    }
    
    @EventHandler
    public void aoSair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (BlocosJump.naotomardanoqueda.contains(p.getName())) {
            BlocosJump.naotomardanoqueda.remove(p.getName());
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void aoBlocoJumpPraFrente(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COAL) {
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector v = p.getLocation().getDirection().multiply(4).setY(1);
            p.setVelocity(v);
            p.playSound(loc, Sound.HORSE_JUMP, 6.0f, 1.0f);
            p.playEffect(loc, Effect.MAGIC_CRIT, (Object)null);
        }
    }
}
