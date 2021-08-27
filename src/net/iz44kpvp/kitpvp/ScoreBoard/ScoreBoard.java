package net.iz44kpvp.kitpvp.ScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import net.iz44kpvp.kitpvp.Eventos.CombatLog;
import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.KillsDeathsRankXp;

public class ScoreBoard {
	public static void FlameScore(final Player p) {
		final String jogadoronline = String.valueOf(String.valueOf(Bukkit.getServer().getOnlinePlayers().length))
				+ "§7/§e" + Bukkit.getServer().getMaxPlayers();
		final SimpleScoreboard ftw = new SimpleScoreboard(API.NomeServer);
		ftw.addLinha("§3 ", 13);
		ftw.addLinha("§7Matou: §e" + KillsDeathsRankXp.getKills(p), 12);
		ftw.addLinha("§7Morreu: §e" + KillsDeathsRankXp.getDeaths(p), 11);
		ftw.addLinha("§7Jogadores: §e" + jogadoronline, 10);
		ftw.addLinha("§e ", 9);
		ftw.addLinha("§7Kit: §e" + API.getKit(p), 8);
		ftw.addLinha("§7Combate: " + CombatLog.statuscombat(p), 7);
		ftw.addLinha("§7Ping: §e" + KillsDeathsRankXp.getPing(p), 6);
		ftw.addLinha("§7 ", 5);
		ftw.addLinha("§7Rank: §e" + KillsDeathsRankXp.getRank(p), 4);
		ftw.addLinha("§7XP: §e" + KillsDeathsRankXp.getXp(p), 3);
		ftw.addLinha("§7Caixas: §e" + KillsDeathsRankXp.getCaixa(p), 2);
		ftw.addLinha("§f ", 1);
		ftw.addLinha("§e/score", 0);
		ftw.setScoreboard(p);
		final Objective o = ftw.getScoreboard().registerNewObjective("health", "health");
		o.setDisplayName(ChatColor.GREEN + "\u2764");
		o.setDisplaySlot(DisplaySlot.BELOW_NAME);
	}
}
