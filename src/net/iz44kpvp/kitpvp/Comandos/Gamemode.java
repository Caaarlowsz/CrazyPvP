package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class Gamemode implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
            if (sender instanceof ConsoleCommandSender) {
                System.out.println(API.semconsole);
                return true;
            }
            final Player p = (Player)sender;
            if (args.length == 0) {
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cUse: §8/gm,gamemode 0 | 1 ");
            }
            else if (args.length == 1) {
                if (p.hasPermission("flame.gm") || p.isOp()) {
                    if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("criativo")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bVoce Entrou No Modo §eCriativo");
                    }
                    else if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("sobrevivencia")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bVoce Entrou No Modo §cSobrebivencia");
                    }
                    else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("aventura")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bVoce Entrou No Modo §aAventura");
                    }
                    else {
                        p.sendMessage(API.jogadoroff);
                    }
                }
                else {
                    p.sendMessage(API.semperm);
                }
            }
        }
        return false;
    }
}
