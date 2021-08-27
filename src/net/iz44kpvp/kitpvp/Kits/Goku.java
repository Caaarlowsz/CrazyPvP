package net.iz44kpvp.kitpvp.Kits;

import java.util.*;
import org.bukkit.event.player.*;
import org.bukkit.event.block.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.potion.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.inventory.*;

public class Goku implements Listener
{
    public static ArrayList<String> emgoku;
    
    static {
        Goku.emgoku = new ArrayList<String>();
    }
    
    @EventHandler
    public void aoGoku(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (Habilidade.getAbility(p).equalsIgnoreCase("Goku") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInHand().getType() == Material.GOLD_NUGGET) {
            if (Cooldown.add(p)) {
                API.MensagemCooldown(p);
                return;
            }
            p.setAllowFlight(true);
            p.setFlying(true);
            p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, (Object)Material.DIAMOND_BLOCK, 20);
            API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, 100, 0);
            API.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, 100, 1);
            Goku.emgoku.add(p.getName());
            Cooldown.add(p, 30);
            p.getInventory().setHelmet(API.darArmadura(Material.LEATHER_HELMET, Color.YELLOW));
            p.getInventory().setChestplate(API.darArmadura(Material.LEATHER_CHESTPLATE, Color.YELLOW));
            p.getInventory().setLeggings(API.darArmadura(Material.LEATHER_LEGGINGS, Color.YELLOW));
            p.getInventory().setBoots(API.darArmadura(Material.LEATHER_BOOTS, Color.YELLOW));
            p.updateInventory();
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Poder sayajin acabando em: §b5§7s");
                }
            }, 0L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Poder sayajin acabando em: §b4§7s");
                }
            }, 20L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Poder sayajin acabando em: §b3§7s");
                }
            }, 40L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Poder sayajin acabando em: §b2§7s");
                }
            }, 60L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Poder sayajin acabando em: §b1§7s");
                }
            }, 80L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    API.tirarArmadura(p);
                    p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Poder sayajin acabou");
                    Goku.emgoku.remove(p.getName());
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                    p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                }
            }, 100L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.sendMessage(API.fimcooldown);
                }
            }, 600L);
        }
    }
    
    @EventHandler
    public void clickar(final InventoryClickEvent e) {
        try {
            final Player p = (Player)e.getWhoClicked();
            if (Goku.emgoku.contains(p.getName()) && e.getSlotType().equals((Object)InventoryType.SlotType.ARMOR)) {
                e.setCancelled(true);
            }
        }
        catch (Exception ex) {}
    }
}
