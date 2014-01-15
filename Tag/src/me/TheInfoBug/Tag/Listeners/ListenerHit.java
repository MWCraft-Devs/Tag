package me.TheInfoBug.Tag.Listeners;

import me.TheInfoBug.Tag.Tag;
import me.TheInfoBug.Tag.Utils;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ListenerHit implements Listener {

	Tag plugin;
	
	public ListenerHit(Tag tag){
		this.plugin = tag;
	}
	
	@EventHandler
	public void onPlayerHit(EntityDamageByEntityEvent e){
		if(plugin.gameStarted){
			if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
				Player p = (Player) e.getDamager();
				Player t = (Player) e.getEntity();				
				if(plugin.tagger.contains(p.getName())){
					plugin.tagger.clear();
					plugin.tagger.add(t.getName());
					extraFeatures(p, t);
				}else{
					e.setCancelled(true);
				}
				
			}else{
				e.setCancelled(true);
			}
		}
	}
	
	private void extraFeatures(Player p, Player t){
		Utils.Broadcastmessage(Utils.Colorize("&7[&cTag&7] &6" + t.getName() + " &cis has been tagged!"));
		Utils.Broadcastsound(Sound.NOTE_PLING);
		Utils.setArmor(p, t);
	}
}
