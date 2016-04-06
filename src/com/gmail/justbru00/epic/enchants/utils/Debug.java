package com.gmail.justbru00.epic.enchants.utils;

import org.bukkit.entity.Player;

public class Debug {

	public static void send(String msg, Player player) {
		Messager.msgConsole("&8[&cError&8] &c" + msg);	
	}
}
