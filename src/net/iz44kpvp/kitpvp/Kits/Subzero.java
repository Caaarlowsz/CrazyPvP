package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Subzero implements Listener {
	public static ArrayList<String> congelado;

	static {
		Subzero.congelado = new ArrayList<String>();
	}

	@EventHandler
	public void ar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Subzero")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.PACKED_ICE) {
			e.setCancelled(true);
			p.updateInventory();
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			Cooldown.add(p, 30);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 600L);
			final Location loc = p.getEyeLocation();
			final BlockIterator blocos = new BlockIterator(loc, 0.0, 40);
			while (blocos.hasNext()) {
				final Location bloco = blocos.next().getLocation();
				p.playSound(bloco, Sound.ITEM_PICKUP, 1.0f, 1.0f);
				p.getWorld().playEffect(bloco, Effect.STEP_SOUND, (Object) Material.PACKED_ICE, 15);
			}
			final Snowball h = (Snowball) p.launchProjectile(Snowball.class);
			final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
			h.setVelocity(velo1);
			h.setMetadata("icew", (MetadataValue) new FixedMetadataValue((Plugin) Main.getInstance(), (Object) true));
		}
	}

	@EventHandler
	public void aoDanoIceWizard(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
			final Snowball s = (Snowball) e.getDamager();
			if (s.hasMetadata("icew")) {
				final Player p = (Player) e.getEntity();
				e.setDamage(e.getDamage() + 5.0);
				Subzero.congelado.add(p.getName());
				p.sendMessage("§7Voc\u00ea foi congelado por um Subzero");
				Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
					@Override
					public void run() {
						Subzero.congelado.remove(p.getName());
						p.sendMessage("§7Voc\u00ea foi descongelado");
					}
				}, 140L);
			}
		}
	}

	@EventHandler
	public void aoAndar(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (Subzero.congelado.contains(p.getName())) {
			e.setTo(p.getLocation());
			p.sendMessage("§7Voc\u00ea est\u00e1 congelado por um Subzero");
		}
	}
}
