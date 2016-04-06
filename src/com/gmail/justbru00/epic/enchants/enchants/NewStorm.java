package com.gmail.justbru00.epic.enchants.enchants;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import com.gmail.justbru00.epic.enchants.utils.Messager;
import com.gmail.justbru00.epic.enchants.utils.Randomizer;

import adx.audioxd.customenchantmentapi.enchantment.Enchantment;
import adx.audioxd.customenchantmentapi.enchantment.event.EnchantmentEventHandler;
import adx.audioxd.customenchantmentapi.enums.ItemType;
import adx.audioxd.customenchantmentapi.events.damage.EOwnerDamagesEntityEvent;

public class NewStorm extends Enchantment {

	public NewStorm() { // Enchantment Name, ItemType, maxLvl
        super(ChatColor.GRAY + "Storm" + ChatColor.RESET, ItemType.SWORD, 1);     
    }	

	@EnchantmentEventHandler
	public void onDamageEntity(EOwnerDamagesEntityEvent e) {
		if (e.getVictum() instanceof Entity) {
			if (!Randomizer.tenPercent()) return;
			e.getVictum().getWorld().strikeLightning(e.getVictum().getLocation());
			Messager.msgSender("&eA storm strikes you!", e.getVictum());
			Messager.msgSender("&eA storm strikes your opponent!", e.getVictum());
			return;
		}
		return;
	}
}
