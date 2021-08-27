package net.iz44kpvp.kitpvp.Kits;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.iz44kpvp.kitpvp.Sistemas.Habilidade;

public class IronMan implements Listener {
	public static ArrayList<String> naousar;

	static {
		IronMan.naousar = new ArrayList<String>();
	}

	@EventHandler
	public void aoIronMan(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Habilidade.getAbility(p).equalsIgnoreCase("IronMan")
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.WORKBENCH) {
			p.openWorkbench(p.getLocation(), true);
		}
	}

	@EventHandler
	public void aoMatar(final PlayerDeathEvent e) {
		final Player matou = e.getEntity().getKiller();
		if (!(e.getEntity().getKiller() instanceof Player)) {
			return;
		}
		if (Habilidade.getAbility(matou).equalsIgnoreCase("IronMan") && e.getEntity().getKiller() instanceof Player) {
			final ItemStack ferro = new ItemStack(Material.IRON_INGOT);
			matou.getInventory().addItem(new ItemStack[] { ferro });
			matou.updateInventory();
		}
	}
}
