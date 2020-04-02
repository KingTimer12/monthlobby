package br.com.monthmc.lobby;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import br.com.monthmc.commons.manager.network.ServerType;
import br.com.monthmc.lobby.inventorys.MenuCosmeticos;
import br.com.monthmc.lobby.inventorys.MenuPerfil;
import br.com.monthmc.lobby.inventorys.MenuServidores;
import br.com.monthmc.lobby.listeners.JoinListener;
import br.com.monthmc.lobby.listeners.PrincipalsListener;
import br.com.monthmc.lobby.listeners.QuitListener;

public class Main extends JavaPlugin {
	
	public static Main getInstance() {
		return getPlugin(Main.class);
	}
	
	@Override
	public void onEnable() {
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new PrincipalsListener(), this);
		Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
		
		Bukkit.getPluginManager().registerEvents(new MenuCosmeticos(), this);
		Bukkit.getPluginManager().registerEvents(new MenuPerfil(), this);
		Bukkit.getPluginManager().registerEvents(new MenuServidores(), this);
	}
	
	public static void findServer(Player player) {
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("FindServer");
		out.writeUTF(ServerType.HARDCOREGAMES.name());
		player.sendPluginMessage(getInstance(), "BungeeCord", out.toByteArray());
	}

}
