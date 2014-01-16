package me.TheInfoBug.Tag.Listeners;

import java.util.Random;

import me.TheInfoBug.Tag.Tag;
import me.TheInfoBug.Tag.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ListenerChat implements Listener {

	Tag plugin;
	
	public ListenerChat(Tag tag){
		this.plugin = tag;
	}
	
	Random rand = new Random();
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		String m = e.getMessage();
		Player p = e.getPlayer();
		if(m.equalsIgnoreCase("!tag")){
			e.setCancelled(true);
			startStopGame();
		}else if(m.equalsIgnoreCase("!tagger")){
			e.setCancelled(true);
			p.sendMessage(Utils.Colorize("&7[&cTag&7] &6" + plugin.tagger.get(0) + " &cis the tagger!"));
		}
	}
	
	private void startStopGame(){
		if(plugin.gameStarted){
			plugin.gameStarted = false;
			plugin.tagger.clear();
			Utils.Broadcastmessage(Utils.Colorize("&7[&cTag&7] &cThe game has been stopped!"));
		}else{
			plugin.gameStarted = true;
			plugin.tagger.clear();
			Player firstIt = Bukkit.getOnlinePlayers()[rand.nextInt(Bukkit.getOnlinePlayers().length)];
			plugin.tagger.add(firstIt.getName());
			Utils.setArmor(firstIt, firstIt);
			Utils.Broadcastsound(Sound.ENDERMAN_TELEPORT);
			Utils.Broadcastmessage(Utils.Colorize("&7[&cTag&7] &cThe game has been started!"));
			Utils.Broadcastmessage(Utils.Colorize("&7[&cTag&7] &6" + firstIt.getName() + " &chas been chosen to be first it!"));
		}
	}
}
