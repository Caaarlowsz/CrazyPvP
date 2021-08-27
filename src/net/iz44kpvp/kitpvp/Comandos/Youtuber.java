package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.iz44kpvp.kitpvp.Sistemas.API;

public class Youtuber implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("youtuber")) {
			p.sendMessage(API.MSGYoutuber1);
			p.sendMessage(API.MSGYoutuber2);
			p.sendMessage(API.MSGYoutuber3);
		}
		return false;
	}
}
