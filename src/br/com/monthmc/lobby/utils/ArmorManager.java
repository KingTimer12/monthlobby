package br.com.monthmc.lobby.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ArmorManager {
	
	/*
	 * Create by Sombraa
	 * Edit by KingoZ_
	 * For MonthMC
	 */
	
	public enum Armors {
		RGB, GREEN, RED, WHITE, YELLOW, NONE
	}
	
	private static HashMap<UUID, Armors> armor = new HashMap<UUID, Armors>();
	public static ArrayList<ItemStack> noClick = new ArrayList<ItemStack>();
	
	public static void setArmor(Player player, Armors armors) {
		armor.put(player.getUniqueId(), armors);
	}
	
	public static boolean hasArmor(Player player, Armors armors) {
		return armor.get(player.getUniqueId()).equals(armors) && !armor.get(player.getUniqueId()).equals(Armors.NONE)
				&& armor.containsKey(player.getUniqueId());
	}
	
	public static boolean hasArmor(Player player) {
		return !armor.get(player.getUniqueId()).equals(Armors.NONE)
				&& armor.containsKey(player.getUniqueId());
	}
	
	public static ItemStack createArmorColor(String name, Material mat, Color cor) {
		ItemStack armor = new ItemStack(mat);
		LeatherArmorMeta meta = (LeatherArmorMeta) armor.getItemMeta();
		meta.setDisplayName(name);
		meta.setColor(cor);
		armor.setItemMeta(meta);
		noClick.add(armor);
		return armor;
	}

}
