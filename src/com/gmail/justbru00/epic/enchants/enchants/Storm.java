package com.gmail.justbru00.epic.enchants.enchants;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.PlayerInventory;

import com.gmail.justbru00.epic.enchants.enums.WeaponTypes;
import com.gmail.justbru00.epic.enchants.utils.Messager;
import com.gmail.justbru00.epic.enchants.utils.Randomizer;
import com.gmail.justbru00.epic.enchants.utils.WeaponChecker;

public class Storm implements Listener {

	public void onDamageEvent(EntityDamageByEntityEvent e) {
		if (e.getCause() != DamageCause.ENTITY_ATTACK) return; // If not a entity. Can not be a player.
		if (!(e.getDamager() instanceof Player)) return; // If damager not a player.
		if (!(e.getEntity() instanceof Player)) return; // If hurt entity was not a player.
		
		final Player attackingPlayer = (Player) e.getDamager();
		final Player defendingPlayer = (Player) e.getEntity();
		
		PlayerInventory attackingInventory = attackingPlayer.getInventory();
		if (!(WeaponChecker.check(attackingInventory.getItemInMainHand(), WeaponTypes.SWORD_AND_AXE))) return; // Not a sword or axe.
		
		if (!(attackingInventory.getItemInMainHand().getItemMeta().hasLore())) return; // Has no lore
		
		if (!(attackingInventory.getItemInMainHand().getItemMeta().getLore().contains(Messager.color("&7Storm I")))) return; // Not Storm Enchant.
		
		if (Randomizer.tenPercent()) {
			defendingPlayer.getWorld().strikeLightning(defendingPlayer.getLocation());	
			Messager.msgPlayer("&cA storm strikes opponent.", attackingPlayer);			
			Messager.msgPlayer("&cA storm strikes you.", defendingPlayer);
		}
			
		
	}
}
