package com.gmail.justbru00.epic.enchants.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.epic.enchants.utils.Messager;

public class Main extends JavaPlugin {
	
	public static String PREFIX = Messager.color("&8[&bEpic&fEnchants&8] &f");
	public static ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		return false;
	}

	@Override
	public void onDisable() {
	
	}

	@Override
	public void onEnable() {
		
	}

}
