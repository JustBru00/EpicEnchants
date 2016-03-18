package com.gmail.justbru00.epic.enchants.utils;

public class Randomizer {

	/**
	 * 
	 * @param precentChance Only use 5, 10 or 25
	 * @return
	 */
	public static boolean fivePercent() {
		int random = (int) (Math.random() * 100);
		if (random < 6) { // 0-5 
			return true;
		}
		return false;
	}
	
	public static boolean tenPercent() {
		int random = (int) (Math.random() * 100);
		if (random < 11) { // 0-10
			return true;
		}
		return false;
	}
	
	public static boolean twentyfivePercent() {
		int random = (int) (Math.random() * 100);
		if (random < 26) { // 0-25
			return true;
		}
		return false;
	}
}
