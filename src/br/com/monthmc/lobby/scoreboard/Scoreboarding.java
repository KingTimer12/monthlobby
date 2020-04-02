package br.com.monthmc.lobby.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import br.com.monthmc.commons.bukkit.CoreBukkit;
import br.com.monthmc.commons.bukkit.messenger.NetworkManager;
import br.com.monthmc.commons.bukkit.player.BukkitPlayer;
import br.com.monthmc.commons.manager.data.clan.Clan;
import br.com.monthmc.commons.manager.network.ServerType;

public class Scoreboarding {

	/*
	 * Create by KingoZ_ For MonthMC
	 */

	public static void sendScoreboard(Player player) {
		NetworkManager network = CoreBukkit.getInstance().getNetworkManager();
		BukkitPlayer bP = BukkitPlayer.getPlayer(player);
		Clan clan = CoreBukkit.getInstance().getClanManager().getPlayerClan(player);
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = scoreboard.registerNewObjective("score", "dummy");
		obj.setDisplayName("§6§lMOTH MC");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		makeLine("§3", "space3", null, null, scoreboard, 7);
		makeLine("§fGrupo: ", "group", bP.getGroupName(), null, scoreboard, 6);
		makeLine("§fClã: §c", "clan", (clan == null ? "Nenhum" : clan.getName()), null, scoreboard, 5);
		makeLine("§2", "space2", null, null, scoreboard, 4);
		makeLine("§fLobby: ", "lobby", "§a#1", null, scoreboard, 3);
		makeLine("§fJogadores: §b", "players", network.getOnlineCount(ServerType.NETWORK) + "", null, scoreboard, 2);
		makeLine("§1", "space1", null, null, scoreboard, 1);
		makeLine("mc", "site", ".com.br", "     §emonth", scoreboard, 0);
		CoreBukkit.getInstance().getTagManager().update(player);
		player.setScoreboard(scoreboard);
		return;
	}

	@SuppressWarnings("deprecation")
	public static void makeLine(String string, String team_name, String suffix, String prefix, Scoreboard scoreboard,
			int integer) {
		Objective obj = null;
		if (scoreboard.getObjective("score") == null) {
			obj = scoreboard.registerNewObjective("score", "dummy");
		} else {
			obj = scoreboard.getObjective("score");
		}
		obj.getScore(getFastOfflinePlayer(string, team_name, suffix, prefix, scoreboard));
	}

	@SuppressWarnings("deprecation")
	public static FastOfflinePlayer getFastOfflinePlayer(String string, String team_name, String suffix, String preffix,
			Scoreboard scoreboard) {
		FastOfflinePlayer fastOffline = new FastOfflinePlayer(string);
		if (team_name != null) {
			Team team = null;
			if (scoreboard.getTeam(team_name) != null) {
				team = scoreboard.getTeam(team_name);
			} else {
				team = scoreboard.registerNewTeam(team_name);
			}
			if (suffix != null) {
				team.setSuffix(suffix);
			}
			if (preffix != null) {
				team.setPrefix(preffix);
			}
			team.addPlayer(fastOffline);
		}
		return fastOffline;
	}

}
