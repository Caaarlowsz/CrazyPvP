package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import net.iz44kpvp.kitpvp.Kits.FlashBack;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class Kit implements CommandExecutor {
	private boolean manutencao;

	public Kit() {
		this.manutencao = true;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("kit")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cUse /Kit [Habilidade]");
				return true;
			}
			if (!Habilidade.getAbility(p).equals("Nenhum")) {
				p.sendMessage(API.comkit);
				return true;
			}
			if (args[0].equalsIgnoreCase("pvp")) {
				if (p.hasPermission("kit.pvp")) {
					p.getInventory().clear();
					API.darItemEnchant(p, Material.STONE_SWORD, 1, "§aEspada", 0, Enchantment.DAMAGE_ALL, 1, true);
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "PvP");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("jumper")) {
				if (p.hasPermission("kit.jumper")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.FIREWORK_CHARGE, 1, "§7Kit §eJumper", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Jumper");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("bombeiro")) {
				if (p.hasPermission("kit.bombeiro")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.TORCH, 1, "§7Kit §eBombeiro", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Bombeiro");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("goku")) {
				if (p.hasPermission("kit.goku")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.GOLD_NUGGET, 1, "§7Kit §eGoku", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Goku");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("shooter")) {
				if (p.hasPermission("kit.shooter")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.BONE, 1, "§7Kit §eShooter", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Shooter");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("timelord")) {
				if (p.hasPermission("kit.timelord")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.WATCH, 1, "§7Kit §eTimeLord", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "TimeLord");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("bruxa")) {
				if (p.hasPermission("kit.bruxa")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.STICK, 1, "§7Kit §eBruxa", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Bruxa");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("jellyfish")) {
				if (p.hasPermission("kit.jellyfish")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "JellyFish");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("anchor")) {
				if (p.hasPermission("kit.anchor")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Anchor");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("fisherman")) {
				if (p.hasPermission("kit.fisherman")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.FISHING_ROD, 1, "§7Kit §eFisherman", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Fisherman");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("magma")) {
				if (p.hasPermission("kit.magma")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Magma");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("confus\u00e3o")) {
				if (p.hasPermission("kit.confus\u00e3o")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.ENDER_PEARL, 1, "§7Kit §eConfus\u00e3o", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Confus\u00e3o");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("gladiator")) {
				if (p.hasPermission("kit.gladiator")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.IRON_FENCE, 1, "§7Kit §eGladiator", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Gladiator");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("hotpotato")) {
				if (p.hasPermission("kit.hotpotato")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.getMaterial(392), 1, "§7Kit §eHotPotato", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "HotPotato");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("forcefield")) {
				if (p.hasPermission("kit.forcefield")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.IRON_FENCE, 1, "§7Kit §eForceField", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "ForceField");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("avatar")) {
				if (p.hasPermission("kit.avatar")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.BEACON, 1, "§7Kit §eAvatar", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Avatar");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("kangaroo")) {
				if (p.hasPermission("kit.kangaroo")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.FIREWORK, 1, "§7Kit §eKangaroo", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Kangaroo");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("grappler")) {
				if (this.manutencao) {
					p.sendMessage("§cKit Em Manuten\u00e7\u00e3o, Resolvendo Bugs!");
					return true;
				}
				if (p.hasPermission("kit.grappler")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.LEASH, 1, "§7Kit §eGrappler", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Grappler");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("monk")) {
				if (p.hasPermission("kit.monk")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.BLAZE_ROD, 1, "§7Kit §eMonk", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Monk");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("stomper")) {
				if (p.hasPermission("kit.stomper")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.GOLDEN_APPLE, 1, "§7Kit §eStomper", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Stomper");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("thor")) {
				if (p.hasPermission("kit.thor")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.GOLD_AXE, 1, "§7Kit §eThor", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Thor");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("teleporter")) {
				if (p.hasPermission("kit.teleporter")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItemEnchant(p, Material.BOW, 1, "§7Kit §eTeleporter", 1, Enchantment.ARROW_INFINITE, 1,
							true);
					API.darItem(p, Material.ARROW, 1, "§7Kit §eTeleporter", 2);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 32);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Teleporter");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("antistomper")) {
				if (p.hasPermission("kit.antistomper")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "AntiStomper");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("quickdropper")) {
				if (p.hasPermission("kit.quickdropper")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "QuickDropper");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("gaara")) {
				if (p.hasPermission("kit.gaara")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.SAND, 1, "§7Kit §eGaara", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Gaara");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("infernor")) {
				if (p.hasPermission("kit.infernor")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.NETHER_FENCE, 1, "§7Kit §eInfernor", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Infernor");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("poseidon")) {
				if (p.hasPermission("kit.poseidon")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Poseidon");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("trader")) {
				if (p.hasPermission("kit.trader")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.ENDER_CHEST, 1, "§7Kit §eTrader", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Trader");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("ironman")) {
				if (p.hasPermission("kit.ironman")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.WORKBENCH, 1, "§7Kit §eIronMan", 1);
					API.darItem(p, Material.STICK, 1, "§7Kit §eIronMan", 2);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 32);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "IronMan");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("phantom")) {
				if (p.hasPermission("kit.phantom")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.FEATHER, 1, "§7Kit §ePhantom", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Phantom");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("c4")) {
				if (p.hasPermission("kit.c4")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.SLIME_BALL, 1, "§7Kit §eC4", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "C4");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("viking")) {
				if (p.hasPermission("kit.viking")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_AXE, 1, "§7Machado", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Viking");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("gun")) {
				if (p.hasPermission("kit.gun")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.WOOD_HOE, 1, "§7Kit §eGun", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Gun");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("terrorista")) {
				if (p.hasPermission("kit.terrorista")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.MAGMA_CREAM, 1, "§7Kit §eTerrorista", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Terrorista");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("deshzin")) {
				if (p.hasPermission("kit.deshzin")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Deshzin");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("flash")) {
				if (p.hasPermission("kit.flash")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.REDSTONE_TORCH_ON, 1, "§7Kit §eFlash", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Flash");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("rain")) {
				if (p.hasPermission("kit.rain")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.NETHER_STAR, 1, "§7Kit §eRain", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Rain");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("rusher")) {
				if (p.hasPermission("kit.rusher")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.IRON_INGOT, 1, "§7Kit §eRusher", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Rusher");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("hack")) {
				if (p.hasPermission("kit.hack")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.SLIME_BALL, 1, "§7Kit §eHack", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Hack");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("flashback")) {
				if (p.hasPermission("kit.flashback")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.HOPPER, 1, "§7Kit §eFlashBack", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					FlashBack.checker(p);
					Habilidade.setAbility(p, "FlashBack");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("switcher")) {
				if (p.hasPermission("kit.switcher")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.SNOW_BALL, 64, "§7Kit §eSwitcher", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Switcher");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("subzero")) {
				if (p.hasPermission("kit.subzero")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.PACKED_ICE, 1, "§7Kit §eSubzero", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Subzero");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("vacuum")) {
				if (p.hasPermission("kit.vacuum")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.EYE_OF_ENDER, 1, "§7Kit §eVacuum", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Vacuum");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("turtle")) {
				if (p.hasPermission("kit.turtle")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Turtle");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("grandpa")) {
				if (p.hasPermission("kit.grandpa")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItemEnchant(p, Material.STICK, 1, "§7Kit §eGrandpa", 1, Enchantment.KNOCKBACK, 5, true);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Grandpa");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("ajnin")) {
				if (p.hasPermission("kit.ajnin")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Ajnin");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("ninja")) {
				if (p.hasPermission("kit.ninja")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Ninja");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("reverse")) {
				if (p.hasPermission("kit.reverse")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Reverse");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("pyro")) {
				if (p.hasPermission("kit.pyro")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.FIREBALL, 1, "§7Kit §ePyro", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Pyro");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("resouper")) {
				if (p.hasPermission("kit.resouper")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Resouper");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("nofall")) {
				if (p.hasPermission("kit.nofall")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "NoFall");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("viper")) {
				if (p.hasPermission("kit.viper")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Viper");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("snail")) {
				if (p.hasPermission("kit.snail")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Snail");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("hulk")) {
				if (p.hasPermission("kit.hulk")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 34);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Hulk");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("deshice")) {
				if (p.hasPermission("kit.deshice")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.SNOW_BLOCK, 1, "§7Kit §eDeshIce", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "DeshIce");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("deshfire")) {
				if (p.hasPermission("kit.deshfire")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.REDSTONE_BLOCK, 1, "§7Kit §eDeshFire", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "DeshFire");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
			if (args[0].equalsIgnoreCase("hercules")) {
				if (p.hasPermission("kit.hercules")) {
					p.getInventory().clear();
					API.darItem(p, Material.STONE_SWORD, 1, "§7Espada", 0);
					API.darItem(p, Material.BONE, 1, "§7Kit §eHercules", 1);
					API.darItem(p, Material.COMPASS, 1, "§aBussola", 8);
					API.darSopa(p, 33);
					p.setGameMode(GameMode.SURVIVAL);
					Habilidade.setAbility(p, "Hercules");
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea pegou o kit: §b"
							+ Habilidade.getAbility(p));
					SetArena.TeleportArenaRandom(p);
				} else {
					p.sendMessage(API.semkit);
				}
			}
		}
		return false;
	}
}
