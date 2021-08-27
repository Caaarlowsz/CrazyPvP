package net.iz44kpvp.kitpvp.Kits2;

import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class Resouper implements Listener
{
    @EventHandler
    public void aomatar(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            final Player p = e.getEntity().getKiller();
            if (Habilidade.getAbility(p).equalsIgnoreCase("Resouper")) {
                for (int i = 0; i < p.getInventory().getSize(); ++i) {
                    p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
                    p.updateInventory();
                }
            }
        }
    }
}
