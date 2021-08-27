package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.event.*;

public class Teleporter implements Listener
{
    @EventHandler
    public void AoTeleport(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow && ((Arrow)e.getDamager()).getShooter() instanceof Player) {
            final Arrow arrow = (Arrow)e.getDamager();
            final Player p = (Player)arrow.getShooter();
            p.getLocation().distance(e.getEntity().getLocation());
            if (e.getEntity() instanceof Player && Habilidade.getAbility(p).equalsIgnoreCase("Teleporter")) {
                p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
                p.teleport(e.getEntity().getLocation());
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea teleportou para: §b" + ((Player)e.getEntity()).getName());
            }
        }
    }
}
