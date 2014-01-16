package me.TheInfoBug.Tag;

import java.util.*;

import me.TheInfoBug.Tag.Listeners.*;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Tag extends JavaPlugin{

	//#SkyWazHere
	//Get PluginManager
	PluginManager pm = Bukkit.getPluginManager();
	
	//Create universal variables
	public boolean gameStarted = false;
	public List<String> tagger = new ArrayList<String>();
	
	//Now register everything
	public void onEnable(){
		pm.registerEvents(new ListenerHit(this), this);
		pm.registerEvents(new ListenerChat(this), this);
	}
}
