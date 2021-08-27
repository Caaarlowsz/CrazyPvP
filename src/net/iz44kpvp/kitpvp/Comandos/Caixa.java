package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import org.bukkit.*;

public class Caixa implements CommandExecutor
{
    public static String simbonaosuavel;
    public static String sonumeros;
    public static String naousar;
    public static String semquantia;
    public static String sintaxedar;
    public static String sintaxedoar;
    
    static {
        Caixa.simbonaosuavel = String.valueOf(String.valueOf(API.preffix)) + "§cSimbolo nao usavel";
        Caixa.sonumeros = String.valueOf(String.valueOf(API.preffix)) + "§cSo e possivel usar numeros";
        Caixa.naousar = String.valueOf(String.valueOf(API.preffix)) + "§cNao pode usar nome como doacao";
        Caixa.semquantia = String.valueOf(String.valueOf(API.preffix)) + "§cVoc\u00ea nao tem a quantia suficiente de caixa(s) que quer doar";
        Caixa.sintaxedar = String.valueOf(String.valueOf(API.preffix)) + "§cSintaxe correta: /caixa dar <nome> <quantidade>";
        Caixa.sintaxedoar = String.valueOf(String.valueOf(API.preffix)) + "§cSintaxe correta: /caixa doar <nome> <quantidade>";
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(API.semconsole);
            return true;
        }
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("caixa")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Caixa(s): §5" + KillsDeathsRankXp.getCaixa(p));
                return true;
            }
            if (args.length == 1) {
                if (p.hasPermission("flame.darcaixa")) {
                    p.sendMessage(Caixa.sintaxedar);
                }
                p.sendMessage(Caixa.sintaxedoar);
                return true;
            }
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("dar")) {
                    if (p.hasPermission("flame.darcaixa")) {
                        p.sendMessage(Caixa.sintaxedar);
                    }
                }
                else if (args[0].equalsIgnoreCase("doar")) {
                    p.sendMessage(Caixa.sintaxedoar);
                }
                else {
                    if (p.hasPermission("flame.darcaixa")) {
                        p.sendMessage(Caixa.sintaxedar);
                    }
                    p.sendMessage(Caixa.sintaxedoar);
                }
                return true;
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("dar")) {
                    if (p.hasPermission("flame.darcaixa")) {
                        try {
                            final int caixa = Integer.valueOf(args[2]);
                            final Player t = Bukkit.getPlayerExact(args[1]);
                            if (t != null) {
                                if (args[2].contains("-")) {
                                    p.sendMessage(Caixa.simbonaosuavel);
                                    return true;
                                }
                                KillsDeathsRankXp.adicionarCaixa(t, caixa);
                                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea deu §5" + caixa + "§7 Caixa(s) para o(a) §5" + t.getDisplayName());
                                t.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Um(Uma) staffer te deu §5" + caixa + " §7Caixa(s)");
                            }
                            else {
                                p.sendMessage(API.jogadoroff);
                            }
                        }
                        catch (Exception e) {
                            p.sendMessage(Caixa.sonumeros);
                        }
                    }
                }
                else if (args[0].equalsIgnoreCase("doar")) {
                    try {
                        final int caixa = Integer.valueOf(args[2]);
                        final Player t = Bukkit.getPlayerExact(args[1]);
                        if (t != null) {
                            if (args[2].contains("-")) {
                                p.sendMessage(Caixa.simbonaosuavel);
                                return true;
                            }
                            if (KillsDeathsRankXp.getCaixa(p) >= caixa) {
                                KillsDeathsRankXp.adicionarCaixa(t, caixa);
                                KillsDeathsRankXp.removerCaixa(p, caixa);
                                t.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7O(A) §e" + p.getDisplayName() + " §7te deu §5" + caixa + " §7Caixa(s)");
                                p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§7Voc\u00ea deu §5" + caixa + " §7Caixa(s) para o(a) §e" + t.getDisplayName());
                            }
                            else {
                                p.sendMessage(Caixa.semquantia);
                            }
                        }
                        else {
                            p.sendMessage(API.jogadoroff);
                        }
                    }
                    catch (Exception e) {
                        p.sendMessage(Caixa.sonumeros);
                    }
                }
                else {
                    if (p.hasPermission("flame.darcaixa")) {
                        p.sendMessage(Caixa.sintaxedar);
                    }
                    p.sendMessage(Caixa.sintaxedoar);
                }
                return true;
            }
            if (p.hasPermission("flame.darcaixa")) {
                p.sendMessage(Caixa.sintaxedar);
            }
            p.sendMessage(Caixa.sintaxedoar);
        }
        return false;
    }
}
