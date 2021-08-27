package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.player.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;

public class Rain implements Listener
{
    @EventHandler
    public void onCage(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        final Player p = e.getPlayer();
        final Player t = (Player)e.getRightClicked();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Rain") && p.getItemInHand().getType() == Material.NETHER_STAR) {
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 25);
            final Location loc = t.getLocation();
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 0L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 10L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 15L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 20L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 25L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 30L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.shootArrow();
                    loc.setY(loc.getY() + 1.0);
                    final Entity r = t.getWorld().spawnEntity(loc, EntityType.ARROW);
                    r.setVelocity(r.getVelocity().multiply(8));
                }
            }, 35L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 500L);
        }
    }
}
