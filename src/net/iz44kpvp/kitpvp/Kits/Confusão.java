package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;

public class Confus\u00e3o implements Listener
{
    @EventHandler
    public void onConfusao(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Confus\u00e3o") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.ENDER_PEARL) {
            e.setCancelled(true);
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            Cooldown.add(p, 40);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2));
            for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
                ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 0));
                ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
                ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0));
                ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 800L);
        }
    }
}
