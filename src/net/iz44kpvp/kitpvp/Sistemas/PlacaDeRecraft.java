package net.iz44kpvp.kitpvp.Sistemas;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlacaDeRecraft implements Listener {
	@EventHandler
	public void onSignChange(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("recraft")) {
			e.setLine(0, "§b=-=-=-=-=");
			e.setLine(1, "§aPlaca");
			e.setLine(2, "§c(Recraft)");
			e.setLine(3, "§b=-=-=-=-=");
		}
	}

	@EventHandler
	public void inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack red = new ItemStack(Material.RED_MUSHROOM, 64);
		final ItemMeta redm = red.getItemMeta();
		redm.setDisplayName("§cCogumelo");
		red.setItemMeta(redm);
		final ItemStack brown = new ItemStack(Material.BROWN_MUSHROOM, 64);
		final ItemMeta brownm = brown.getItemMeta();
		brownm.setDisplayName("§6Cogumelo");
		brown.setItemMeta(brownm);
		final ItemStack pote = new ItemStack(Material.BOWL, 64);
		final ItemMeta potem = pote.getItemMeta();
		potem.setDisplayName("§7Pote");
		pote.setItemMeta(potem);
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 0 && lines[0].equals("§b=-=-=-=-=") && lines.length > 1 && lines[1].equals("§aPlaca")
					&& lines.length > 2 && lines[2].equals("§c(Recraft)") && lines.length > 3
					&& lines[3].equals("§b=-=-=-=-=")) {
				p.getInventory().addItem(new ItemStack[] { red });
				p.getInventory().addItem(new ItemStack[] { brown });
				p.getInventory().addItem(new ItemStack[] { pote });
				p.updateInventory();
			}
		}
	}

	@EventHandler
	public void onPlayerColor(final SignChangeEvent e) {
		if (e.getLine(0).contains("&")) {
			e.setLine(0, e.getLine(0).replace("&", "§"));
		}
		if (e.getLine(1).contains("&")) {
			e.setLine(1, e.getLine(1).replace("&", "§"));
		}
		if (e.getLine(2).contains("&")) {
			e.setLine(2, e.getLine(2).replace("&", "§"));
		}
		if (e.getLine(3).contains("&")) {
			e.setLine(3, e.getLine(3).replace("&", "§"));
		}
	}
}
