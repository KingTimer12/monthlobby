package br.com.monthmc.lobby.inventorys;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import br.com.monthmc.commons.bukkit.api.item.ItemBuilder;
import br.com.monthmc.lobby.utils.ArmorManager;
import br.com.monthmc.lobby.utils.ArmorManager.Armors;

public class MenuCosmeticos implements Listener {
	
	/*
	 * Create by Sombraa
	 * For MonthMC
	 */
	
	public static void menuInventory(Player p) {
		Inventory inventory = Bukkit.createInventory(p, 27, "Cosm�ticos");
		inventory.setItem(11, new ItemBuilder(Material.ARMOR_STAND).name("�dArmaduras").build());
		inventory.setItem(15, new ItemBuilder(Material.SKULL_ITEM, 1, 3).name("�cCabe�as").build());
		p.openInventory(inventory);
	}
	
	public static void menuArmor(Player player) {
		Inventory inventory = Bukkit.createInventory(player, 27, "Armadura");
		
		inventory.setItem(4, new ItemBuilder(Material.REDSTONE).name("�cRemover").build());
		
		inventory.setItem(10, ArmorManager.createArmorColor("�aVerde", Material.LEATHER_CHESTPLATE, Color.GREEN));
		inventory.setItem(11, ArmorManager.createArmorColor("�cVermelho", Material.LEATHER_CHESTPLATE, Color.RED));
		inventory.setItem(12, ArmorManager.createArmorColor("�fBranco", Material.LEATHER_CHESTPLATE, Color.WHITE));
		inventory.setItem(13, ArmorManager.createArmorColor("�eAmarelo", Material.LEATHER_CHESTPLATE, Color.YELLOW));
		
		player.openInventory(inventory);
	}
		
	@EventHandler
	public void onOpen(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getItemInHand().getType().equals(Material.CHEST)) {
			menuInventory(p);
		}
	}
	
	@EventHandler
	public void onClickEvent(InventoryClickEvent event) {
		ItemStack currentItem = event.getCurrentItem();
		if (currentItem == null) {
			return;
		}
		if (currentItem.getType().equals(Material.AIR)) {
			return;
		}
		if (event.getWhoClicked() instanceof Player) {
			Player player = (Player) event.getWhoClicked();
			if (event.getInventory().getTitle().equals("Armadura")) {
				event.setCancelled(true);
				if (currentItem.getType().equals(Material.REDSTONE)) {
					if (!ArmorManager.hasArmor(player)) {
						player.sendMessage("�4�lERRO �fVoc� n�o est� utilizando nenhuma armadura.");
						return;
					}
					ArmorManager.setArmor(player, Armors.NONE);
					player.getInventory().setArmorContents(null);
					player.sendMessage("�e�lARMOR �fVoc� removeu sua armadura.");
					return;
				}
				if (currentItem.getType().equals(Material.LEATHER_CHESTPLATE)) {
					if (currentItem.getItemMeta().getDisplayName().equals("�aVerde")) {
						if (ArmorManager.hasArmor(player, Armors.GREEN)) {
							player.sendMessage("�4�lERRO �fVoc� j� est� usando essa armadura.");
							return;
						}
						ArmorManager.setArmor(player, Armors.GREEN);
						player.getInventory().setHelmet(ArmorManager.createArmorColor("�a-", 
								Material.LEATHER_HELMET, Color.GREEN));
						player.getInventory().setChestplate(ArmorManager.createArmorColor("�a-", 
								Material.LEATHER_CHESTPLATE, Color.GREEN));
						player.getInventory().setLeggings(ArmorManager.createArmorColor("�a-", 
								Material.LEATHER_LEGGINGS, Color.GREEN));
						player.getInventory().setBoots(ArmorManager.createArmorColor("�a-", 
								Material.LEATHER_BOOTS, Color.GREEN));
						player.sendMessage("�e�lARMOR �fVoc� est� usando armadura verde.");
						return;
					}
					if (currentItem.getItemMeta().getDisplayName().equals("�cVermelho")) {
						if (ArmorManager.hasArmor(player, Armors.RED)) {
							player.sendMessage("�4�lERRO �fVoc� j� est� usando essa armadura.");
							return;
						}
						ArmorManager.setArmor(player, Armors.RED);
						player.getInventory().setHelmet(ArmorManager.createArmorColor("�c-", 
								Material.LEATHER_HELMET, Color.RED));
						player.getInventory().setChestplate(ArmorManager.createArmorColor("�c-", 
								Material.LEATHER_CHESTPLATE, Color.RED));
						player.getInventory().setLeggings(ArmorManager.createArmorColor("�c-", 
								Material.LEATHER_LEGGINGS, Color.RED));
						player.getInventory().setBoots(ArmorManager.createArmorColor("�c-", 
								Material.LEATHER_BOOTS, Color.RED));
						player.sendMessage("�e�lARMOR �fVoc� est� usando armadura vermelho.");
						return;
					}
					if (currentItem.getItemMeta().getDisplayName().equals("�fBranco")) {
						if (ArmorManager.hasArmor(player, Armors.WHITE)) {
							player.sendMessage("�4�lERRO �fVoc� j� est� usando essa armadura.");
							return;
						}
						ArmorManager.setArmor(player, Armors.WHITE);
						player.getInventory().setHelmet(ArmorManager.createArmorColor("�f-", 
								Material.LEATHER_HELMET, Color.WHITE));
						player.getInventory().setChestplate(ArmorManager.createArmorColor("�f-", 
								Material.LEATHER_CHESTPLATE, Color.WHITE));
						player.getInventory().setLeggings(ArmorManager.createArmorColor("�f-", 
								Material.LEATHER_LEGGINGS, Color.WHITE));
						player.getInventory().setBoots(ArmorManager.createArmorColor("�f-", 
								Material.LEATHER_BOOTS, Color.WHITE));
						player.sendMessage("�e�lARMOR �fVoc� est� usando armadura branca.");
						return;
					}
					if (currentItem.getItemMeta().getDisplayName().equals("�eAmarelo")) {
						if (ArmorManager.hasArmor(player, Armors.YELLOW)) {
							player.sendMessage("�4�lERRO �fVoc� j� est� usando essa armadura.");
							return;
						}
						ArmorManager.setArmor(player, Armors.YELLOW);
						player.getInventory().setHelmet(ArmorManager.createArmorColor("�e-", 
								Material.LEATHER_HELMET, Color.YELLOW));
						player.getInventory().setChestplate(ArmorManager.createArmorColor("�e-", 
								Material.LEATHER_CHESTPLATE, Color.YELLOW));
						player.getInventory().setLeggings(ArmorManager.createArmorColor("�e-", 
								Material.LEATHER_LEGGINGS, Color.YELLOW));
						player.getInventory().setBoots(ArmorManager.createArmorColor("�e-", 
								Material.LEATHER_BOOTS, Color.YELLOW));
						player.sendMessage("�e�lARMOR �fVoc� est� usando armadura amarela.");
						return;
					}
				}
			} else {
				if (ArmorManager.noClick.contains(currentItem)) {
					event.setCancelled(true);
				}
			}
		}
	}
}

