package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.iz44kpvp.kitpvp.Sistemas.API;

public class TogglePvP implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("pvp")) {
			if (p.hasPermission("flame.staff")) {
				if (args.length == 0) {
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cSintaxe correta: /pvp (on/off)");
					return true;
				}
				if (args[0].equalsIgnoreCase("on")) {
					Bukkit.getWorld("world").setPVP(true);
					Bukkit.broadcastMessage(String.valueOf(String.valueOf(API.preffix)) + "§aPvP Ativado");
				}
				if (args[0].equalsIgnoreCase("off")) {
					Bukkit.getWorld("world").setPVP(false);
					Bukkit.broadcastMessage(String.valueOf(String.valueOf(API.preffix)) + "§cPvP Desativado");
				}
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}
}
