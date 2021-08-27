package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.Guis.*;

public class Rank implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("rank")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Seu rank \u00e9: " + KillsDeathsRankXp.getRank(p));
                return true;
            }
            if (args.length > 0 && args.length < 2) {
                final Player t = Bukkit.getServer().getPlayer(args[0]);
                if (t != null) {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7O rank de: §5" + t.getDisplayName() + " §7\u00e9: " + KillsDeathsRankXp.getRank(t));
                    return true;
                }
            }
            if (args[0].equalsIgnoreCase("info")) {
                GuiRank.GuiRanks(p);
            }
        }
        return false;
    }
}
