package net.iz44kpvp.kitpvp.Sistemas;

import org.bukkit.entity.*;
import org.bukkit.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.*;

public class KillsDeathsRankXp
{
    public static String getRankPequeno(final Player p) {
        final double a = getKills(p);
        if (a <= 0.0) {
            return ChatColor.DARK_GRAY + "\u2717";
        }
        if (a <= 75.0) {
            return ChatColor.GREEN + "\u2725";
        }
        if (a <= 130.0) {
            return ChatColor.GREEN + "\u2725";
        }
        if (a <= 150.0) {
            return ChatColor.GREEN + "\u2725";
        }
        if (a <= 180.0) {
            return ChatColor.GREEN + "\u2725";
        }
        if (a <= 200.0) {
            return ChatColor.GRAY + "\u2723";
        }
        if (a <= 215.0) {
            return ChatColor.GRAY + "\u2723";
        }
        if (a <= 230.0) {
            return ChatColor.GRAY + "\u2723";
        }
        if (a <= 250.0) {
            return ChatColor.GRAY + "\u2723";
        }
        if (a <= 280.0) {
            return ChatColor.GRAY + "\u2723";
        }
        if (a <= 300.0) {
            return ChatColor.YELLOW + "\u2724";
        }
        if (a <= 315.0) {
            return ChatColor.YELLOW + "\u2724";
        }
        if (a <= 330.0) {
            return ChatColor.YELLOW + "\u2724";
        }
        if (a <= 350.0) {
            return ChatColor.YELLOW + "\u2724";
        }
        if (a <= 380.0) {
            return ChatColor.YELLOW + "\u2724";
        }
        if (a <= 400.0) {
            return ChatColor.AQUA + "\u272a";
        }
        if (a <= 415.0) {
            return ChatColor.AQUA + "\u272a";
        }
        if (a <= 430.0) {
            return ChatColor.AQUA + "\u272a";
        }
        if (a <= 450.0) {
            return ChatColor.AQUA + "\u272a";
        }
        if (a <= 480.0) {
            return ChatColor.AQUA + "\u272a";
        }
        if (a <= 500.0) {
            return ChatColor.GOLD + "\u2742";
        }
        if (a <= 515.0) {
            return ChatColor.GOLD + "\u2742";
        }
        if (a <= 530.0) {
            return ChatColor.GOLD + "\u2742";
        }
        if (a <= 550.0) {
            return ChatColor.GOLD + "\u2742";
        }
        if (a <= 580.0) {
            return ChatColor.GOLD + "\u2742";
        }
        if (a <= 600.0) {
            return ChatColor.RED + "\u273e";
        }
        return ChatColor.RED + "\u273e";
    }
    
    public static String getRank(final Player p) {
        final double a = getKills(p);
        if (a <= 0.0) {
            return ChatColor.DARK_GRAY + "\u2717 Unranked";
        }
        if (a <= 75.0) {
            return ChatColor.GREEN + "\u2725 Bronze";
        }
        if (a <= 130.0) {
            return ChatColor.GREEN + "\u2725 Bronze";
        }
        if (a <= 150.0) {
            return ChatColor.GREEN + "\u2725 Bronze";
        }
        if (a <= 180.0) {
            return ChatColor.GREEN + "\u2725 Bronze";
        }
        if (a <= 200.0) {
            return ChatColor.GRAY + "\u2723 Silver";
        }
        if (a <= 215.0) {
            return ChatColor.GRAY + "\u2723 Silver";
        }
        if (a <= 230.0) {
            return ChatColor.GRAY + "\u2723 Silver";
        }
        if (a <= 250.0) {
            return ChatColor.GRAY + "\u2723 Silver";
        }
        if (a <= 280.0) {
            return ChatColor.GRAY + "\u2723 Silver";
        }
        if (a <= 300.0) {
            return ChatColor.YELLOW + "\u2724 Gold";
        }
        if (a <= 315.0) {
            return ChatColor.YELLOW + "\u2724 Gold";
        }
        if (a <= 330.0) {
            return ChatColor.YELLOW + "\u2724 Gold";
        }
        if (a <= 350.0) {
            return ChatColor.YELLOW + "\u2724 Gold";
        }
        if (a <= 380.0) {
            return ChatColor.YELLOW + "\u2724 Gold";
        }
        if (a <= 400.0) {
            return ChatColor.AQUA + "\u272a Diamond";
        }
        if (a <= 415.0) {
            return ChatColor.AQUA + "\u272a Diamond";
        }
        if (a <= 430.0) {
            return ChatColor.AQUA + "\u272a Diamond";
        }
        if (a <= 450.0) {
            return ChatColor.AQUA + "\u272a Diamond";
        }
        if (a <= 480.0) {
            return ChatColor.AQUA + "\u272a Diamond";
        }
        if (a <= 500.0) {
            return ChatColor.GOLD + "\u2742 Emerald";
        }
        if (a <= 515.0) {
            return ChatColor.GOLD + "\u2742 Emerald";
        }
        if (a <= 530.0) {
            return ChatColor.GOLD + "\u2742 Emerald";
        }
        if (a <= 550.0) {
            return ChatColor.GOLD + "\u2742 Emerald";
        }
        if (a <= 580.0) {
            return ChatColor.GOLD + "\u2742 Emerald";
        }
        if (a <= 600.0) {
            return ChatColor.RED + "\u273e Ruby";
        }
        return ChatColor.RED + "\u273e Ruby";
    }
    
    public static void adicionarKill(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".Matou");
        Main.getInstance().status.set(String.valueOf(String.valueOf(p.getName())) + ".Matou", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void adicionarDeaths(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".Morreu");
        Main.getInstance().status.set(String.valueOf(String.valueOf(p.getName())) + ".Morreu", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void adicionarXp(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".XP");
        Main.getInstance().status.set(String.valueOf(String.valueOf(p.getName())) + ".XP", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void removerXp(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".XP");
        Main.getInstance().status.set(String.valueOf(String.valueOf(p.getName())) + ".XP", (Object)(Value - i));
        Main.getInstance().save();
    }
    
    public static void adicionarCaixa(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".Caixa");
        Main.getInstance().status.set(String.valueOf(String.valueOf(p.getName())) + ".Caixa", (Object)(Value + i));
        Main.getInstance().save();
    }
    
    public static void removerCaixa(final Player p, final int i) {
        final int Value = Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".Caixa");
        Main.getInstance().status.set(String.valueOf(String.valueOf(p.getName())) + ".Caixa", (Object)(Value - i));
        Main.getInstance().save();
    }
    
    public static int getKills(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".Matou");
    }
    
    public static int getDeaths(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".Morreu");
    }
    
    public static int getXp(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".XP");
    }
    
    public static int getCaixa(final Player p) {
        return Main.getInstance().status.getInt(String.valueOf(String.valueOf(p.getName())) + ".Caixa");
    }
    
    public static int getPing(final Player p) {
        return ((CraftPlayer)p).getHandle().ping;
    }
}
