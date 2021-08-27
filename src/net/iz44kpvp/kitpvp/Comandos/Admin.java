package net.iz44kpvp.kitpvp.Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.KillsDeathsRankXp;

public class Admin implements CommandExecutor, Listener {
	public static ArrayList<Player> emAdmin;
	public static HashMap<String, ItemStack[]> salvarinv;
	public static HashMap<String, ItemStack[]> salrvararmor;
	public static HashMap<String, ItemStack[]> salvarinventarioautosoup;
	public static ArrayList<String> aotestarautosoup;
	public static ArrayList<String> hacks;

	static {
		Admin.hacks = new ArrayList<String>();
		Admin.emAdmin = new ArrayList<Player>();
		Admin.salvarinv = new HashMap<String, ItemStack[]>();
		Admin.salrvararmor = new HashMap<String, ItemStack[]>();
		Admin.salvarinventarioautosoup = new HashMap<String, ItemStack[]>();
		Admin.aotestarautosoup = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("admin")) {
			if (p.hasPermission("flame.staff")) {
				if (!Admin.emAdmin.contains(p)) {
					Admin.emAdmin.add(p);
					Admin.salvarinv.put(p.getName(), p.getInventory().getContents());
					Admin.salrvararmor.put(p.getName(), p.getInventory().getArmorContents());
					p.getInventory().clear();
					p.sendMessage("§aVoc\u00ea entrou no modo admin");
					p.setHealth(20.0);
					p.setFireTicks(0);
					p.setGameMode(GameMode.CREATIVE);
					API.darItem(p, Material.ENDER_PEARL, 1, "§bTrocaRapida", 0);
					API.darItem(p, Material.PAPER, 1, "§bInforma\u00e7\u00f5es Do Player", 2);
					API.darItem(p, Material.FEATHER, 1, "§bTeste Nofall", 3);
					API.darItemEnchant(p, Material.STICK, 1, "§bTeste KnockBack", 4, Enchantment.KNOCKBACK, 10, true);
					API.darItem(p, Material.BEDROCK, 1, "§bPrender Player", 5);
					API.darItem(p, Material.MUSHROOM_SOUP, 1, "§bTeste Auto-Soup", 6);
					API.darItem(p, Material.REDSTONE, 1, "§bSair Do Admin", 8);
					Bukkit.broadcastMessage("§5[§c-§5] §b" + p.getDisplayName());
					p.updateInventory();
					Player[] onlinePlayers;
					for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
						final Player todos = onlinePlayers[i];
						todos.hidePlayer(p);
					}
				} else {
					Admin.emAdmin.remove(p);
					p.getInventory().clear();
					p.getInventory().setContents((ItemStack[]) Admin.salvarinv.get(p.getName()));
					p.getInventory().setArmorContents((ItemStack[]) Admin.salrvararmor.get(p.getName()));
					p.updateInventory();
					p.setHealth(20.0);
					p.setFireTicks(0);
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§cVoc\u00ea saiu do modo admin");
					Bukkit.broadcastMessage("§5[§a+§5] §b" + p.getDisplayName());
					Player[] onlinePlayers2;
					for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
						final Player todos = onlinePlayers2[j];
						todos.showPlayer(p);
					}
				}
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}

	@EventHandler
	public void oaSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (Admin.emAdmin.contains(p)) {
			Admin.emAdmin.remove(p);
		}
	}

	@EventHandler
	public void aoInfoPlayer(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player t = (Player) e.getRightClicked();
		if (Admin.emAdmin.contains(p) && p.getInventory().getItemInHand().getType() == Material.PAPER) {
			final Damageable hp = (Damageable) t;
			p.sendMessage("§7Informa\u00e7\u00f5es Do Player: §b" + t.getDisplayName());
			p.sendMessage("§7Vida: §b" + (int) hp.getHealth());
			p.sendMessage("§7Kit: §b" + API.getKit(t));
			p.sendMessage("§7Sopas: §b" + API.getItemNoInv(t, Material.MUSHROOM_SOUP));
			p.sendMessage("§7Matou: §b" + KillsDeathsRankXp.getKills(t));
			p.sendMessage("§7Morreu: §b" + KillsDeathsRankXp.getDeaths(t));
			p.sendMessage("§7XP: §b" + KillsDeathsRankXp.getXp(t));
			p.sendMessage("§7IP: §b" + t.getAddress().getHostString());
		}
	}

	@EventHandler
	public void oaTrocar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Admin.emAdmin.contains(p)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.ENDER_PEARL) {
			e.setCancelled(true);
			final BukkitScheduler scheduler = Bukkit.getScheduler();
			scheduler.scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.chat("/admin");
				}
			}, 0L);
			scheduler.scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.chat("/admin");
				}
			}, 15L);
		}
	}

	@EventHandler
	public void aoAutoSoup(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player t = (Player) e.getRightClicked();
		if (Admin.emAdmin.contains(p) && p.getInventory().getItemInHand().getType() == Material.MUSHROOM_SOUP) {
			if (Admin.aotestarautosoup.contains(p.getName())) {
				p.sendMessage(
						String.valueOf(String.valueOf(API.preffix)) + "§cVoc\u00ea j\u00e1 esta testando um player");
				return;
			}
			Admin.salvarinventarioautosoup.put(t.getName(), t.getInventory().getContents());
			t.getInventory().clear();
			t.setHealth(0.5);
			p.openInventory((Inventory) t.getInventory());
			p.sendMessage(String.valueOf(String.valueOf(API.preffix))
					+ "§7Voc\u00ea est\u00e1 testando o auto-soup de: §b" + t.getDisplayName());
			API.darItem(t, Material.MUSHROOM_SOUP, 1, "§cTESTE-AUTOSOUP", 14);
			API.darItem(t, Material.MUSHROOM_SOUP, 1, "§cTESTE-AUTOSOUP", 15);
			API.darItem(t, Material.MUSHROOM_SOUP, 1, "§cTESTE-AUTOSOUP", 16);
			Admin.aotestarautosoup.add(p.getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Teste acabado! §6e o resultado e?");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Quantidades de sopa(s) bebida(s): §b"
							+ API.getItemNoInv(t, Material.BOWL));
					p.sendMessage(String.valueOf(String.valueOf(API.preffix))
							+ "§7Quantidades de sopa(s) n\u00e3o bebida(s): §b"
							+ API.getItemNoInv(t, Material.MUSHROOM_SOUP));
					Admin.aotestarautosoup.remove(p.getName());
				}
			}, 60L);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					t.getInventory().setContents((ItemStack[]) Admin.salvarinventarioautosoup.get(t.getName()));
				}
			}, 100L);
		}
	}

	@EventHandler
	public void aoNofall(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player t = (Player) e.getRightClicked();
		if (Admin.emAdmin.contains(p)) {
			if (p.getInventory().getItemInHand().getType() == Material.FEATHER) {
				t.setVelocity(new Vector(0, 2, 0));
			}
			if (p.getInventory().getItemInHand().getType() == Material.AIR) {
				p.openInventory((Inventory) t.getInventory());
			}
		}
	}

	@EventHandler
	public void aoSair(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Admin.emAdmin.contains(p)
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.REDSTONE) {
			p.chat("/admin");
		}
	}

	@EventHandler
	public void onCage(final PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		final Player p = e.getPlayer();
		final Player t = (Player) e.getRightClicked();
		if (Admin.emAdmin.contains(p) && p.getItemInHand().getType() == Material.BEDROCK) {
			t.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
			t.teleport(t.getLocation().add(0.0, 11.0, -0.07));
			p.teleport(t.getLocation().add(3.0, 0.0, 0.05));
			Admin.hacks.add(t.getName());
			p.sendMessage("§aVoc\u00ea prendeu o jogador: §f" + t.getName()
					+ " §aEle N\u00e3o conseguira mais usar comandos ate voc\u00ea o liberar usando: §f/uncage "
					+ t.getName());
			t.sendMessage("§cO Staff: §f" + p.getName()
					+ " §cLhe Prendeu Voc\u00ea n\u00e3o ira conseguir executar comandos ate que seja liberado");
		}
	}

	@EventHandler
	private void onCommand(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (Admin.hacks.contains(p.getName())) {
			e.setCancelled(true);
			p.sendMessage("§cVoc\u00ea esta sendo verificado n\u00e3o pode usar comandos agora.");
		}
	}
}
