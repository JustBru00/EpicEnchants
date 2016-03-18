/**
 * @pluginname EpicEnchants
 * @author Justin Brubaker
 * Copyright (C) 2016 Justin Brubaker
 */
package com.gmail.justbru00.epic.enchants.main;

import java.io.IOException;
import java.util.List;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.justbru00.epic.enchants.enchants.Storm;
import com.gmail.justbru00.epic.enchants.metrics.Metrics;
import com.gmail.justbru00.epic.enchants.metrics.Metrics.Graph;
import com.gmail.justbru00.epic.enchants.utils.Messager;

public class Main extends JavaPlugin {
	
	public static String PREFIX = Messager.color("&8[&bEpic&fEnchants&8] &f");
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();	
	public FileConfiguration config = getConfig();
	public static boolean debugMode = false;
	public final String PLUGIN_VERSION = this.getDescription().getVersion();
	public final List<String> PLUGIN_AUTHORS = this.getDescription().getAuthors();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		return false;
	}

	@Override
	public void onDisable() {
	
	}

	@Override
	public void onEnable() {
		
		// Save Default Config
		this.saveDefaultConfig();
		
		// Metrics 
		   try {
			    Metrics metrics = new Metrics(this);

			    // Custom MCSTATS Graph
			    Graph serverUsingEnchant = metrics.createGraph("Enchants Enabled");

			    // Storm
			    serverUsingEnchant.addPlotter(new Metrics.Plotter("Storm") {
			            @Override
			            public int getValue() {
			                    if (config.getBoolean("enchants.sword-axe.storm.enabled")) {
			                    	return 1;
			                    } else {
			                    	return 0;
			                    }
			            }
			    }); // End of Storm
		
			    // Start Metrics
		        metrics.start();
		        Messager.msgConsole("&fStarted Metrics.");
		        
		    } catch (IOException e) {
		        // Failed to submit the stats :-(
		    }
		   
		// Start Plugin Enable.
		   Messager.msgConsole("&fBeginning Plugin Enable.");
		   
		   // Check if debug mode is enabled.
		   Main.debugMode = config.getBoolean("debugmode");
		   
		   // Get enchants ready. (Register approprite listeners.)
		   
		   PluginManager pl = getServer().getPluginManager();
		   
		   if (config.getBoolean("enchants.sword-axe.storm.enabled")) {
			   Messager.msgConsole("&bEnchant Storm &aEnabled&b.");		
			   pl.registerEvents(new Storm(),this);
		   } else {
			   Messager.msgConsole("&bEnchant Storm &aEnabled&b.");
		   }
		   
		   Messager.msgConsole("&fEnchants Ready.");
		   // End of readying enchants.
		   
		   // Command Executors
		   
		   
		   // End of Command Executors
		   
		   
		   
		   		   
	} // End of enable.

}
