package br.com.monthmc.lobby.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.monthmc.commons.bukkit.api.item.ItemBuilder;
import br.com.monthmc.lobby.scoreboard.Scoreboarding;

public class JoinListener implements Listener {
	
	/*
	 * Create by Sombraa
	 * Edit by KingoZ_
	 * For MonthMC
	 */
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		Player p = e.getPlayer();
		p.getInventory().clear();
		
		Scoreboarding.sendScoreboard(p);
		
		p.getInventory().setItem(2, new ItemBuilder(Material.EMERALD_ORE).name("§aPerfil").build());
		p.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).name("§aServidores").build());
		p.getInventory().setItem(6, new ItemBuilder(Material.CHEST).name("§aCosméticos").build());
		p.updateInventory();
	}
}
