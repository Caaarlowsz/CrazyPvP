package net.iz44kpvp.kitpvp.Eventos;

import org.bukkit.event.entity.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.Comandos.*;
import org.bukkit.entity.*;

public class DropEventos implements Listener
{
    @EventHandler
    public void onItemDrop(final ItemSpawnEvent e) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                e.getEntity().remove();
                e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
            }
        }, 20L);
    }
    
    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void aoDropar(final PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.GOLD_SWORD) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.WOOD_AXE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.STONE_AXE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.GOLD_AXE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.IRON_AXE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_AXE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.COMPASS) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.CHEST) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.INK_SACK) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.TORCH) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.GOLD_NUGGET) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.STICK) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.FIREWORK_CHARGE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BONE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.WATCH) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.ENDER_PEARL) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.getMaterial(393)) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.getMaterial(392)) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.PAPER) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.FEATHER) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BEDROCK) {
            e.setCancelled(true);
        }
        final Player p = e.getPlayer();
        if (Admin.emAdmin.contains(p) && e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BEACON) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.WOOL) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_BLOCK) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.GRASS) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.LEASH) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.BOW) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.ARROW) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.GOLDEN_APPLE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.SAND) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.NETHER_FENCE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.ENDER_CHEST) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.EMERALD) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.WORKBENCH) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.STAINED_GLASS_PANE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.SLIME_BALL) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.STONE_BUTTON) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.WOOD_HOE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.MAGMA_CREAM) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.REDSTONE_TORCH_ON) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.IRON_INGOT) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.HOPPER) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.SNOW_BALL) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.PACKED_ICE) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.EYE_OF_ENDER) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.FIREBALL) {
            e.setCancelled(true);
        }
        if (e.getItemDrop().getItemStack().getType() == Material.SNOW_BLOCK) {
            e.setCancelled(true);
        }
    }
}
