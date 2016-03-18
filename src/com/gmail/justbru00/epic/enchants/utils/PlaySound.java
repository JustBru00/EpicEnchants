/**
 * @pluginname EpicEnchants
 * @author Justin Brubaker
 * Copyright (C) 2016 Justin Brubaker
 */
package com.gmail.justbru00.epic.enchants.utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class PlaySound {

	public PlaySound(Player player, Sound sound) {
		player.playSound(player.getLocation(), sound, 1, 1);
		return;
	}
}
