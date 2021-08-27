package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import net.iz44kpvp.kitpvp.Sistemas.API;

public class Head implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("head") && p.hasPermission("flame.staff")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Sintaxe correta: /head <player>");
				return true;
			}
			final Player t = Bukkit.getPlayer(args[0]);
			if (t == null) {
				p.sendMessage(API.jogadoroff);
				return true;
			}
			final ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
			skullItem.setDurability((short) 3);
			final SkullMeta skullMeta = (SkullMeta) skullItem.getItemMeta();
			skullMeta.setOwner(t.getName());
			skullItem.setItemMeta((ItemMeta) skullMeta);
			p.getInventory().addItem(new ItemStack[] { skullItem });
			p.sendMessage("§7Voce a head do player: §c" + t.getName());
		}
		return false;
	}
}
