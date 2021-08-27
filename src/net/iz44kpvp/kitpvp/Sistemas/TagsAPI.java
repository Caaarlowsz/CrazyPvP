package net.iz44kpvp.kitpvp.Sistemas;

import org.bukkit.entity.*;
import org.bukkit.scheduler.*;
import ca.wacos.nametagedit.*;
import net.iz44kpvp.kitpvp.*;
import org.bukkit.plugin.*;

public class TagsAPI
{
    public static void setarTag(final Player p, final String tag) {
        new BukkitRunnable() {
            public void run() {
                p.setDisplayName(String.valueOf(String.valueOf(tag)) + p.getName());
                NametagAPI.setPrefix(p.getName(), tag);
            }
        }.runTaskAsynchronously((Plugin)Main.getInstance());
    }
}
