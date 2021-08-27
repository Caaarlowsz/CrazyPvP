package net.iz44kpvp.kitpvp.Kits2;

import org.bukkit.event.player.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class Hulk implements Listener
{
    @EventHandler
    public void PickUpPlayer(final PlayerInteractEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player)) {
            return;
        }
        if (e.getRightClicked() instanceof Player) {
            final Player p = e.getPlayer();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Hulk")) {
                final Player r = (Player)e.getRightClicked();
                if (Cooldown.add(p)) {
                    API.MensagemCooldown(p);
                    return;
                }
                if (p.getItemInHand().getType() != Material.AIR) {
                    return;
                }
                if (p.getPassenger() != null) {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Ja tem alguem, espere ele sair!");
                    return;
                }
                if (r.getPassenger() != null) {
                    return;
                }
                Cooldown.add(p, 6);
                p.setPassenger((Entity)r);
                r.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Um hulk te prendeu, aperte shift para fugir");
            }
        }
    }
}
