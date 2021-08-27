package net.iz44kpvp.kitpvp.Guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.iz44kpvp.kitpvp.Sistemas.API;

public class GuiWarps implements Listener {
	public static void GuiWarp(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 27, "§cWarps");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§7Vidro");
		vidro.setItemMeta(vidrom);
		inv.setItem(0, vidro);
		inv.setItem(1, vidro);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro);
		inv.setItem(4, vidro);
		inv.setItem(5, vidro);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro);
		inv.setItem(8, vidro);
		inv.setItem(9, vidro);
		API.darItemInv(inv, Material.BLAZE_ROD, 1, 0, "§e§l1v1", 9);
		API.darItemInv(inv, Material.LAVA_BUCKET, 1, 0, "§cLava Challenge", 10);
		API.darItemInv(inv, Material.GLASS, 1, 0, "§bFps", 11);
		API.darItemInv(inv, Material.DIAMOND_CHESTPLATE, 1, 0, "§eMain", 12);
		API.darItemInv(inv, Material.STICK, 1, 0, "§aKnock", 13);
		API.darItemInv(inv, Material.CAKE, 1, 0, "§6M\u00e3e Da Rua", 14);
		API.darItemInv(inv, Material.GOLD_SWORD, 1, 0, "§3Rei Da Mesa", 15);
		API.darItemInv(inv, Material.DRAGON_EGG, 1, 0, "§dSpawn", 16);
		inv.setItem(17, vidro);
		inv.setItem(18, vidro);
		inv.setItem(19, vidro);
		inv.setItem(20, vidro);
		inv.setItem(21, vidro);
		inv.setItem(22, vidro);
		inv.setItem(23, vidro);
		inv.setItem(24, vidro);
		inv.setItem(25, vidro);
		inv.setItem(26, vidro);
		p.openInventory(inv);
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§cWarps") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
				e.setCancelled(true);
				Bukkit.dispatchCommand((CommandSender) p, "warp challenge");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GLASS) {
				e.setCancelled(true);
				Bukkit.dispatchCommand((CommandSender) p, "warp fps");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				e.setCancelled(true);
				Bukkit.dispatchCommand((CommandSender) p, "warp main");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STICK) {
				e.setCancelled(true);
				Bukkit.dispatchCommand((CommandSender) p, "warp knock");
				return;
			}
			if (e.getCurrentItem().getType() == Material.CAKE) {
				e.setCancelled(true);
				Bukkit.dispatchCommand((CommandSender) p, "warp mdr");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_SWORD) {
				e.setCancelled(true);
				Bukkit.dispatchCommand((CommandSender) p, "warp rdm");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DRAGON_EGG) {
				e.setCancelled(true);
				Bukkit.dispatchCommand((CommandSender) p, "warp spawn");
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				Bukkit.dispatchCommand((CommandSender) p, "1v1");
			}
		}
	}
}
