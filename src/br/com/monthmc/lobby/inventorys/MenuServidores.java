package br.com.monthmc.lobby.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.monthmc.commons.bukkit.CoreBukkit;
import br.com.monthmc.commons.bukkit.api.item.ItemBuilder;
import br.com.monthmc.commons.manager.network.ServerType;

public class MenuServidores implements Listener {
	
	/*
	 * Create by Sombraa
	 * Edit by KingoZ_
	 * For MonthMC
	 */
	
	public static void menuInventory(Player p) {
		Inventory inventory = Bukkit.createInventory(p, 27, "Servidores");
		inventory.setItem(11, new ItemBuilder(Material.IRON_SWORD).name("§ePvP")
				.setLore("", "§7Treine suas habilidades", "§7em uma batalha com sopa", "§7e com kit.",
						"", "§7Jogadores online: §f" + CoreBukkit.getInstance().getNetworkManager().getOnlineCount(ServerType.KITPVP)).build());
		inventory.setItem(15, new ItemBuilder(Material.COMPASS).name("§cHG")
				.setLore("", "§7Colete e fabrique recursos", "§7para acabar com seus oponentes.", "§7Apenas um poderá sair vencedor.",
						"", "§7Jogadores online: §f" + CoreBukkit.getInstance().getNetworkManager().getOnlineCount(ServerType.HARDCOREGAMES)).build());
		p.openInventory(inventory);
	}
	
	@EventHandler
	public void onOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getItemInHand().getType().equals(Material.COMPASS)) {
			menuInventory(p);
		}
	}

}
