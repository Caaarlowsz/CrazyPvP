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

public class GuiKits implements Listener {
	public static ArrayList<String> emarray;
	public static ArrayList<String> emarray1;

	static {
		GuiKits.emarray = new ArrayList<String>();
		GuiKits.emarray1 = new ArrayList<String>();
	}

	public static void GuiKit(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 54, "§cKits");
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
		final ItemStack carpet = new ItemStack(Material.CARPET, 1, (short) 5);
		final ItemMeta carpetm = carpet.getItemMeta();
		carpetm.setDisplayName("§aProxima Pagina");
		carpet.setItemMeta(carpetm);
		inv.setItem(0, vidro);
		inv.setItem(1, vidro);
		inv.setItem(2, vidro);
		inv.setItem(3, vidro);
		inv.setItem(4, vidro);
		inv.setItem(5, vidro);
		inv.setItem(6, vidro);
		inv.setItem(7, vidro);
		inv.setItem(8, carpet);
		if (p.hasPermission("kit.pvp")) {
			final ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §ePvP");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Treine seu pvp sem habilidades");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.jumper")) {
			final ItemStack pyro = new ItemStack(Material.FIREWORK_CHARGE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eJumper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Voe para cima com o seu bloco magico");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.bombeiro")) {
			final ItemStack pyro = new ItemStack(Material.TORCH);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eBombeiro");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Apage os fogos das pessoas");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.goku")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_NUGGET);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eGoku");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Se transforme em sayajin");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.shooter")) {
			final ItemStack pyro = new ItemStack(Material.BONE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eShooter");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Quando acerta uma flecha d\u00ea muito dano");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.timelord")) {
			final ItemStack pyro = new ItemStack(Material.WATCH);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eTimeLord");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Congele os players perto de voce");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.bruxa")) {
			final ItemStack pyro = new ItemStack(Material.STICK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eBruxa");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Adicione efeito nos players perto de voc\u00ea");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.jellyfish")) {
			final ItemStack pyro = new ItemStack(Material.CLAY_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eJellyFish");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Solte uma \u00e1gua venenosa");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.anchor")) {
			final ItemStack pyro = new ItemStack(Material.ANVIL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eAnchor");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7N\u00e3o tome knockback");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.fisherman")) {
			final ItemStack pyro = new ItemStack(Material.FISHING_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eFisherman");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Puxe os players com sua vara de pesca");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.magma")) {
			final ItemStack pyro = new ItemStack(Material.LAVA_BUCKET);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eMagma");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Seja imune a lava");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.confus\u00e3o")) {
			final ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eConfus\u00e3o");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Confunda os players");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.gladiator")) {
			final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eGladiator");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Puxe os players para um 1v1 no c\u00e9u");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.hotpotato")) {
			final ItemStack pyro = new ItemStack(Material.BAKED_POTATO);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eHotPotato");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Exploda a cabe\u00e7a dos players");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.forcefield")) {
			final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eForceField");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao ativar seu kit fa\u00e7a o mesmo que o hack forcefield");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.avatar")) {
			final ItemStack pyro = new ItemStack(Material.BEACON);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eAvatar");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Domine os quatro elementos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.kangaroo")) {
			final ItemStack pyro = new ItemStack(Material.FIREWORK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eKangaroo");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7De um double-jump com seu fogete");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.grappler")) {
			final ItemStack pyro = new ItemStack(Material.LEASH);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eGrappler");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Agarre na sua corda e puxe-a");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.monk")) {
			final ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eMonk");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Bagun\u00e7e os inventarios dos players");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.stomper")) {
			final ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eStomper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Esmague os players perto de voc\u00ea");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.thor")) {
			final ItemStack pyro = new ItemStack(Material.GOLD_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eThor");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Solte raios em seus inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.teleporter")) {
			final ItemStack pyro = new ItemStack(Material.BOW);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eTeleporter");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Se teleporte pro player com sua flecha magica");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.antistomper")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_BOOTS);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eAntiStomper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7N\u00e3o tome dano para stomper");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.quickdropper")) {
			final ItemStack pyro = new ItemStack(Material.BOWL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eQuickDropper");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Drope o pote automaticamente");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.gaara")) {
			final ItemStack pyro = new ItemStack(Material.SAND);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eGaara");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Prenda os players no caix\u00e3o de areia");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.infernor")) {
			final ItemStack pyro = new ItemStack(Material.NETHER_FENCE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eInfernor");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Puxe os players para um 1v1 no c\u00e9u com for\u00e7a");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.poseidon")) {
			final ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §ePoseidon");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Fique mais forte quando estiver na \u00e1gua");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.trader")) {
			final ItemStack pyro = new ItemStack(Material.EMERALD);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eTrader");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Troque esmeraldas por items");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.ironman")) {
			final ItemStack pyro = new ItemStack(Material.IRON_INGOT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eIronMan");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao matar ganhe ferros para craftar");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.phantom")) {
			final ItemStack pyro = new ItemStack(Material.FEATHER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §ePhantom");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Voe ao usar seu kit");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.c4")) {
			final ItemStack pyro = new ItemStack(Material.SLIME_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eC4");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Exploda seus inimigos com sua bomba");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.viking")) {
			final ItemStack pyro = new ItemStack(Material.STONE_AXE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eViking");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7O dano fica maior com um machado de viking");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.gun")) {
			final ItemStack pyro = new ItemStack(Material.WOOD_HOE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eGun");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Atire em seus inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.terrorista")) {
			final ItemStack pyro = new ItemStack(Material.TNT);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eTerrorista");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao cair exploda seus inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.deshzin")) {
			final ItemStack pyro = new ItemStack(Material.FIREWORK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eDeshzin");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao teclar a barra de espa\u00e7o duas vezes de um boost");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.flash")) {
			final ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eFlash");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Roube a velocidade dos seus inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.rain")) {
			final ItemStack pyro = new ItemStack(Material.ARROW);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eRain");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Solte chuva de flecha em seus inimigos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.rusher")) {
			final ItemStack pyro = new ItemStack(Material.IRON_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eRusher");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Fique com uma armadura de ferro por 10 segundos");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.hack")) {
			final ItemStack pyro = new ItemStack(Material.NAME_TAG);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eHack");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao usar o kit fique com poderes hack");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.flashback")) {
			final ItemStack pyro = new ItemStack(Material.HOPPER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eFlashBack");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Salve seu inventario e local");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.switcher")) {
			final ItemStack pyro = new ItemStack(Material.SNOW_BALL);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eSwitcher");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Troque de lugar com o player acertado");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.subzero")) {
			final ItemStack pyro = new ItemStack(Material.PACKED_ICE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eSubzero");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Congele o player acertado");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.vacuum")) {
			final ItemStack pyro = new ItemStack(Material.EYE_OF_ENDER);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eVacuum");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Puxe os players a sua volta");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.turtle")) {
			final ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eTurtle");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao segurar shift fique protegido de tudo");
			metapyro.setLore(descpyro);
			pyro.setItemMeta(metapyro);
			inv.addItem(new ItemStack[] { pyro });
		}
		if (p.hasPermission("kit.grandpa")) {
			final ItemStack pyro = new ItemStack(Material.STICK);
			final ItemMeta metapyro = pyro.getItemMeta();
			metapyro.setDisplayName("§7Kit §eGrandpa");
			final ArrayList<String> descpyro = new ArrayList<String>();
			descpyro.add("§7Ao bater de um knockback muito grande");
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
		if (e.getInventory().getTitle().equalsIgnoreCase("§cKits") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.CARPET) {
				e.setCancelled(true);
				GuiKits2.GuiKit2(p);
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit pvp");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FIREWORK_CHARGE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit jumper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.TORCH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit bombeiro");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_NUGGET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit goku");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BONE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit shooter");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATCH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit timelord");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit §eBruxa")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit bruxa");
				return;
			}
			if (e.getCurrentItem().getType() == Material.CLAY_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit jellyfish");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ANVIL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit anchor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit fisherman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LAVA_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit magma");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ENDER_PEARL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit confus\u00e3o");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit §eGladiator")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gladiator");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BAKED_POTATO) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hotpotato");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit §eForceField")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit forcefield");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BEACON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit avatar");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit §eKangaroo")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit kangaroo");
				return;
			}
			if (e.getCurrentItem().getType() == Material.LEASH) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit grappler");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit monk");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit stomper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.GOLD_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit thor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit teleporter");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit antistomper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.BOWL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit quickdropper");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SAND) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gaara");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NETHER_FENCE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit infernor");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit poseidon");
				return;
			}
			if (e.getCurrentItem().getType() == Material.EMERALD) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit trader");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_INGOT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit ironman");
				return;
			}
			if (e.getCurrentItem().getType() == Material.FEATHER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit phantom");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit c4");
				return;
			}
			if (e.getCurrentItem().getType() == Material.STONE_AXE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit viking");
				return;
			}
			if (e.getCurrentItem().getType() == Material.WOOD_HOE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit gun");
				return;
			}
			if (e.getCurrentItem().getType() == Material.TNT) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit terrorista");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit §eDeshzin")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit deshzin");
				return;
			}
			if (e.getCurrentItem().getType() == Material.REDSTONE_TORCH_ON) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit flash");
				return;
			}
			if (e.getCurrentItem().getType() == Material.ARROW) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit rain");
				return;
			}
			if (e.getCurrentItem().getType() == Material.IRON_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit rusher");
				return;
			}
			if (e.getCurrentItem().getType() == Material.NAME_TAG) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit hack");
				return;
			}
			if (e.getCurrentItem().getType() == Material.HOPPER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit flashback");
				return;
			}
			if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit switcher");
				return;
			}
			if (e.getCurrentItem().getType() == Material.PACKED_ICE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit subzero");
				return;
			}
			if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit vacuum");
				return;
			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit turtle");
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Kit §eGrandpa")) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/kit grandpa");
			}
		}
	}
}
