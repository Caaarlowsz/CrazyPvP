package net.iz44kpvp.kitpvp.Guis;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.KillsDeathsRankXp;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class GuiCaixa implements Listener {
	private static HashMap<String, String> kitsorteado;

	static {
		GuiCaixa.kitsorteado = new HashMap<String, String>();
	}

	public static void GuiCaixas(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 9, "§bSorteador");
		final ItemStack vidrob = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
		final ItemStack vidror = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 2);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(0, vidrob);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 10L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(1, vidror);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 15L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(2, vidrob);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 20L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(3, vidror);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 25L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(4, vidrob);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 30L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(5, vidror);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 35L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(6, vidrob);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 40L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(7, vidror);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 45L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				inv.setItem(8, vidrob);
				p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
			}
		}, 50L);
		Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance, (Runnable) new Runnable() {
			@Override
			public void run() {
				final int r = new Random().nextInt(3);
				if (r == 0) {
					SortearKit(inv, p, "IronMan", Material.IRON_INGOT);
				}
				if (r == 1) {
					SortearKit(inv, p, "QuickDropper", Material.BOWL);
				}
				if (r == 2) {
					SortearKit(inv, p, "Trader", Material.EMERALD);
				}
				if (r == 3) {
					SortearKit(inv, p, "Teleporter", Material.BOW);
				}
				if (r == 4) {
					SortearKit(inv, p, "Anchor", Material.ANVIL);
				}
				if (r == 5) {
					SortearKit(inv, p, "HotPotato", Material.BAKED_POTATO);
				}
			}
		}, 55L);
		p.openInventory(inv);
	}

	private static void SortearKit(final Inventory inv, final Player p, final String kit, final Material mat) {
		GuiCaixa.kitsorteado.put(p.getName(), kit);
		final ItemStack item = new ItemStack(mat);
		final ItemMeta itemm = item.getItemMeta();
		itemm.setDisplayName("§7Kit §e" + GuiCaixa.kitsorteado.get(p.getName()));
		item.setItemMeta(itemm);
		if (!p.hasPermission("kit." + kit)) {
			PermissionsEx.getUser(p.getName()).addPermission("kit." + kit);
			p.sendMessage("§7Voc\u00ea ganhou o kit: §e" + GuiCaixa.kitsorteado.get(p.getName()));
			inv.setItem(4, item);
			GuiCaixa.kitsorteado.remove(p.getName());
			API.playFirework(p.getLocation(), Color.AQUA, p);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.closeInventory();
					EventosGuis.aocaixa.remove(p.getName());
				}
			}, 65L);
		} else {
			p.sendMessage("§7Voc\u00ea j\u00e1 possui o kit ganho em recompensa voc\u00ea ira ganhar: §c500§7Xp");
			KillsDeathsRankXp.adicionarXp(p, 500);
			GuiCaixa.kitsorteado.remove(p.getName());
			API.playFirework(p.getLocation(), Color.AQUA, p);
			final ItemStack item2 = new ItemStack(Material.EXP_BOTTLE);
			final ItemMeta itemm2 = item2.getItemMeta();
			itemm2.setDisplayName("§7Xp §e500");
			item2.setItemMeta(itemm2);
			inv.setItem(4, item2);
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) Main.getInstance(), (Runnable) new Runnable() {
				@Override
				public void run() {
					p.closeInventory();
					EventosGuis.aocaixa.remove(p.getName());
				}
			}, 65L);
		}
	}

	@EventHandler
	public void aoMecher(final InventoryClickEvent e) {
		if (e.getInventory().getTitle().equalsIgnoreCase("§bSorteador") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
		}
	}
}
