package net.iz44kpvp.kitpvp.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.confuser.barapi.BarAPI;
import net.iz44kpvp.kitpvp.Sistemas.API;

public class BarKit implements Listener {
	@EventHandler
	public void aoBaterKit(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		BarAPI.setMessage(p, "§f" + t.getName() + " §7\u27a1 Kit: §5" + API.getKit(t), 2);
	}
}
