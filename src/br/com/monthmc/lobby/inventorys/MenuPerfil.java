package br.com.monthmc.lobby.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import br.com.monthmc.commons.bukkit.api.item.ItemBuilder;
import br.com.monthmc.commons.bukkit.player.BukkitPlayer;

public class MenuPerfil {
	
	/*
	 * Create by Sombraa
	 * For MonthMC
	 */
	
	public static void menuInventory(Player p) {
		Inventory inventory = Bukkit.createInventory(p, 27, "Perfil");
		inventory.setItem(11, new ItemBuilder(Material.DIAMOND_ORE).name("§dRank")
				 .setLore("§aSeu rank: " + BukkitPlayer.getPlayer(p).getLeague().getColor() + BukkitPlayer.getPlayer(p).getLeague().getName()).build());
		inventory.setItem(15, new ItemBuilder(Material.PAPER).name("§cStatus").build());
		p.openInventory(inventory);
	}
	
	@EventHandler
	public void onOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getItemInHand().getType().equals(Material.COMPASS)) {
			menuInventory(p);
		}
	}
	@EventHandler
	public void onStatus(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if(e.getCurrentItem().getType().equals(Material.PAPER)) {
				

			}
		}
	}
	
	//TODO: Vou sair, amanhã a gente continua...
	public static void statusInventory(Player p) {
		Inventory inventory = Bukkit.createInventory(p, 27, "Status");
		inventory.setItem(11, new ItemBuilder(Material.DIAMOND_ORE).name("§dKills")
				 .setLore("§aSeu rank: " + BukkitPlayer.getPlayer(p).getLeague().getColor() + BukkitPlayer.getPlayer(p).getLeague().getName()).build());
		inventory.setItem(15, new ItemBuilder(Material.PAPER).name("§cStatus").build());
		p.openInventory(inventory);
	}
	
}
