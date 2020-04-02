package br.com.monthmc.lobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

	/*
	 * Create by KingoZ_ For MonthMC
	 */

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		event.getPlayer().getInventory().clear();
	}

}
