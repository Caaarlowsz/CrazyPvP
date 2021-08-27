package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.entity.*;
import org.bukkit.command.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.event.player.*;
import org.bukkit.event.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;
import net.minecraft.util.com.mojang.authlib.*;
import org.bukkit.*;
import net.minecraft.server.v1_7_R4.*;
import java.lang.reflect.*;
import com.google.common.base.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.plugin.*;
import java.util.*;

public class Fake implements Listener, CommandExecutor
{
    public static ArrayList<Player> usandoFake;
    public static HashMap<String, String> fake;
    public static HashMap<Player, Player> nick;
    public static ArrayList<String> fakes;
    
    static {
        Fake.usandoFake = new ArrayList<Player>();
        Fake.fake = new HashMap<String, String>();
        Fake.nick = new HashMap<Player, Player>();
        Fake.fakes = new ArrayList<String>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("fake")) {
                if (p.hasPermission("flame.fake")) {
                    if (args.length == 0) {
                        p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cSintaxe correta: /fake (nome)");
                        return false;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("#")) {
                            if (Fake.usandoFake.contains(p)) {
                                Fake.usandoFake.remove(p);
                                Fake.fakes.remove(p.getName());
                                this.refreshPlayer(p);
                                p.setDisplayName((String)Fake.fake.get(p.getName()));
                                p.setPlayerListName("§f" + Fake.fake.get(p.getName()));
                                mudarNome(p, Fake.fake.get(p.getName()));
                                p.sendMessage("§7Voce resetou seu fake.");
                            }
                        }
                        else if (!Fake.fakes.contains(args[0])) {
                            if (Fake.usandoFake.contains(p)) {
                                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cSintaxe correta: /fake #");
                                return true;
                            }
                            if (args[0].length() > 16) {
                                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cnick grande demais escolha outro");
                                return true;
                            }
                            final String nome = p.getName();
                            Fake.nick.put(p, p);
                            mudarNome(p, args[0]);
                            Fake.usandoFake.add(p);
                            Fake.fakes.add(args[0]);
                            this.refreshPlayer(p);
                            Fake.fake.put(p.getName(), nome);
                            p.setDisplayName(args[0]);
                            p.setPlayerListName(args[0]);
                            p.sendMessage("§7Seu nome agora \u00e9 §a" + args[0]);
                        }
                    }
                }
                else {
                    p.sendMessage(API.semperm);
                }
            }
        }
        else {
            sender.sendMessage(API.semconsole);
        }
        return false;
    }
    
    @EventHandler
    public void sair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (Fake.usandoFake.contains(e.getPlayer())) {
            Fake.usandoFake.remove(p);
            Fake.fakes.remove(p.getName());
            p.setDisplayName((String)Fake.fake.get(p.getName()));
            p.setPlayerListName((String)Fake.fake.get(p.getName()));
            mudarNome(p, Fake.fake.get(p.getName()));
        }
    }
    
    public static void mudarNome(final Player p, final String nome) {
        final EntityPlayer ep = ((CraftPlayer)p).getHandle();
        final PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn((EntityHuman)ep);
        try {
            final Field field = packet.getClass().getDeclaredField("b");
            field.setAccessible(true);
            final GameProfile gameProfile = (GameProfile)field.get(packet);
            final Field name = gameProfile.getClass().getDeclaredField("name");
            name.setAccessible(true);
            name.set(gameProfile, nome);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            p.sendMessage("§cErro ao mudar");
        }
        Player[] arrayOfPlayer;
        for (int name2 = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, gameProfile2 = 0; gameProfile2 < name2; ++gameProfile2) {
            final Player p2 = arrayOfPlayer[gameProfile2];
            if (p2 != p) {
                ((CraftPlayer)p2).getHandle().playerConnection.sendPacket((Packet)packet);
            }
        }
    }
    
    public void refreshPlayer(final Player player) {
        Preconditions.checkState(true, (Object)"Not Enabled!");
        Preconditions.checkNotNull((Object)player, (Object)"player");
        for (final Player playerFor : player.getWorld().getPlayers()) {
            this.refreshPlayer(player, playerFor);
        }
    }
    
    public void refreshPlayer(final Player player, final Player forWhom) {
        Preconditions.checkState(true, (Object)"Not Enabled!");
        Preconditions.checkNotNull((Object)player, (Object)"player");
        Preconditions.checkNotNull((Object)forWhom, (Object)"forWhom");
        if (player != forWhom && player.getWorld() == forWhom.getWorld() && forWhom.canSee(player)) {
            forWhom.hidePlayer(player);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    forWhom.showPlayer(player);
                }
            }, 2L);
        }
    }
    
    public void refreshPlayer(final Player player, final Set<Player> forWhom) {
        Preconditions.checkState(true, (Object)"Not Enabled!");
        Preconditions.checkNotNull((Object)player, (Object)"player");
        Preconditions.checkNotNull((Object)forWhom, (Object)"forWhom");
        for (final Player playerFor : forWhom) {
            this.refreshPlayer(player, playerFor);
        }
    }
}
