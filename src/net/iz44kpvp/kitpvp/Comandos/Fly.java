package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;

public class Fly implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (p.hasPermission("flame.fly")) {
                if (args.length == 0) {
                    if (!p.getAllowFlight()) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§5Voc\u00ea ativou seu fly");
                    }
                    else {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bVoc\u00ea desativou seu fly");
                    }
                }
                else {
                    final Player target = p.getServer().getPlayer(args[0]);
                    if (target != null) {
                        if (!target.getAllowFlight()) {
                            target.setAllowFlight(true);
                            target.setFlying(true);
                            target.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bO(A) jogador(a): §5" + p.getDisplayName() + " §bativou seu fly");
                            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bVoc\u00ea ativou o fly de: §5" + target.getDisplayName());
                        }
                        else {
                            target.setAllowFlight(false);
                            target.setAllowFlight(false);
                            target.setFlying(false);
                            target.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bO(A) jogador(a): §5" + p.getDisplayName() + " §bdesativou seu fly");
                            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§bVoc\u00ea desativou o fly de: §5" + target.getDisplayName());
                        }
                    }
                    else {
                        p.sendMessage(API.jogadoroff);
                    }
                }
            }
            else {
                p.sendMessage(API.semperm);
            }
        }
        return false;
    }
}
