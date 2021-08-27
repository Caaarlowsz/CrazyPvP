package net.iz44kpvp.kitpvp.Kits2;

import org.bukkit.event.block.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.plugin.*;
import org.bukkit.util.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import java.util.*;

public class DeshIce_DeshFire implements Listener
{
    public static ArrayList<Player> congelou;
    public static ArrayList<Player> deshiceplayer;
    public static ArrayList<Player> fogo;
    public static ArrayList<Player> deshfireplayer;
    
    static {
        DeshIce_DeshFire.congelou = new ArrayList<Player>();
        DeshIce_DeshFire.deshiceplayer = new ArrayList<Player>();
        DeshIce_DeshFire.fogo = new ArrayList<Player>();
        DeshIce_DeshFire.deshfireplayer = new ArrayList<Player>();
    }
    
    @EventHandler
    public void aodeshice(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("DeshIce") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.SNOW_BLOCK) {
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 15);
            final Vector vecfrente = p.getLocation().getDirection().multiply(3);
            p.setVelocity(vecfrente);
            p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, 0.0), Effect.STEP_SOUND, (Object)Material.PACKED_ICE, 15);
            p.getWorld().playEffect(p.getLocation().add(-0.0, 0.0, 0.0), Effect.STEP_SOUND, (Object)Material.PACKED_ICE, 15);
            p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, -0.0), Effect.STEP_SOUND, (Object)Material.PACKED_ICE, 15);
            p.getWorld().playEffect(p.getLocation().add(-0.0, 0.0, -0.0), Effect.STEP_SOUND, (Object)Material.PACKED_ICE, 15);
            p.getWorld().playEffect(p.getLocation().add(-1.0, 0.0, 0.0), Effect.STEP_SOUND, (Object)Material.PACKED_ICE, 15);
            p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, -1.0), Effect.STEP_SOUND, (Object)Material.PACKED_ICE, 15);
            p.getWorld().playEffect(p.getLocation().add(-1.0, 0.0, -1.0), Effect.STEP_SOUND, (Object)Material.PACKED_ICE, 15);
            DeshIce_DeshFire.deshiceplayer.add(p);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    DeshIce_DeshFire.deshiceplayer.remove(p);
                }
            }, 100L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 300L);
        }
    }
    
    @EventHandler
    public void aomover(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (DeshIce_DeshFire.congelou.contains(p)) {
            p.teleport((Entity)p);
        }
        if (DeshIce_DeshFire.deshiceplayer.contains(p)) {
            for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
                DeshIce_DeshFire.congelou.add((Player)pertos);
                ((Player)pertos).sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00eas foram congelados por um §bDeshIce");
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        DeshIce_DeshFire.congelou.remove(pertos);
                        ((Player)pertos).sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00eas foram descongelados");
                    }
                }, 100L);
            }
        }
    }
    
    @EventHandler
    public void aodeshfire(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("DeshFire") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.REDSTONE_BLOCK) {
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 15);
            final Vector vecfrente = p.getLocation().getDirection().multiply(3);
            p.setVelocity(vecfrente);
            p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, 0.0), Effect.MOBSPAWNER_FLAMES, 15);
            p.getWorld().playEffect(p.getLocation().add(-0.0, 0.0, 0.0), Effect.MOBSPAWNER_FLAMES, 15);
            p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, -0.0), Effect.MOBSPAWNER_FLAMES, 15);
            p.getWorld().playEffect(p.getLocation().add(-0.0, 0.0, -0.0), Effect.MOBSPAWNER_FLAMES, 15);
            p.getWorld().playEffect(p.getLocation().add(-1.0, 0.0, 0.0), Effect.MOBSPAWNER_FLAMES, 15);
            p.getWorld().playEffect(p.getLocation().add(0.0, 0.0, -1.0), Effect.MOBSPAWNER_FLAMES, 15);
            p.getWorld().playEffect(p.getLocation().add(-1.0, 0.0, -1.0), Effect.MOBSPAWNER_FLAMES, 15);
            DeshIce_DeshFire.deshfireplayer.add(p);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    DeshIce_DeshFire.deshfireplayer.remove(p);
                }
            }, 100L);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 300L);
        }
    }
    
    @EventHandler
    public void aomoverfire(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (DeshIce_DeshFire.deshfireplayer.contains(p)) {
            for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
                ((Player)pertos).sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00eas foram atingidos por um §cDeshFire");
                pertos.setFireTicks(100);
            }
        }
    }
}
