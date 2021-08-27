package net.iz44kpvp.kitpvp.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.iz44kpvp.kitpvp.Main;
import net.iz44kpvp.kitpvp.Sistemas.API;

public class ClearChat implements CommandExecutor {
	public static ArrayList<String> emcc;

	static {
		ClearChat.emcc = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("cc")) {
			if (p.hasPermission("flame.staff")) {
				if (ClearChat.emcc.contains(p.getName())) {
					p.sendMessage(
							String.valueOf(String.valueOf(API.preffix)) + "§cEspere para limpar o chat novamente");
					return true;
				}
				for (int i = 0; i < 100; ++i) {
					Bukkit.broadcastMessage(" ");
				}
				Bukkit.broadcastMessage("§e§lO CHAT FOI LIMPO");
				Bukkit.broadcast("§b" + p.getDisplayName() + " §7Limpou o chat", "sword.clearchat");
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aVoc\u00ea limpou o chat");
				ClearChat.emcc.add(p.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						ClearChat.emcc.remove(p.getName());
						p.sendMessage(
								String.valueOf(String.valueOf(API.preffix)) + "§aJ\u00e1 pode limpar o chat novamente");
					}
				}, 140L);
			} else {
				p.sendMessage(API.semperm);
			}
		}
		return false;
	}
}
