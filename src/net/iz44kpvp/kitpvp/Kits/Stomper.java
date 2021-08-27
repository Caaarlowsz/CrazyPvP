package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import java.util.*;
import net.minecraft.server.v1_7_R4.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.util.*;

public class Stomper implements Listener
{
    @EventHandler
    public void aostomper(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            event.getDamage();
            return;
        }
        if (!Habilidade.getAbility(player).equalsIgnoreCase("Stomper")) {
            return;
        }
        if (event.getDamage() > 4.0) {
            event.setDamage(4.0);
        }
        for (final Entity stomped : player.getNearbyEntities(5.0, 5.0, 5.0)) {
            if (!(stomped instanceof Player)) {
                return;
            }
            if (!((Player)stomped).isSneaking()) {
                final Player st = (Player)stomped;
                if (!Habilidade.getAbility(st).equalsIgnoreCase("AntiStomper")) {
                    st.damage((double)player.getFallDistance(), (Entity)player);
                }
                else {
                    st.sendMessage("§7Voc\u00ea foi protegido da stompada com seu kit");
                }
                final EntityPlayer p = ((CraftPlayer)st).getHandle();
                if (p.getHealth() - player.getFallDistance() >= 1.0f) {
                    continue;
                }
                final Location loc = player.getLocation();
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -5.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -3.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -1.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 1.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 3.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 5.0f);
            }
            else {
                ((Player)stomped).damage((double)(player.getFallDistance() / 3.0f), (Entity)player);
                final Player st = (Player)stomped;
                final EntityPlayer p = ((CraftPlayer)st).getHandle();
                if (p.getHealth() - player.getFallDistance() / 4.0f >= 1.0f) {
                    continue;
                }
                final Location loc = player.getLocation();
                player.getWorld().playEffect(player.getLocation().add(0.0, 0.0, 0.0), Effect.WATERDRIP, 30);
                player.getWorld().playEffect(player.getLocation().add(-0.0, 0.0, 0.0), Effect.WATERDRIP, 30);
                player.getWorld().playEffect(player.getLocation().add(0.0, 0.0, -0.0), Effect.WATERDRIP, 30);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -5.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -3.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, -1.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 1.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 3.0f);
                player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0f, 5.0f);
            }
        }
    }
    
    @EventHandler
    public void BotaStomper(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE && Habilidade.getAbility(p).equalsIgnoreCase("Stomper") && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)) {
            e.setCancelled(true);
            p.updateInventory();
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            final Vector vector = p.getEyeLocation().getDirection();
            vector.multiply(0.0f);
            vector.setY(10.0f);
            p.setVelocity(vector);
            final Location loc = p.getLocation();
            p.getWorld().playSound(loc, Sound.FIREWORK_BLAST2, 2.0f, 2.0f);
            Cooldown.add(p, 30);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 600L);
        }
    }
}
