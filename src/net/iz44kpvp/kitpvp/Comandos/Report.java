package net.iz44kpvp.kitpvp.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.iz44kpvp.kitpvp.Sistemas.API;

public class Report implements CommandExecutor {
	public String[] aliases;
	public String description;
	public static ArrayList<String> reportou;

	static {
		Report.reportou = new ArrayList<String>();
	}

	public Report() {
		this.aliases = new String[] { "report" };
		this.description = "Reportar";
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player p = (Player) sender;
		if (args.length < 2) {
			p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cSintaxe correta: /report (nome) (motivo)");
		} else if (args.length >= 2) {
			final Player t = Bukkit.getPlayer(args[0]);
			if (t == null) {
				p.sendMessage(API.jogadoroff);
			} else {
				final StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; ++i) {
					sb.append(args[i]).append(" ");
				}
				final String motivo = sb.toString().trim();
				Report.reportou.contains(sender.getName());
				sender.sendMessage(
						String.valueOf(String.valueOf(API.preffix)) + "§bVoc\u00ea reportou: §5" + t.getDisplayName());
				Player[] onlinePlayers;
				for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length,
						j = 0; j < length; ++j) {
					final Player todos = onlinePlayers[j];
					if (todos.hasPermission("flame.reportver")) {
						todos.sendMessage("§7-----------§5Report§7-----------");
						todos.sendMessage("§bReporter: §c" + p.getDisplayName());
						todos.sendMessage("§bReportado: §c" + t.getDisplayName());
						todos.sendMessage("§bMotivo: §c" + motivo);
						todos.sendMessage("§7-----------§5Report§7-----------");
					}
				}
			}
		}
		return true;
	}
}
