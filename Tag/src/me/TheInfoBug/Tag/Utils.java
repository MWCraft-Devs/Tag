package me.TheInfoBug.Tag;

import me.TheInfoBug.Tag.utils.Armor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Utils {

	public static String Colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public static void Broadcastmessage(String message){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.sendMessage(message);
		}
	}
	
	public static void Broadcastsound(Sound sound){
		for(Player p : Bukkit.getOnlinePlayers()){
			p.playSound(p.getLocation(), sound, 1, 1);
		}
	}
	
	public static void setArmor(Player p, Player t){
		Armor.setArmor(p, t);
	}
}