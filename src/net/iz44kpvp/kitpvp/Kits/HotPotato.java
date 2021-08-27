package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class HotPotato implements Listener {
	public static ArrayList<String> emhotpotato;

	static {
		HotPotato.emhotpotato = new ArrayList<String>();
	}

	@EventHandler
	public void onInteract(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player k = (Player) e.getRightClicked();
			if (p.getItemInHand().getType().equals((Object) Material.getMaterial(392))
					&& Habilidade.getAbility(p).equalsIgnoreCase("HotPotato")) {
				if (Gladiator.lutando.containsKey(p.getName())) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix))
							+ "§cVoc\u00ea n\u00e3o poder usar seu kit no gladiator ent\u00e3o vai §aganhar §eum efeito de §afor\u00e7a §ee §aspeed");
					API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
					API.darEfeito(p, PotionEffectType.SPEED, 10, 2);
				} else {
					if (Cooldown.add(p)) {
						API.MensagemCooldown(p);
						return;
					}
					Cooldown.add(p, 20);
					HotPotato.emhotpotato.add(k.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aHotPotato Colocada");
					k.sendMessage(String.valueOf(String.valueOf(API.preffix))
							+ "§eVoc\u00ea est\u00e1 com a tnt do hotpotato tire ou ira explodir em 5 segundos");
					k.sendMessage(String.valueOf(String.valueOf(API.preffix))
							+ "§cClick com o botao direito na hotpotato para tira-la");
					final ItemStack tnt = new ItemStack(Material.TNT);
					final ItemMeta tntmeta = tnt.getItemMeta();
					tntmeta.setDisplayName("§cTNT");
					tnt.setItemMeta(tntmeta);
					k.getInventory().setHelmet(tnt);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§eVoc\u00ea est\u00e1 com a tnt, explodindo em 4 segundos");
								k.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§cClick com o botao direito na hotpotato para tira-la");
							}
						}
					}.runTaskLater((Plugin) Main.getInstance(), 0L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§eVoc\u00ea est\u00e1 com a tnt, explodindo em 3 segundos");
								k.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§cClick com o botao direito na hotpotato para tira-la");
							}
						}
					}.runTaskLater((Plugin) Main.getInstance(), 20L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§eVoc\u00ea est\u00e1 com a tnt, explodindo em 2 segundos");
								k.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§cClick com o botao direito na hotpotato para tira-la");
							}
						}
					}.runTaskLater((Plugin) Main.getInstance(), 40L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§c§lVoc\u00ea est\u00e1 com a tnt, explodindo em 1 segundo");
								k.sendMessage(String.valueOf(String.valueOf(API.preffix))
										+ "§cClick com o botao direito na hotpotato para tira-la");
							}
						}
					}.runTaskLater((Plugin) Main.getInstance(), 60L);
					new BukkitRunnable() {
						public void run() {
							if (HotPotato.emhotpotato.contains(k.getName())) {
								k.getWorld().createExplosion(k.getLocation(), 3.0f, true);
								k.getWorld().playEffect(k.getLocation(), Effect.EXPLOSION_HUGE, 20);
								k.setLastDamage(9999.0);
								HotPotato.emhotpotato.remove(k.getName());
							}
						}
					}.runTaskLater((Plugin) Main.getInstance(), 80L);
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(API.fimcooldown);
						}
					}, 500L);
				}
			}
		}
	}

	@EventHandler
	public void onRemoverTNT(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (Habilidade.getAbility(p) != "Nenhum" && e.getSlot() == 39
				&& e.getCurrentItem().getType().equals((Object) Material.TNT)
				&& HotPotato.emhotpotato.contains(p.getName())) {
			HotPotato.emhotpotato.remove(p.getName());
			e.setCancelled(true);
			p.getInventory().setHelmet((ItemStack) null);
			p.playSound(p.getLocation(), Sound.CREEPER_HISS, 2.0f, 2.0f);
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aVoc\u00ea desarmou a hotpotato");
			p.closeInventory();
		}
	}
}
