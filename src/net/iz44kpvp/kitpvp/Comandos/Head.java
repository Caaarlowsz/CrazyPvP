package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.event.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;

public class Head implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("head") && p.hasPermission("flame.staff")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Sintaxe correta: /head <player>");
                return true;
            }
            final Player t = Bukkit.getPlayer(args[0]);
            if (t == null) {
                p.sendMessage(API.jogadoroff);
                return true;
            }
            final ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
            skullItem.setDurability((short)3);
            final SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
            skullMeta.setOwner(t.getName());
            skullItem.setItemMeta((ItemMeta)skullMeta);
            p.getInventory().addItem(new ItemStack[] { skullItem });
            p.sendMessage("§7Voce a head do player: §c" + t.getName());
        }
        return false;
    }
}
