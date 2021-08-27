package net.iz44kpvp.kitpvp.Eventos;

import org.bukkit.event.weather.*;
import org.bukkit.event.*;
import org.bukkit.help.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.event.block.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;

public class Naturais implements Listener
{
    @EventHandler
    public void onFome(final FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onChuva(final WeatherChangeEvent e) {
        if (e.toWeatherState()) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onDamage(final EntityDamageEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.VOID) {
            final Player p = (Player)e.getEntity();
            p.setHealth(0.0);
        }
    }
    
    @EventHandler
    public void onFogoNaoNoChao(final BlockIgniteEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void digitarComando(final PlayerCommandPreprocessEvent e) {
        e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
        if (!event.isCancelled()) {
            final Player player = event.getPlayer();
            final String cmd = event.getMessage().split(" ")[0];
            final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
            if (topic == null) {
                player.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cEsse comando nao existe!");
                player.playSound(player.getLocation(), Sound.BAT_DEATH, 1.0f, 1.0f);
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onSopa(final PlayerInteractEvent e) {
        final ItemStack pote = new ItemStack(Material.BOWL, 1);
        final ItemMeta kpote = pote.getItemMeta();
        kpote.setDisplayName("§7Pote");
        pote.setItemMeta(kpote);
        final Damageable hp;
        final Player p = (Player)(hp = (Damageable)e.getPlayer());
        if (hp.getHealth() != 20.0) {
            final int sopa = 7;
            if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getTypeId() == 282) {
                p.setHealth((hp.getHealth() + 7.0 > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + 7.0));
                if (!Habilidade.getAbility(p).equalsIgnoreCase("QuickDropper")) {
                    p.getItemInHand().setItemMeta(kpote);
                    p.getItemInHand().setType(Material.BOWL);
                }
                else {
                    p.getItemInHand().setType(Material.BOWL);
                    p.getPlayer().getInventory().remove(p.getItemInHand());
                    p.getInventory().remove(new ItemStack(Material.BOWL, 1));
                    p.getLocation().getWorld().dropItem(p.getEyeLocation(), new ItemStack(Material.BOWL));
                    p.updateInventory();
                }
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onCreeperExplosion(final EntityExplodeEvent event) {
        event.setCancelled(true);
    }
    
    @EventHandler
    public void NaoSpawnarMobs(final CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Creeper) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Skeleton) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Spider) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Wither) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Zombie) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Slime) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Ghast) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof PigZombie) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Pig) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Enderman) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof CaveSpider) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Silverfish) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Blaze) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof MagmaCube) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Witch) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Sheep) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Cow) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Chicken) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Squid) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof MushroomCow) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Ocelot) {
            e.setCancelled(true);
        }
        if (e.getEntity() instanceof Villager) {
            e.setCancelled(false);
        }
        if (e.getEntity() instanceof Horse) {
            e.setCancelled(false);
        }
        if (e.getEntity() instanceof EnderDragon) {
            e.setCancelled(true);
        }
    }
}
