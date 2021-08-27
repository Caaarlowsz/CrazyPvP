package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Cooldown;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Gaara implements Listener {
	private List<UUID> blocos;

	public Gaara() {
		this.blocos = new ArrayList<UUID>();
	}

	@EventHandler
	private void blocosGaara(final EntityChangeBlockEvent evento) {
		if (this.blocos.contains(evento.getEntity().getUniqueId())) {
			evento.setCancelled(true);
		}
	}

	@EventHandler
	private void eventoGaara(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player && Habilidade.getAbility(p).equalsIgnoreCase("Gaara")
				&& p.getItemInHand().getType() == Material.SAND) {
			if (Gladiator.lutando.containsKey(p.getName()) || Infernor.lutando.containsKey(p.getName())) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix))
						+ "§cVoc\u00ea n\u00e3o poder usar seu kit no gladiator(infernor) ent\u00e3o vai §aganhar §eum efeito de §afor\u00e7a §ee §aspeed");
				API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 10, 1);
				API.darEfeito(p, PotionEffectType.SPEED, 10, 2);
			} else {
				if (Cooldown.add(p)) {
					API.MensagemCooldown(p);
					return;
				}
				Cooldown.add(p, 15);
				API.darEfeito(p, PotionEffectType.SPEED, 10, 1);
				new BukkitRunnable() {
					Location[] oldLoc = null;
					Location[] loc = new Location[20];
					int contador = -1;

					public void run() {
						if (e.getPlayer() != null && e.getRightClicked() != null && e.getPlayer().isOnline()
								&& ((Player) e.getRightClicked()).isOnline()) {
							if (++this.contador != 3) {
								if (this.oldLoc != null) {
									Location[] oldLoc;
									for (int length = (oldLoc = this.oldLoc).length, i = 0; i < length; ++i) {
										final Location old = oldLoc[i];
										old.getBlock().setType(Material.AIR);
									}
								}
								final int x = e.getRightClicked().getLocation().getBlockX();
								final int y = e.getRightClicked().getLocation().getBlockY();
								final int z = e.getRightClicked().getLocation().getBlockZ();
								e.getRightClicked().teleport(new Location(e.getRightClicked().getWorld(), x + 0.5,
										(double) (y + 4 + this.contador), z + 0.5));
								this.loc[0] = e.getRightClicked().getLocation().add(0.0, -1.0, 0.0);
								this.loc[1] = e.getRightClicked().getLocation().add(0.0, -1.0, 0.0);
								this.loc[2] = e.getRightClicked().getLocation().add(1.0, 1.0, 1.0);
								this.loc[3] = e.getRightClicked().getLocation().add(-1.0, 1.0, -1.0);
								this.loc[4] = e.getRightClicked().getLocation().add(1.0, 1.0, -1.0);
								this.loc[5] = e.getRightClicked().getLocation().add(-1.0, 1.0, 1.0);
								this.loc[6] = e.getRightClicked().getLocation().add(0.0, 0.0, -1.0);
								this.loc[7] = e.getRightClicked().getLocation().add(-1.0, 0.0, 0.0);
								this.loc[8] = e.getRightClicked().getLocation().add(1.0, 0.0, 0.0);
								this.loc[9] = e.getRightClicked().getLocation().add(0.0, 0.0, 1.0);
								this.loc[10] = e.getRightClicked().getLocation().add(0.0, 3.0, 0.0);
								this.loc[11] = e.getRightClicked().getLocation().add(0.0, 2.0, -1.0);
								this.loc[12] = e.getRightClicked().getLocation().add(-1.0, 2.0, 0.0);
								this.loc[13] = e.getRightClicked().getLocation().add(1.0, 2.0, 0.0);
								this.loc[14] = e.getRightClicked().getLocation().add(0.0, 2.0, 1.0);
								this.loc[15] = e.getRightClicked().getLocation().add(0.0, 1.0, -1.0);
								this.loc[16] = e.getRightClicked().getLocation().add(-1.0, 1.0, 0.0);
								this.loc[17] = e.getRightClicked().getLocation().add(1.0, 1.0, 0.0);
								this.loc[18] = e.getRightClicked().getLocation().add(0.0, 1.0, 1.0);
								this.loc[19] = e.getRightClicked().getLocation().add(0.0, 2.0, 0.0);
								Location[] loc;
								for (int length2 = (loc = this.loc).length, j = 0; j < length2; ++j) {
									final Location locais = loc[j];
									locais.getBlock().setType(Material.SANDSTONE);
								}
								this.oldLoc = this.loc;
							} else {
								this.loc[0] = e.getRightClicked().getLocation().add(0.0, -1.0, 0.0);
								this.loc[1] = e.getRightClicked().getLocation().add(0.0, -1.0, 0.0);
								this.loc[2] = e.getRightClicked().getLocation().add(1.0, 1.0, 1.0);
								this.loc[3] = e.getRightClicked().getLocation().add(-1.0, 1.0, -1.0);
								this.loc[4] = e.getRightClicked().getLocation().add(1.0, 1.0, -1.0);
								this.loc[5] = e.getRightClicked().getLocation().add(-1.0, 1.0, 1.0);
								this.loc[6] = e.getRightClicked().getLocation().add(0.0, 0.0, -1.0);
								this.loc[7] = e.getRightClicked().getLocation().add(-1.0, 0.0, 0.0);
								this.loc[8] = e.getRightClicked().getLocation().add(1.0, 0.0, 0.0);
								this.loc[9] = e.getRightClicked().getLocation().add(0.0, 0.0, 1.0);
								this.loc[10] = e.getRightClicked().getLocation().add(0.0, 3.0, 0.0);
								this.loc[11] = e.getRightClicked().getLocation().add(0.0, 2.0, -1.0);
								this.loc[12] = e.getRightClicked().getLocation().add(-1.0, 2.0, 0.0);
								this.loc[13] = e.getRightClicked().getLocation().add(1.0, 2.0, 0.0);
								this.loc[14] = e.getRightClicked().getLocation().add(0.0, 2.0, 1.0);
								this.loc[15] = e.getRightClicked().getLocation().add(0.0, 1.0, -1.0);
								this.loc[16] = e.getRightClicked().getLocation().add(-1.0, 1.0, 0.0);
								this.loc[17] = e.getRightClicked().getLocation().add(1.0, 1.0, 0.0);
								this.loc[18] = e.getRightClicked().getLocation().add(0.0, 1.0, 1.0);
								this.loc[19] = e.getRightClicked().getLocation().add(0.0, 2.0, 0.0);
								Location[] oldLoc2;
								for (int length3 = (oldLoc2 = this.oldLoc).length, k = 0; k < length3; ++k) {
									final Location old = oldLoc2[k];
									old.getBlock().setType(Material.AIR);
								}
								Location[] loc2;
								for (int length4 = (loc2 = this.loc).length, l = 0; l < length4; ++l) {
									final Location locais2 = loc2[l];
									final FallingBlock bloco = locais2.getBlock().getWorld().spawnFallingBlock(locais2,
											Material.SAND, (byte) 0);
									Gaara.this.blocos.add(bloco.getUniqueId());
								}
								e.getRightClicked().setFallDistance(-10.0f);
								e.getRightClicked().getWorld().createExplosion(this.loc[19], 2.0f, true);
								this.cancel();
							}
						} else {
							Location[] loc3;
							for (int length5 = (loc3 = this.loc).length, n = 0; n < length5; ++n) {
								final Location locais3 = loc3[n];
								locais3.getBlock().setType(Material.AIR);
							}
							if (this.oldLoc != null) {
								Location[] oldLoc3;
								for (int length6 = (oldLoc3 = this.oldLoc).length, n2 = 0; n2 < length6; ++n2) {
									final Location old2 = oldLoc3[n2];
									old2.getBlock().setType(Material.AIR);
								}
							}
							this.cancel();
						}
					}
				}.runTaskTimer(Main.getPlugin(), 0L, 8L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						p.sendMessage(API.fimcooldown);
					}
				}, 300L);
			}
		}
	}
}
