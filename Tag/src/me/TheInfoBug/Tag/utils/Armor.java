package me.TheInfoBug.Tag.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Armor {

	static ItemStack lapis = new ItemStack(Material.LAPIS_BLOCK);
	static ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
	static ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS);
	static ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
	
	public static void setArmor(Player p, Player t){
		p.getInventory().setArmorContents(null);
		t.getInventory().setHelmet(lapis);
		t.getInventory().setChestplate(setArmorColor(chest));
		t.getInventory().setLeggings(setArmorColor(legs));
		t.getInventory().setBoots(setArmorColor(boots));
	}
	
	private static ItemStack setArmorColor(ItemStack armor){
		LeatherArmorMeta im = (LeatherArmorMeta) armor.getItemMeta();
		im.setColor(Color.BLUE);
		armor.setItemMeta(im);
		return armor;
	}
}
