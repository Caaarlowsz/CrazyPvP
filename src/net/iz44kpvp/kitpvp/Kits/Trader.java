package net.iz44kpvp.kitpvp.Kits;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.inventory.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.event.block.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.entity.*;

public class Trader extends TraderUtil implements Listener
{
    public static HashMap<String, Integer> coin;
    
    static {
        Trader.coin = new HashMap<String, Integer>();
    }
    
    public static void setCoinTrader(final Player p, final int quantidade) {
        if (!Trader.coin.containsKey(p.getName())) {
            Trader.coin.put(p.getName(), 0);
        }
        else {
            Trader.coin.put(p.getName(), Trader.coin.get(p.getName()) + quantidade);
        }
    }
    
    public static void removeCoinTrader(final Player p, final int quantidade) {
        Trader.coin.put(p.getName(), Trader.coin.get(p.getName()) - quantidade);
    }
    
    public static int getCoinsTrader(final Player p) {
        if (!Trader.coin.containsKey(p.getName())) {
            Trader.coin.put(p.getName(), 0);
        }
        return Trader.coin.get(p.getName());
    }
    
    public static boolean getTrader(final Player p, final int quantidade) {
        return getCoinsTrader(p) >= quantidade;
    }
    
    public static void InvTrader(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§aLoja§7(§eTrader§7)");
        API.darItemInv(inv, Material.IRON_SWORD, 1, 0, "§7Pre\u00e7o: §66 Coins", 0);
        API.darItemInv(inv, Material.LEATHER_HELMET, 1, 0, "§7Pre\u00e7o: §64 Coins", 1);
        API.darItemInv(inv, Material.IRON_CHESTPLATE, 1, 0, "§7Pre\u00e7o: §67 Coins", 2);
        API.darItemInv(inv, Material.LEATHER_LEGGINGS, 1, 0, "§7Pre\u00e7o: §64 Coins", 3);
        API.darItemInv(inv, Material.IRON_BOOTS, 1, 0, "§7Pre\u00e7o: §65 Coins", 4);
        API.darItemInv(inv, Material.POTION, 1, 16428, "§7Pre\u00e7o: §62 Coins", 5);
        API.darItemInv(inv, Material.POTION, 1, 8265, "§7Pre\u00e7o: §63 Coins", 6);
        API.darItemInv(inv, Material.STAINED_GLASS_PANE, 1, 5, " ", 7);
        Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.instance, (Runnable)new Runnable() {
            @Override
            public void run() {
                API.darItemInv(inv, Material.EMERALD, 1, 0, "§7Coins: §6" + Trader.getCoinsTrader(p), 8);
            }
        }, 0L, 20L);
        p.openInventory(inv);
    }
    
    @EventHandler
    public void aotrader(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Trader") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.ENDER_CHEST) {
            InvTrader(p);
        }
    }
    
    @EventHandler
    public void aocomprar(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§aLoja§7(§eTrader§7)") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            if (e.getCurrentItem().getType() == Material.EMERALD) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_SWORD) {
                e.setCancelled(true);
                if (getTrader(p, 6)) {
                    removeCoinTrader(p, 6);
                    TraderUtil.darItemTroca(p, Material.IRON_SWORD, 0);
                }
                else {
                    TraderUtil.MsgSemTrader(p);
                }
                return;
            }
            if (e.getCurrentItem().getType() == Material.LEATHER_HELMET) {
                e.setCancelled(true);
                if (getTrader(p, 4)) {
                    removeCoinTrader(p, 4);
                    TraderUtil.darItemTroca(p, Material.LEATHER_HELMET, 0);
                }
                else {
                    TraderUtil.MsgSemTrader(p);
                }
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_CHESTPLATE) {
                e.setCancelled(true);
                if (getTrader(p, 7)) {
                    removeCoinTrader(p, 7);
                    TraderUtil.darItemTroca(p, Material.IRON_CHESTPLATE, 0);
                }
                else {
                    TraderUtil.MsgSemTrader(p);
                }
                return;
            }
            if (e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS) {
                e.setCancelled(true);
                if (getTrader(p, 4)) {
                    removeCoinTrader(p, 4);
                    TraderUtil.darItemTroca(p, Material.LEATHER_LEGGINGS, 0);
                }
                else {
                    TraderUtil.MsgSemTrader(p);
                }
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
                e.setCancelled(true);
                if (getTrader(p, 5)) {
                    removeCoinTrader(p, 5);
                    TraderUtil.darItemTroca(p, Material.LEATHER_HELMET, 0);
                }
                else {
                    TraderUtil.MsgSemTrader(p);
                }
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Pre\u00e7o: §62 Coins")) {
                e.setCancelled(true);
                if (getTrader(p, 2)) {
                    removeCoinTrader(p, 2);
                    TraderUtil.darItemTroca(p, Material.POTION, 16428);
                }
                else {
                    TraderUtil.MsgSemTrader(p);
                }
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Pre\u00e7o: §63 Coins")) {
                e.setCancelled(true);
                if (getTrader(p, 3)) {
                    removeCoinTrader(p, 3);
                    TraderUtil.darItemTroca(p, Material.POTION, 8265);
                }
                else {
                    TraderUtil.MsgSemTrader(p);
                }
            }
        }
    }
    
    @EventHandler
    public void aomatar(final PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            final Player matou = e.getEntity().getKiller();
            final Player morreu = e.getEntity();
            if (Habilidade.getAbility(morreu).equalsIgnoreCase("Trader")) {
                Trader.coin.remove(morreu.getName());
            }
            if (Habilidade.getAbility(matou).equalsIgnoreCase("Trader")) {
                setCoinTrader(matou, 1);
            }
        }
    }
}
