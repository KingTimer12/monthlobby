package br.com.monthmc.lobby.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import br.com.monthmc.commons.bukkit.CoreBukkit;
import br.com.monthmc.commons.bukkit.api.item.ItemBuilder;
import br.com.monthmc.commons.bukkit.utils.TeleportServer;
import br.com.monthmc.commons.manager.network.ServerType;
import br.com.monthmc.lobby.Main;

public class MenuServidores implements Listener {

	/*
	 * Create by Sombraa Edit by KingoZ_ For MonthMC
	 */

	public static void menuInventory(Player p) {
		Inventory inventory = Bukkit.createInventory(p, 27, "Servidores");
		inventory.setItem(11, new ItemBuilder(Material.IRON_SWORD).name("§ePvP")
				.setLore("", "§7Treine suas habilidades", "§7em uma batalha com sopa", "§7e com kit.", "",
						"§7Jogadores online: §f"
								+ CoreBukkit.getInstance().getNetworkManager().getOnlineCount(ServerType.KITPVP))
				.build());
		inventory.setItem(15,
				new ItemBuilder(Material.MUSHROOM_SOUP).name("§cHG")
						.setLore("", "§7Colete e fabrique recursos", "§7para acabar com seus oponentes.",
								"§7Apenas um poderá sair vencedor.", "", "§7Jogadores online: §f" + CoreBukkit
										.getInstance().getNetworkManager().getOnlineCount(ServerType.HARDCOREGAMES))
						.build());
		p.openInventory(inventory);
	}
	
	@EventHandler
	public void onOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getInventory().getItemInHand().getType().equals(Material.COMPASS)) {
			menuInventory(p);
		}
	}
	
	@EventHandler
	public void onStatus(InventoryClickEvent e) {
		ItemStack currentItem = e.getCurrentItem();
		if (currentItem == null) {
			return;
		}
		if (currentItem.getType().equals(Material.AIR)) {
			return;
		}
		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if (e.getInventory().getTitle().equals("Servidores")) {
				e.setCancelled(true);
				if (currentItem.getType().equals(Material.IRON_SWORD)) {
					TeleportServer.teleport(p, "kitpvp");
					return;
				}
				if (currentItem.getType().equals(Material.MUSHROOM_SOUP)) {
					Main.findServer(p);
					return;
				}
			}
		}
	}

}
