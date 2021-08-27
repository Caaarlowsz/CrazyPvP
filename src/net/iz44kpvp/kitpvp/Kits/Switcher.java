package net.iz44kpvp.kitpvp.Kits;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Switcher implements Listener {
	@EventHandler
	public void snowball(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Snowball && e.getEntity() instanceof Player) {
			final Snowball s = (Snowball) e.getDamager();
			if (s.getShooter() instanceof Player) {
				final Player shooter = (Player) s.getShooter();
				if (Habilidade.getAbility(shooter).equalsIgnoreCase("Switcher")) {
					final Location shooterLoc = shooter.getLocation();
					shooter.teleport(e.getEntity().getLocation());
					e.getEntity().teleport(shooterLoc);
					shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
					shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
					shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
				}
			}
		}
	}

	@EventHandler
	public void aomatar(final PlayerDeathEvent e) {
		final Player matou = e.getEntity().getKiller();
		if (e.getEntity().getKiller() instanceof Player && Habilidade.getAbility(matou).equalsIgnoreCase("Switcher")) {
			final ItemStack item = new ItemStack(Material.SNOW_BALL);
			final ItemMeta itemm = item.getItemMeta();
			itemm.setDisplayName("§7Kit §eSwitcher");
			item.setItemMeta(itemm);
			matou.getInventory().addItem(new ItemStack[] { item });
			matou.updateInventory();
		}
	}
}
