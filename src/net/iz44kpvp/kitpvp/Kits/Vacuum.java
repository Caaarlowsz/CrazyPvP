package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.plugin.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.util.*;
import org.bukkit.event.*;

public class Vacuum implements Listener
{
    @EventHandler
    public void onVacuum(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Vacuum") && p.getItemInHand().getType().equals((Object)Material.EYE_OF_ENDER)) {
            for (final Entity nearby : p.getNearbyEntities(15.0, 15.0, 15.0)) {
                final Entity targetplayer = nearby;
                if (!(targetplayer instanceof Player)) {
                    return;
                }
                if (Cooldown.add(p)) {
                    API.MensagemCooldown(p);
                    return;
                }
                final Location lc = targetplayer.getLocation();
                final Location to = p.getLocation();
                lc.setY(lc.getY() + 0.5);
                final double g = -0.08;
                final double d;
                final double t = d = to.distance(lc);
                final double v_x = (1.0 + 0.17 * t) * (to.getX() - lc.getX()) / t;
                final double v_y = (1.0 + 0.03 * t) * (to.getY() - lc.getY()) / t - -0.04 * t;
                final double v_z = (1.0 + 0.17 * t) * (to.getZ() - lc.getZ()) / t;
                final Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                targetplayer.setVelocity(v);
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aAgora voce esta puxando os players em volta de vo\u00e7e");
                Cooldown.add(p, 15);
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        p.sendMessage(API.fimcooldown);
                    }
                }, 300L);
            }
        }
    }
}
