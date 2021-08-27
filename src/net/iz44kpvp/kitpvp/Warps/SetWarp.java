package net.iz44kpvp.kitpvp.Warps;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import net.iz44kpvp.kitpvp.Sistemas.*;
import net.iz44kpvp.kitpvp.*;

public class SetWarp implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("warpset") && p.hasPermission("flame.warpset") && args.length == 0) {
            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cSintaxe correta: /warpset (challenge,fps,knock,main,mdr,rdm,spawn)");
            return true;
        }
        if (args[0].equalsIgnoreCase("challenge")) {
            Main.getInstance().warps.set("challenge.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("challenge.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("challenge.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("challenge.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("challenge.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("challenge.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoce setou a warp §6Challenge");
            return true;
        }
        if (args[0].equalsIgnoreCase("fps")) {
            Main.getInstance().warps.set("fps.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("fps.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("fps.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("fps.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("fps.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("fps.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoce setou a warp §6Fps");
            return true;
        }
        if (args[0].equalsIgnoreCase("knock")) {
            Main.getInstance().warps.set("knock.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("knock.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("knock.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("knock.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("knock.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("knock.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoce setou a warp §6Knock");
            return true;
        }
        if (args[0].equalsIgnoreCase("main")) {
            Main.getInstance().warps.set("main.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("main.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("main.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("main.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("main.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("main.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoce setou a warp §6Main");
            return true;
        }
        if (args[0].equalsIgnoreCase("mdr")) {
            Main.getInstance().warps.set("mdr.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("mdr.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("mdr.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("mdr.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("mdr.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("mdr.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoce setou a warp §6Mdr");
            return true;
        }
        if (args[0].equalsIgnoreCase("rdm")) {
            Main.getInstance().warps.set("rdm.x", (Object)p.getLocation().getX());
            Main.getInstance().warps.set("rdm.y", (Object)p.getLocation().getY());
            Main.getInstance().warps.set("rdm.z", (Object)p.getLocation().getZ());
            Main.getInstance().warps.set("rdm.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().warps.set("rdm.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().warps.set("rdm.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().save();
            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoce setou a warp §6Rdm");
            return true;
        }
        if (args[0].equalsIgnoreCase("spawn")) {
            Main.getInstance().getConfig().set("spawn.x", (Object)p.getLocation().getX());
            Main.getInstance().getConfig().set("spawn.y", (Object)p.getLocation().getY());
            Main.getInstance().getConfig().set("spawn.z", (Object)p.getLocation().getZ());
            Main.getInstance().getConfig().set("spawn.pitch", (Object)p.getLocation().getPitch());
            Main.getInstance().getConfig().set("spawn.yaw", (Object)p.getLocation().getYaw());
            Main.getInstance().getConfig().set("spawn.world", (Object)p.getLocation().getWorld().getName());
            Main.getInstance().saveConfig();
            p.sendMessage(String.valueOf(String.valueOf(API.preffix)) + "§cVoce setou o §6Spawn");
            p.getWorld().setSpawnLocation(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
            return true;
        }
        return false;
    }
}
