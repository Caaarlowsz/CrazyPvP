package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class JellyFish implements Listener {
	ArrayList<Block> naoescorrer;
	public static String naocolocaragua;

	static {
		JellyFish.naocolocaragua = String.valueOf(String.valueOf(API.preffix))
				+ "§cVoc\u00ea n\u00e3o pode colocar \u00e1gua aqui";
	}

	public JellyFish() {
		this.naoescorrer = new ArrayList<Block>();
	}

	@EventHandler
	public void colocaragua(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("JellyFish") && p.getItemInHand().getType() == Material.AIR
				&& event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			final Block b = event.getClickedBlock();
			final BlockFace lado = event.getBlockFace();
			final int x = b.getLocation().getBlockX();
			final int y = b.getLocation().getBlockY();
			final int z = b.getLocation().getBlockZ();
			if (lado == BlockFace.DOWN) {
				final Block b2 = b.getWorld().getBlockAt(x, y - 1, z);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									b2.setType(Material.AIR);
									JellyFish.this.naoescorrer.remove(b2);
								}
							}, 60L);
				} else {
					p.sendMessage(JellyFish.naocolocaragua);
				}
			} else if (lado == BlockFace.UP) {
				final Block b2 = b.getWorld().getBlockAt(x, y + 1, z);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									b2.setType(Material.AIR);
									JellyFish.this.naoescorrer.remove(b2);
								}
							}, 60L);
				} else {
					p.sendMessage(JellyFish.naocolocaragua);
				}
			} else if (lado == BlockFace.NORTH) {
				final Block b2 = b.getWorld().getBlockAt(x, y, z - 1);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									b2.setType(Material.AIR);
									JellyFish.this.naoescorrer.remove(b2);
								}
							}, 60L);
				} else {
					p.sendMessage(JellyFish.naocolocaragua);
				}
			} else if (lado == BlockFace.SOUTH) {
				final Block b2 = b.getWorld().getBlockAt(x, y, z + 1);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									b2.setType(Material.AIR);
									JellyFish.this.naoescorrer.remove(b2);
								}
							}, 60L);
				} else {
					p.sendMessage(JellyFish.naocolocaragua);
				}
			} else if (lado == BlockFace.WEST) {
				final Block b2 = b.getWorld().getBlockAt(x - 1, y, z);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									b2.setType(Material.AIR);
									JellyFish.this.naoescorrer.remove(b2);
								}
							}, 60L);
				} else {
					p.sendMessage(JellyFish.naocolocaragua);
				}
			} else if (lado == BlockFace.EAST) {
				final Block b2 = b.getWorld().getBlockAt(x + 1, y, z);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Main.instance,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									b2.setType(Material.AIR);
									JellyFish.this.naoescorrer.remove(b2);
								}
							}, 60L);
				} else {
					p.sendMessage(JellyFish.naocolocaragua);
				}
			}
		}
	}

	@EventHandler
	public void naoescorrer(final BlockPhysicsEvent event) {
		final Block b = event.getBlock();
		if (b.getType() == Material.STATIONARY_WATER && this.naoescorrer.contains(b)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void veneno(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		final Block b = p.getLocation().getBlock();
		if (b.getType() == Material.STATIONARY_WATER && !p.getInventory().contains(Material.CLAY_BALL)
				&& this.naoescorrer.contains(b)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
		}
	}
}
