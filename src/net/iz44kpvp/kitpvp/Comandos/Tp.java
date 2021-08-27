package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.entity.*;

public class Tp implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("tp")) {
            if (p.hasPermission("flame.tp")) {
                final Player t = Bukkit.getPlayer(args[0]);
                if (t == null) {
                    p.sendMessage(API.jogadoroff);
                    return true;
                }
                p.teleport((Entity)t);
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea se teleportou para: §c" + t.getName());
            }
            else {
                p.sendMessage(API.semperm);
            }
        }
        if (cmd.getName().equalsIgnoreCase("tphere")) {
            if (p.hasPermission("flame.tp")) {
                if (args.length == 0) {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Sintaxe correta: /tp here <player>");
                    return true;
                }
                final Player t = Bukkit.getPlayer(args[0]);
                if (t == null) {
                    p.sendMessage(API.jogadoroff);
                    return true;
                }
                t.teleport((Entity)p);
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea puxou: §c" + t.getName());
            }
            else {
                p.sendMessage(API.semperm);
            }
        }
        if (cmd.getName().equalsIgnoreCase("tpall")) {
            if (p.hasPermission("flame.tp")) {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player todos = onlinePlayers[i];
                    todos.teleport((Entity)p);
                }
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea puxou todos os players para voc\u00ea");
                Bukkit.broadcastMessage("§6§lTODOS OS PLAYERS FORAM PUXADOS");
            }
            else {
                p.sendMessage(API.semperm);
            }
        }
        return false;
    }
}
