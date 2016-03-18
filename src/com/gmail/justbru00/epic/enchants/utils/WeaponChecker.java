package com.gmail.justbru00.epic.enchants.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.gmail.justbru00.epic.enchants.enums.WeaponTypes;

public class WeaponChecker {

	public static boolean check(ItemStack is, WeaponTypes wt) {
		
		if (wt == WeaponTypes.SWORD_AND_AXE) { // Sword and Axe
			Material aw = is.getType();
			if (aw == Material.WOOD_SWORD || aw == Material.STONE_SWORD || aw == Material.GOLD_SWORD 
					|| aw == Material.IRON_SWORD || aw == Material.DIAMOND_SWORD || aw == Material.WOOD_AXE 
					|| aw == Material.STONE_AXE || aw == Material.GOLD_AXE || aw == Material.IRON_AXE || aw == Material.DIAMOND_AXE) {
			
				return true;
			}
		} //End of Sword and Axe
		
		return false;
	}
	
}
