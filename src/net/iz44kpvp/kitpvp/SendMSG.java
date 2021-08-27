package net.iz44kpvp.kitpvp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendMSG implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 1; i < args.length; ++i) {
			sb.append(args[i]).append(" ");
		}
		final String motivo = sb.toString().trim();
		if (cmd.getName().equalsIgnoreCase("sendmsg")) {
			final Player t = Bukkit.getPlayer(args[0]);
			if (args.length < 2) {
				sender.sendMessage("§cUse /sendmsg <Player> Mensagem");
				return true;
			}
			t.sendMessage(motivo);
			sender.sendMessage("§aVoce --> " + t.getName() + " : §f " + motivo);
		}
		return false;
	}
}
