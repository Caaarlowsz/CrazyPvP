package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.potion.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class Poseidon implements Listener
{
    @EventHandler
    public void aoPoseidon(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        final Block b = p.getLocation().getBlock();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Poseidon") && (b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)) {
            API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
            API.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 10, 1);
            API.darEfeito(p, PotionEffectType.SPEED, 8, 0);
        }
    }
}
