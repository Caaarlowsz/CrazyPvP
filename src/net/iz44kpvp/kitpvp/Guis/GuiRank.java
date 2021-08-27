package net.iz44kpvp.kitpvp.Guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.KillsDeathsRankXp;

public class GuiRank implements Listener {
	public static void GuiRanks(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 36, "§bRanks");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§7VIDRO");
		vidro.setItemMeta(vidrom);
		final ItemStack ruby = new ItemStack(Material.INK_SACK, 1, (short) 1);
		final ItemMeta rubym = ruby.getItemMeta();
		rubym.setDisplayName("§cRuby");
		ruby.setItemMeta(rubym);
		final ItemStack papel = new ItemStack(Material.PAPER);
		final ItemMeta papelm = papel.getItemMeta();
		papelm.setDisplayName("§6Informa\u00e7\u00f5es");
		final ArrayList<String> paperdesc = new ArrayList<String>();
		paperdesc.add("§7Rank: §6" + KillsDeathsRankXp.getRank(p));
		paperdesc.add("§7Xp: §6" + KillsDeathsRankXp.getXp(p));
		paperdesc.add("§7Caixa(s): §6" + KillsDeathsRankXp.getCaixa(p));
		paperdesc.add("§7Kills: §6" + KillsDeathsRankXp.getKills(p));
		paperdesc.add("§7Deaths: §6" + KillsDeathsRankXp.getDeaths(p));
		papelm.setLore(paperdesc);
		papel.setItemMeta(papelm);
		inv.setItem(0, vidro);
		inv.setItem(1, vidro);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro);
		inv.setItem(4, papel);
		inv.setItem(5, vidro);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro);
		inv.setItem(8, vidro);
		inv.setItem(9, vidro);
		API.darItemInv(inv, Material.getMaterial(336), 1, 0, "§aBronze", 10);
		API.darItemInv(inv, Material.getMaterial(405), 1, 0, "§7Silver", 11);
		API.darItemInv(inv, Material.GOLD_INGOT, 1, 0, "§eGold", 12);
		inv.setItem(13, vidro);
		API.darItemInv(inv, Material.DIAMOND, 1, 0, "§bDiamond", 14);
		API.darItemInv(inv, Material.EMERALD, 1, 0, "§6Emerald", 15);
		inv.setItem(16, ruby);
		inv.setItem(17, vidro);
		inv.setItem(18, vidro);
		API.darItemInv(inv, Material.INK_SACK, 1, 8, "§f75 a 180", 19);
		API.darItemInv(inv, Material.INK_SACK, 1, 8, "§f200 a 280", 20);
		API.darItemInv(inv, Material.INK_SACK, 1, 8, "§f300 a 380", 21);
		inv.setItem(22, vidro);
		API.darItemInv(inv, Material.INK_SACK, 1, 8, "§f400 a 480", 23);
		API.darItemInv(inv, Material.INK_SACK, 1, 8, "§f500 a 580", 24);
		API.darItemInv(inv, Material.INK_SACK, 1, 8, "§f600", 25);
		inv.setItem(26, vidro);
		inv.setItem(27, vidro);
		inv.setItem(28, vidro);
		inv.setItem(29, vidro);
		inv.setItem(30, vidro);
		inv.setItem(31, vidro);
		inv.setItem(32, vidro);
		inv.setItem(33, vidro);
		inv.setItem(34, vidro);
		inv.setItem(35, vidro);
		p.openInventory(inv);
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		if (e.getInventory().getTitle().equalsIgnoreCase("§bRanks") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.PAPER) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(336)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(405)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(226)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(264)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(388)) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.getMaterial(351)) {
				e.setCancelled(true);
			}
		}
	}
}
