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
import br.com.monthmc.commons.bukkit.player.BukkitPlayer;
import br.com.monthmc.commons.manager.data.clan.Clan;
import br.com.monthmc.commons.manager.data.player.types.DataType;

public class MenuPerfil implements Listener {

	/*
	 * Create by Sombraa For MonthMC
	 */

	public static void menuInventory(Player p) {
		Inventory inventory = Bukkit.createInventory(p, 27, "Perfil");
		inventory.setItem(11,
				new ItemBuilder(Material.DIAMOND_ORE).name("§dRank")
						.setLore("§aSeu rank: " + BukkitPlayer.getPlayer(p).getLeague().getColor()
								+ BukkitPlayer.getPlayer(p).getLeague().getName(),
								"§aSeu XP: §b" + BukkitPlayer.getPlayer(p).getXP())
						.build());
		inventory.setItem(15, new ItemBuilder(Material.PAPER).name("§cStatus")
				.setLore("§aVeja seus status no HG, KitPvP e do Clã").build());
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
			if (e.getInventory().getTitle().equals("Perfil")) {
				e.setCancelled(true);
				if (currentItem.getType().equals(Material.PAPER)) {
					statusInventory(p);
					return;
				}
			}
			if (e.getInventory().getTitle().equals("Status")) {
				e.setCancelled(true);
				if (currentItem.getType().equals(Material.REDSTONE)) {
					menuInventory(p);
					return;
				}
			}
		}
	}

	public static void statusInventory(Player p) {
		Inventory inventory = Bukkit.createInventory(p, 27, "Status");
		BukkitPlayer bP = BukkitPlayer.getPlayer(p);
		Clan clan = CoreBukkit.getInstance().getClanManager().getPlayerClan(p);
		inventory.setItem(0, new ItemBuilder(Material.REDSTONE).name("§cVoltar").build());
		inventory.setItem(11, new ItemBuilder(Material.MUSHROOM_SOUP).name("§aStatus no §2HG")
				.setLore("","§f- §aKills: §7" + bP.getData(DataType.HG_KILLS).asInt(),
						"§f- §aWins: §7" + bP.getData(DataType.HG_WINS).asInt(),
						"§f- §aDeaths: §7" + bP.getData(DataType.HG_DEATHS).asInt(), "").build());
		
		if (clan == null) {
			inventory.setItem(13, new ItemBuilder(Material.BARRIER).name("§cVocê não tem clã").build());
		} else {
			inventory.setItem(13, new ItemBuilder(Material.NETHER_STAR).name("§aStatus do §2Clã")
					.setLore("","§f- §aKills: §7" + clan.getStatus().getKills(),
							"§f- §aWins: §7" + clan.getStatus().getWins(),
							"§f- §aDeaths: §7" + clan.getStatus().getDeaths(), "").build());
		}
		
		inventory.setItem(15, new ItemBuilder(Material.DIAMOND_SWORD).name("§aStatus no §2KitPvP")
				.setLore("", "§2Arena PvP", "§f- §aKills: §7" + bP.getData(DataType.KITPVP_KILLS).asInt(),
						"§f- §aDeaths: §7" + bP.getData(DataType.KITPVP_DEATHS).asInt(), "", "§2Arena 1v1",
						"§f- §aKills: §7" + bP.getData(DataType.KITPVP_1V1_KILLS).asInt(),
						"§f- §aDeaths: §7" + bP.getData(DataType.KITPVP_1V1_DEATHS).asInt()).build());
		
		p.openInventory(inventory);
	}

}
