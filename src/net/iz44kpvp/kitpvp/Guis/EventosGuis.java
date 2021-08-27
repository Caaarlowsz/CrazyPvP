package net.iz44kpvp.kitpvp.Guis;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.KillsDeathsRankXp;

public class EventosGuis implements Listener {
	public static ArrayList<String> aocaixa;

	static {
		EventosGuis.aocaixa = new ArrayList<String>();
	}

	@EventHandler
	public void onBauKit(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.CHEST)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lKITS")) {
			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				GuiKits.GuiKit(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}

	@EventHandler
	public void onWarp(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.COMPASS)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lWARPS")) {
			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				GuiWarps.GuiWarp(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}

	@EventHandler
	public void onLojas(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.INK_SACK)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lLOJAS")) {
			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				GuiLoja.GuiLojas(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}

	@EventHandler
	public void onRanks(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.PAPER)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lRANKS")) {
			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				GuiRank.GuiRanks(p);
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}

	@EventHandler
	public void onCaixa(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType().equals((Object) Material.ENDER_CHEST)
				&& p.getItemInHand().getItemMeta().hasDisplayName()
				&& p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lCAIXA")) {
			e.setCancelled(true);
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (KillsDeathsRankXp.getCaixa(p) >= 1) {
					if (EventosGuis.aocaixa.contains(p.getName())) {
						p.sendMessage(String.valueOf(String.valueOf(API.preffix))
								+ "§7Voc\u00ea j\u00e1 est\u00e1 abrindo uma caixa");
						return;
					}
					GuiCaixa.GuiCaixas(p);
					KillsDeathsRankXp.removerCaixa(p, 1);
					EventosGuis.aocaixa.add(p.getName());
				} else {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix))
							+ "§cVoc\u00ea n\u00e3o possui caixas suficientes");
				}
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
			}
		}
	}
}
