package net.iz44kpvp.kitpvp.Comandos;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.iz44kpvp.kitpvp.ScoreBoard.ScoreBoard;
import net.iz44kpvp.kitpvp.Sistemas.API;

public class Score extends ScoreBoard implements CommandExecutor {
	public static ArrayList<String> temscore;
	public static ArrayList<String> ntemscore;

	static {
		Score.temscore = new ArrayList<String>();
		Score.ntemscore = new ArrayList<String>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("score")) {
			if (!Score.ntemscore.contains(p.getName())) {
				Score.ntemscore.add(p.getName());
				Score.temscore.remove(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bScore Adicionada");
			} else {
				Score.temscore.add(p.getName());
				Score.ntemscore.remove(p.getName());
				p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§5Score Removida");
			}
		}
		return false;
	}
}
