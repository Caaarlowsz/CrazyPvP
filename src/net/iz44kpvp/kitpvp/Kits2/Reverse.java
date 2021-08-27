package net.iz44kpvp.kitpvp.Kits2;

import java.util.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import java.text.*;
import org.bukkit.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

public class Reverse implements Listener
{
    public HashMap<Player, Player> ajinhash;
    public HashMap<Player, Long> ajincooldown;
    
    public Reverse() {
        this.ajinhash = new HashMap<Player, Player>();
        this.ajincooldown = new HashMap<Player, Long>();
    }
    
    @EventHandler
    public void a(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            final Player p = (Player)e.getDamager();
            final Player t = (Player)e.getEntity();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Reverse")) {
                this.ajinhash.put(p, t);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                    }
                }, 200L);
            }
        }
    }
    
    @EventHandler
    public void aPlayerToggle(final PlayerToggleSneakEvent e) {
        final Player p = e.getPlayer();
        if (Cooldown.add(p)) {
            API.MensagemCooldown(p);
            return;
        }
        if (e.isSneaking() && Habilidade.getAbility(p).equalsIgnoreCase("Reverse") && this.ajinhash.containsKey(p)) {
            final Player t = this.ajinhash.get(p);
            if (t != null && !t.isDead()) {
                String s = null;
                if (this.ajincooldown.get(p) != null) {
                    final long l = this.ajincooldown.get(p) - System.currentTimeMillis();
                    final DecimalFormat localDecimalFormat = new DecimalFormat("##");
                    final int i = (int)l / 1000;
                    s = localDecimalFormat.format(i);
                }
                if (p.getLocation().distance(t.getLocation()) < 200.0) {
                    final Location loc = p.getLocation();
                    final Location loc2 = t.getLocation();
                    t.teleport(loc);
                    p.teleport(loc2);
                    t.sendMessage(String.valueOf(p.getName()) + " §aTrocou De Lugar Com Voc\u00ea!");
                    p.sendMessage("§aVoc\u00ea trocou de lugar com " + t.getName());
                    Cooldown.add(p, 3);
                    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            p.sendMessage(API.fimcooldown);
                        }
                    }, 60L);
                }
                else {
                    p.sendMessage("§cO Ultimo jogador hitado esta muito longe!");
                }
            }
        }
    }
    
    @EventHandler
    public void aomorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        final Player t = this.ajinhash.get(p);
        this.ajinhash.remove(t);
        this.ajinhash.remove(p);
    }
    
    @EventHandler
    public void aosair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        final Player t = this.ajinhash.get(p);
        this.ajinhash.remove(t);
        this.ajinhash.remove(p);
    }
}
