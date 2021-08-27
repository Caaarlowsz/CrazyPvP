package net.iz44kpvp.kitpvp.Comandos;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.iz44kpvp.kitpvp.Sistemas.API;
import net.iz44kpvp.kitpvp.Sistemas.TagsAPI;

public class Tag implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(API.semconsole);
			return true;
		}
		final Player p = (Player) sender;
		if (args.length != 0) {
			if (args[0].equalsIgnoreCase("dono")) {
				if (p.hasPermission("tag.dono")) {
					TagsAPI.setarTag(p, "§4§lDONO §7");
					p.setPlayerListName("§4" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("coder")) {
				if (p.getName().equalsIgnoreCase("IZ44KPvP_")) {
					TagsAPI.setarTag(p, "§e§lCODER §7");
					p.setPlayerListName("§e" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada -> IZ44KPvP_ :D");
					return true;
				}
				p.kickPlayer("§eVoc\u00ea n\u00e3o e o coder desse servidor");
			}
			if (args[0].equalsIgnoreCase("subdono")) {
				if (p.hasPermission("tag.subdono")) {
					TagsAPI.setarTag(p, "§c§lSUB§4DONO §7");
					p.setPlayerListName("§4" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("tag.admin")) {
					TagsAPI.setarTag(p, "§c§lADMIN §7");
					p.setPlayerListName("§c" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("tag.mod")) {
					TagsAPI.setarTag(p, "§5§lMOD §7");
					p.setPlayerListName("§5" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("tag.trial")) {
					TagsAPI.setarTag(p, "§d§lTRIAL §7");
					p.setPlayerListName("§d" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("builder")) {
				if (p.hasPermission("tag.builder")) {
					TagsAPI.setarTag(p, "§2§lBUILDER §7");
					p.setPlayerListName("§2" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("tag.youtuber")) {
					TagsAPI.setarTag(p, "§b§lYT §7");
					p.setPlayerListName("§b" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("youtuber+")) {
				if (p.hasPermission("tag.youtuber+")) {
					TagsAPI.setarTag(p, "§3§lYT+ §7");
					p.setPlayerListName("§3" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("pro")) {
				if (p.hasPermission("tag.pro")) {
					TagsAPI.setarTag(p, "§6§lPRO §7");
					p.setPlayerListName("§6" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("vip")) {
				if (p.hasPermission("tag.vip")) {
					TagsAPI.setarTag(p, "§a§lVIP §7");
					p.setPlayerListName("§a" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("mvp")) {
				if (p.hasPermission("tag.mvp")) {
					TagsAPI.setarTag(p, "§9§lMVP §7");
					p.setPlayerListName("§9" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			if (args[0].equalsIgnoreCase("normal")) {
				if (p.hasPermission("tag.normal")) {
					TagsAPI.setarTag(p, "§7");
					p.setPlayerListName("§7" + p.getName());
					p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§aTag alterada");
					return true;
				}
				p.sendMessage(API.naotemtag);
			}
			return false;
		}
		if (p.hasPermission("tag.dono")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.subdono")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.admin")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.mod")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.trial")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.youtuber")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.youtuber+")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.pro")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.mvp")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.vip")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		if (p.hasPermission("tag.normal")) {
			p.sendMessage(
					"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
			return true;
		}
		p.sendMessage(
				"§7Use: §e/tag §7Normal§f, §aVip§f, §9Mvp§f, §6Pro§f, §bYoutuber§f, §3Youtuber+§f, §2Builder§f, §dTrial§f, §5Mod§f, §cAdmin§f, §4SubDono§f, §4Dono");
		return true;
	}
}
