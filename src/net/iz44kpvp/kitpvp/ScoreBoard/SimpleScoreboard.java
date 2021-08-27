package net.iz44kpvp.kitpvp.ScoreBoard;

import org.bukkit.*;
import org.bukkit.scoreboard.*;
import org.bukkit.entity.*;

public class SimpleScoreboard
{
    private Objective obj;
    private Scoreboard sb;
    
    private String gerarTimeNome(final Scoreboard sb) {
        String timeNome = "time";
        timeNome = String.valueOf(String.valueOf(timeNome)) + sb.getTeams().size() + 1;
        return timeNome;
    }
    
    public SimpleScoreboard(final String titulo) {
        this.sb = Bukkit.getScoreboardManager().getNewScoreboard();
        (this.obj = this.sb.registerNewObjective("scoreboardutils", "davidev")).setDisplayName(titulo);
        this.obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    }
    
    public void addLinha(final String texto, final int linha) {
        final int n = texto.length();
        Score s = null;
        Team t = null;
        if (n <= 16) {
            s = this.obj.getScore(Bukkit.getOfflinePlayer(texto));
        }
        else if (n > 16 && n < 32) {
            t = this.sb.registerNewTeam(this.gerarTimeNome(this.sb));
            t.setPrefix(texto.substring(0, 16));
            final String nome = texto.substring(16);
            t.addPlayer(Bukkit.getOfflinePlayer(nome));
            s = this.obj.getScore(Bukkit.getOfflinePlayer(nome));
        }
        else if (n > 32) {
            t = this.sb.registerNewTeam(this.gerarTimeNome(this.sb));
            t.setPrefix(texto.substring(0, 16));
            t.setSuffix(texto.substring(32));
            final String nome = texto.substring(16, 32);
            t.addPlayer(Bukkit.getOfflinePlayer(nome));
            s = this.obj.getScore(Bukkit.getOfflinePlayer(nome));
        }
        s.setScore(linha);
    }
    
    public Scoreboard getScoreboard() {
        return this.sb;
    }
    
    public void setScoreboard(final Player p) {
        p.setScoreboard(this.sb);
    }
    
    public void setScoreboard(final Player... p) {
        for (final Player pl : p) {
            pl.setScoreboard(this.sb);
        }
    }
}
