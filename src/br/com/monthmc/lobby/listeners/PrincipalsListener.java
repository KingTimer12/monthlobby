package br.com.monthmc.lobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PrincipalsListener implements Listener {

	/*
	 * Create by Sombraa Optimize by KingoZ_ For MonthMC
	 */

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			e.setCancelled(false);
		} else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onBuild(BlockPlaceEvent e) {
		if (e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
			e.setCancelled(false);
		} else {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void onPik(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}

}
