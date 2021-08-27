package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.iz44kpvp.kitpvp.Sistemas.KillsDeathsRankXp;

public class Kills implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (cmd.getName().equalsIgnoreCase("kills")) {
			if (!(sender instanceof CommandSender)) {
				sender.sendMessage(
						"§cPara Seguran\u00e7a do Servidor Esse Comando S\u00f3 Pode Ser Executado Pelo CONSOLE!");
				return true;
			}
			if (args.length < 3) {
				sender.sendMessage("§cUse /kills dar <jogador> <quantia>");
				return true;
			}
			final int tanto = Integer.valueOf(args[2]);
			final Player t = Bukkit.getPlayer(args[1]);
			if (args[0].equalsIgnoreCase("dar")) {
				try {
					KillsDeathsRankXp.adicionarKill(t, tanto);
					sender.sendMessage("§aVoc\u00ea Deu " + tanto + " De Kills Para O Jogador " + t.getName());
					t.sendMessage(String.valueOf(tanto) + " §aKills Fora Adicionadas A Sua Conta!");
				} catch (Exception e) {
					sender.sendMessage("§cUse Somente Numeros!");
				}
			} else {
				sender.sendMessage("§cUse /kills dar <jogador> <quantia>");
			}
		}
		return false;
	}
}
