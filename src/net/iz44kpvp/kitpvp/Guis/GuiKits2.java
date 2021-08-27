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

public class GuiKits2 implements Listener {
	public static void GuiKit2(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 54, "§cKits 2");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		final ItemMeta vidrom = vidro.getItemMeta();
		vidrom.setDisplayName("§7VIDRO");
		vidro.setItemMeta(vidrom);
		final ItemStack vidrov = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		final ItemMeta vidrovm = vidrov.getItemMeta();
		vidrovm.setDisplayName("§7VIDRO");
		vidrov.setItemMeta(vidrovm);
		final ItemStack vidror = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		final ItemMeta vidrorm = vidror.getItemMeta();
		vidrorm.setDisplayName("§7VIDRO");
		vidror.setItemMeta(vidrorm);
		final ItemStack vidrob = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
		final ItemMeta vidrobm = vidrob.getItemMeta();
		vidrobm.setDisplayName("§7VIDRO");
		vidrob.setItemMeta(vidrobm);
		final ItemStack carpet = new ItemStack(Material.CARPET, 1, (short) 14);
		final ItemMeta carpetm = carpet.getItemMeta();
		carpetm.setDisplayName("§cVoltar Pagina");
		carpet.setItemMeta(carpetm);
		inv.setItem(0, carpet);
		inv.setItem(1, vidro);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro);
		inv.setItem(4, vidro);
		inv.setItem(5, vidro);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro);
		inv.setItem(8, vidro);
		if (p.hasPermission("kit.ninja")) {
			final ItemStack pyro = new ItemStack(Material.COMPASS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eNinja");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao segurar shift teleporte ao ultimo player hitado");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.ajnin")) {
			final ItemStack pyro = new ItemStack(Material.NETHER_STAR);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eAjnin");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao segurar shift teleporte o ultimo player hitado para voc\u00ea");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.resouper")) {
			final ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eResouper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao matar o player tenha seu inventario repleto de sopas");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.pyro")) {
			final ItemStack pyro = new ItemStack(Material.FIREBALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §ePyro");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Solte bolas de fogo");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.nofall")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eNoFall");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7N\u00e3o tome dano de queda");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.viper")) {
			final ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eViper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao bater no player deixe ele envenenado");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.snail")) {
			final ItemStack pyro = new ItemStack(Material.SOUL_SAND);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eSnail");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao bater no player deixe ele lento");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.hulk")) {
			final ItemStack pyro = new ItemStack(Material.SADDLE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eHulk");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Segure os players em cima de voc\u00ea");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.deshice")) {
			final ItemStack pyro = new ItemStack(Material.SNOW_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eDeshIce");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Congele os players perto de voc\u00ea");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.deshfire")) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eDeshFire");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Deixe os players perto de voc\u00ea pegando fogo");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.hercules")) {
			final ItemStack pyro = new ItemStack(Material.BONE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eHercules");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Levante os players com sua for\u00e7a descomunal");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.reverse")) {
			final ItemStack pyro = new ItemStack(Material.ENDER_CHEST);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eReverse");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Troque de lugar com ultimo jogador hitado!");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		ItemStack[] arrayOfItemStack;
		for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length,
				metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
			final ItemStack item = arrayOfItemStack[metapyro2];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), vidrob);
			}
		}
		p.openInventory(inv);
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§cKits 2") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.CARPET) {
				e.setCancelled(true);
				GuiKits.GuiKit(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_STAR) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ajnin");
				return;
			}
			if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit resouper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREBALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pyro");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit nofall");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SOUL_SAND) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit snail");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SADDLE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hulk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshice");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshfire");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BONE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hercules");
			}
			if (e.getCurrentItem().getType() == Material.COMPASS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ninja");
			}
			if (e.getCurrentItem().getType() == Material.ENDER_CHEST) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit reverse");
			}
		}
	}
}
