package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class UnCage implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        final Player t = Bukkit.getPlayer(args[0]);
        if (cmd.getName().equalsIgnoreCase("uncage")) {
            if (p.hasPermission("flame.staff")) {
                if (args.length == 1) {
                    Admin.hacks.remove(t.getName());
                    p.sendMessage("§cVoc\u00ea liberou o jogador: " + t.getName());
                    t.sendMessage("§aO Staff: §f" + p.getName() + " §aLiberou Voc\u00ea!");
                }
                else {
                    p.sendMessage("§cUse /uncage <jogador>");
                }
            }
            else {
                p.sendMessage("§cVoc\u00ea n\u00e3o tem permiss\u00e3o para usar esse comando!");
            }
        }
        return false;
    }
}
