package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.Sistemas.*;

public class Status implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("status")) {
            return false;
        }
        if (args.length == 0) {
            p.sendMessage("§7Seus Status:");
            p.sendMessage("§b        ");
            p.sendMessage("§bRank: " + KillsDeathsRankXp.getRank(p));
            p.sendMessage("§bXp: §5" + KillsDeathsRankXp.getXp(p));
            p.sendMessage("§bKills: §5" + KillsDeathsRankXp.getKills(p));
            p.sendMessage("§bDeaths: §5" + KillsDeathsRankXp.getDeaths(p));
            return true;
        }
        final Player t = Bukkit.getPlayer(args[0]);
        if (t == null) {
            p.sendMessage(API.jogadoroff);
            return true;
        }
        p.sendMessage("§7Status De: §c" + t.getDisplayName());
        p.sendMessage("§b        ");
        p.sendMessage("§bRank: " + KillsDeathsRankXp.getRank(t));
        p.sendMessage("§bXp: §5" + KillsDeathsRankXp.getXp(t));
        p.sendMessage("§bKills: §5" + KillsDeathsRankXp.getKills(t));
        p.sendMessage("§bDeaths: §5" + KillsDeathsRankXp.getDeaths(t));
        return true;
    }
}
