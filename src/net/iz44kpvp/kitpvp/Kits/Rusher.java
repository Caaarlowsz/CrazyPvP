package net.iz44kpvp.kitpvp.Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Rusher implements Listener {
	public static HashMap<String, ItemStack[]> salvararmor;

	static {
		Rusher.salvararmor = new HashMap<String, ItemStack[]>();
	}

	public static ItemStack darArmaduraI(final Material material) {
		final ItemStack item = new ItemStack(material);
		final ItemMeta itemm = item.getItemMeta();
		item.setItemMeta(itemm);
		return item;
	}

	@EventHandler
	public void aorusher(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("Rusher")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.IRON_INGOT) {
			if (Cooldown.add(p)) {
				API.MensagemCooldown(p);
				return;
			}
			Rusher.salvararmor.put(p.getName(), p.getInventory().getArmorContents());
			API.tirarArmadura(p);
			p.getInventory()
					.setArmorContents(new ItemStack[] { darArmaduraI(Material.IRON_HELMET),
							darArmaduraI(Material.IRON_CHESTPLATE), darArmaduraI(Material.IRON_LEGGINGS),
							darArmaduraI(Material.IRON_BOOTS) });
			p.updateInventory();
			Cooldown.add(p, 25);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					API.tirarArmadura(p);
					p.getInventory().setArmorContents((ItemStack[]) Rusher.salvararmor.get(p.getName()));
					Rusher.salvararmor.remove(p.getName());
					p.updateInventory();
				}
			}, 200L);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(API.fimcooldown);
				}
			}, 500L);
		}
	}

	@EventHandler
	public void aomecher(final InventoryClickEvent e) {
		try {
			final Player p = (Player) e.getWhoClicked();
			if (Rusher.salvararmor.containsKey(p.getName())
					&& e.getSlotType().equals((Object) InventoryType.SlotType.ARMOR)) {
				e.setCancelled(true);
			}
		} catch (Exception ex) {
		}
	}
}
