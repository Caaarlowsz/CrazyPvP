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

public class GuiLoja implements Listener {
	public static String semxp;

	static {
		GuiLoja.semxp = String.valueOf(String.valueOf(API.preffix)) + "§cVoc\u00ea n\u00e3o tem xp suficiente";
	}

	public static void GuiLojaKit(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 27, "§cLoja De Kit");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE);
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
		if (!p.hasPermission("kit.gaara")) {
			final ItemStack gaara = new ItemStack(Material.SAND);
			final ItemMeta gaaram = gaara.getItemMeta();
			gaaram.setDisplayName("§7Kit §eGaara");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§a§lPre\u00e7o: §e§l15.000XP");
			desc.add("§7§lPrenda os players no caix\u00e3o de areia");
			gaaram.setLore(desc);
			gaara.setItemMeta(gaaram);
			inv.setItem(9, gaara);
		} else if (p.hasPermission("kit.gaara")) {
			final ItemStack gaara = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			final ItemMeta gaaram = gaara.getItemMeta();
			gaaram.setDisplayName("§7Kit §cGaara");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
			gaaram.setLore(desc);
			gaara.setItemMeta(gaaram);
			inv.setItem(9, gaara);
		}
		inv.setItem(10, vidro);
		if (!p.hasPermission("kit.magma")) {
			final ItemStack magma = new ItemStack(Material.LAVA_BUCKET);
			final ItemMeta magmam = magma.getItemMeta();
			magmam.setDisplayName("§7Kit §eMagma");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§a§lPre\u00e7o: §e§l10.000XP");
			desc.add("§7§lSeja imune a lava");
			magmam.setLore(desc);
			magma.setItemMeta(magmam);
			inv.setItem(11, magma);
		} else if (p.hasPermission("kit.magma")) {
			final ItemStack magma = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			final ItemMeta magmam = magma.getItemMeta();
			magmam.setDisplayName("§7Kit §cMagma");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
			magmam.setLore(desc);
			magma.setItemMeta(magmam);
			inv.setItem(11, magma);
		}
		inv.setItem(12, vidro);
		if (!p.hasPermission("kit.avatar")) {
			final ItemStack avatar = new ItemStack(Material.BEACON);
			final ItemMeta avatarm = avatar.getItemMeta();
			avatarm.setDisplayName("§7Kit §eAvatar");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§a§lPre\u00e7o: §e§l15.000XP");
			desc.add("§7§lDomine os quatro elementos");
			avatarm.setLore(desc);
			avatar.setItemMeta(avatarm);
			inv.setItem(13, avatar);
		} else if (p.hasPermission("kit.avatar")) {
			final ItemStack avatar = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			final ItemMeta avatarm = avatar.getItemMeta();
			avatarm.setDisplayName("§7Kit §cAvatar");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
			avatarm.setLore(desc);
			avatar.setItemMeta(avatarm);
			inv.setItem(13, avatar);
		}
		inv.setItem(14, vidro);
		if (!p.hasPermission("kit.shooter")) {
			final ItemStack shooter = new ItemStack(Material.BONE);
			final ItemMeta shooterm = shooter.getItemMeta();
			shooterm.setDisplayName("§7Kit §eShooter");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§a§lPre\u00e7o: §e§l13.000XP");
			desc.add("§7§lQuando acerta uma flecha d\u00ea muito dano");
			shooterm.setLore(desc);
			shooter.setItemMeta(shooterm);
			inv.setItem(15, shooter);
		} else if (p.hasPermission("kit.shooter")) {
			final ItemStack shooter = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			final ItemMeta shooterm = shooter.getItemMeta();
			shooterm.setDisplayName("§7Kit §cShooter");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
			shooterm.setLore(desc);
			shooter.setItemMeta(shooterm);
			inv.setItem(15, shooter);
		}
		inv.setItem(16, vidro);
		if (!p.hasPermission("kit.hotpotato")) {
			final ItemStack hotpotato = new ItemStack(Material.BAKED_POTATO);
			final ItemMeta hotpotatom = hotpotato.getItemMeta();
			hotpotatom.setDisplayName("§7Kit §eHotPotato");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§a§lPre\u00e7o: §e§l20.000XP");
			desc.add("§7§lExploda a cabe\u00e7a dos players");
			hotpotatom.setLore(desc);
			hotpotato.setItemMeta(hotpotatom);
			inv.setItem(17, hotpotato);
		} else if (p.hasPermission("kit.hotpotato")) {
			final ItemStack hotpotato = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
			final ItemMeta hotpotatom = hotpotato.getItemMeta();
			hotpotatom.setDisplayName("§7Kit §cHotPotato");
			final ArrayList<String> desc = new ArrayList<String>();
			desc.add("§cVoc\u00ea j\u00e1 tem esse kit");
			hotpotatom.setLore(desc);
			hotpotato.setItemMeta(hotpotatom);
			inv.setItem(17, hotpotato);
		}
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
	public void inventarioKit(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§cLoja De Kit") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			API.venderItem(e, p, Material.SAND, 15000, "§7Voc\u00ea comprou o kit: §bGaara", "kit.gaara");
			API.venderItem(e, p, Material.LAVA_BUCKET, 10000, "§7Voc\u00ea comprou o kit: §bMagma", "kit.magma");
			API.venderItem(e, p, Material.BEACON, 15000, "§7Voc\u00ea comprou o kit: §bAvatar", "kit.avatar");
			API.venderItem(e, p, Material.BONE, 13000, "§7Voc\u00ea comprou o kit: §bShooter", "kit.shooter");
			API.venderItem(e, p, Material.BAKED_POTATO, 20000, "§7Voc\u00ea comprou o kit: §bHotPotato",
					"kit.hotpotato");
		}
	}

	public static void GuiLojaCaixa(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 9, "§eLoja De Caixa");
		API.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 0);
		API.darItemInvDesc(inv, Material.CHEST, 1, 0, "§7Quantidade: §e1", "§7Pre\u00e7o: §c1000Xp", 1);
		API.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 2);
		API.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 3);
		API.darItemInvDesc(inv, Material.CHEST, 1, 0, "§7Quantidade: §e10", "§7Pre\u00e7o: §c10.000Xp", 4);
		API.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 5);
		API.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 6);
		API.darItemInvDesc(inv, Material.CHEST, 1, 0, "§7Quantidade: §e50", "§7Pre\u00e7o: §c50.000Xp", 7);
		API.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 15, "", 8);
		p.openInventory(inv);
	}

	@EventHandler
	public void inventariocaixa(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§eLoja De Caixa") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			API.venderCaixa(e, p, "§7Quantidade: §e1", 1000, "§7Voc\u00ea comprou §b1 §7Caixa", 1);
			API.venderCaixa(e, p, "§7Quantidade: §e10", 10000, "§7Voc\u00ea comprou §b10 §7Caixa", 10);
			API.venderCaixa(e, p, "§7Quantidade: §e50", 50000, "§7Voc\u00ea comprou §b50 §7Caixa", 50);
		}
	}

	public static void GuiLojas(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 27, "§aLojas");
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
		inv.setItem(10, vidro);
		API.darItemInv(inv, Material.DIAMOND, 1, 0, "§bBuyCraft", 11);
		inv.setItem(12, vidro);
		API.darItemInv(inv, Material.GOLD_INGOT, 1, 0, "§eLoja de Caixa", 13);
		inv.setItem(14, vidro);
		API.darItemInv(inv, Material.EMERALD, 1, 0, "§cLoja de Kit", 15);
		inv.setItem(16, vidro);
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
	public void inventarioLoja(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§aLojas") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND) {
				e.setCancelled(true);
				p.chat("/buycraft");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getType() == Material.EMERALD) {
				e.setCancelled(true);
				GuiLojaKit(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
				e.setCancelled(true);
				GuiLojaCaixa(p);
			}
		}
	}
}
