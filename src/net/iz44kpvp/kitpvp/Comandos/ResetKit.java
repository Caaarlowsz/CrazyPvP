package net.iz44kpvp.kitpvp.Comandos;

import java.util.*;
import org.bukkit.command.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import net.iz44kpvp.kitpvp.Kits.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.*;

public class ResetKit implements CommandExecutor
{
    public static ArrayList<String> jaresetou;
    
    static {
        ResetKit.jaresetou = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("resetkit")) {
            if (p.hasPermission("flame.resetkit")) {
                if (ResetKit.jaresetou.contains(p.getName())) {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cEspere um pouco para resetar de kit novamente");
                    return true;
                }
                ResetKit.jaresetou.add(p.getName());
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aVoc\u00ea resetou seu kit");
                p.teleport(p.getWorld().getSpawnLocation());
                p.getInventory().clear();
                API.ItemServer(p);
                Habilidade.removeAbility(p);
                Cooldown.remove(p);
                p.setHealth(20.0);
                p.setFireTicks(0);
                p.setFoodLevel(20);
                p.setAllowFlight(false);
                p.setFlying(false);
                API.tirarArmadura(p);
                FlashBack.salvarinv.remove(p.getName());
                FlashBack.salvarlocal.remove(p.getName());
                p.setGameMode(GameMode.SURVIVAL);
                if (C4.bomba.containsKey(p.getName())) {
                    final Item item = C4.bomba.get(p.getName());
                    item.remove();
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        ResetKit.jaresetou.remove(p.getName());
                        p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aJ\u00e1 pode resetar seu kit novamente");
                    }
                }, 100L);
                return true;
            }
            else {
                p.sendMessage(API.semperm);
            }
        }
        return false;
    }
}
