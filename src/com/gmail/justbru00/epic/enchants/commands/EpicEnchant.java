package com.gmail.justbru00.epic.enchants.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.justbru00.epic.enchants.main.Main;
import com.gmail.justbru00.epic.enchants.utils.Messager;

import adx.audioxd.customenchantmentapi.EnchantmentRegistery;

public class EpicEnchant implements org.bukkit.command.CommandExecutor {

	public EpicEnchant(Main main) {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("epicenchant")) {
			if (!(sender instanceof Player)) {
				Messager.msgSender("&4You can't use that command!", sender);
				return true;
			}
			
			Player player = (Player) sender;
			
			if (args.length > 1) {
				
				int lvl = 1;
				
				try {
					lvl = Integer.getInteger(args[1]);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				EnchantmentRegistery.enchant(player.getInventory().getItemInMainHand(), EnchantmentRegistery.getFromID(args[0]), lvl, true, true);
				
				return true;
			} else {
				Messager.msgPlayer("&4Not enough args.", player);
				return true;
			}
		}
		
		return false;
	}

}
