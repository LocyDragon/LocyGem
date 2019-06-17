package com.locydragon.gem.core.listeners.damage;


import com.locydragon.gem.LocyGem;
import com.locydragon.gem.api.GemItem;
import com.locydragon.gem.api.enums.AttributeType;
import com.locydragon.gem.api.enums.ElementType;
import com.locydragon.gem.identify.IdentifyItemListener;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DamageListener implements Listener {
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.isCancelled()) {
			return;
		}
		if (e.getDamager() instanceof LivingEntity) {
			LivingEntity t = (LivingEntity)e.getDamager();
			if (e.getDamager() instanceof Player) {
				Player target = (Player) e.getDamager();
				if (target.getItemInHand() != null &&
						target.getItemInHand().hasItemMeta()
						&& target.getItemInHand().getItemMeta().hasLore()) {
					GemItem gemItem = GemItem.forItem(target.getItemInHand());
					int damage = gemItem.getAttributeNum(AttributeType.DAMAGE);
					e.setDamage(e.getDamage() + damage);
				}
			}
			if (e.getEntity() instanceof Player) {
				{ //防御石
					int armor = 0;
					Player hitWho = (Player) e.getEntity();
					for (ItemStack item : hitWho.getInventory().getArmorContents()) {
						if (item != null && item.hasItemMeta() && item.getItemMeta().hasLore()) {
							armor += GemItem.forItem(item).getAttributeNum(AttributeType.ARMOR);
						}
					}
					double toDamage = e.getDamage() - armor;
					if (toDamage <= 0) {
						e.setDamage(0);
					} else {
						e.setDamage(toDamage);
					}
				}
				{ //闪避石
					int armor = 0;
					Player hitWho = (Player) e.getEntity();
					for (ItemStack item : hitWho.getInventory().getArmorContents()) {
						if (item != null && item.hasItemMeta() && item.getItemMeta().hasLore()) {
							armor += GemItem.forItem(item).getAttributeNum(AttributeType.IGNORE_DAMAGE);
						}
					}
					if (IdentifyItemListener.isInODS(armor)) {
						hitWho.sendMessage(LocyGem.out + "闪避!(*^▽^*)");
						e.setCancelled(true);
					}
				}
				{//反伤石
					int armor = 0;
					Player hitWho = (Player) e.getEntity();
					for (ItemStack item : hitWho.getInventory().getArmorContents()) {
						if (item != null && item.hasItemMeta() && item.getItemMeta().hasLore()) {
							armor += GemItem.forItem(item).getAttributeNum(AttributeType.RETURN_DAMAGE);
						}
					}
					if (armor == 0) {
						return;
					}
					t.damage(e.getDamage() * armor / 100);
				}
				if (e.getDamager() instanceof Player) {
					ItemStack handIn = ((Player) e.getEntity()).getItemInHand();
					ItemStack handInDamager = ((Player) e.getDamager()).getItemInHand();
					if (handIn != null && handIn.hasItemMeta() && handIn.getItemMeta().hasLore()) {
						if (handInDamager != null && handInDamager.hasItemMeta() && handInDamager.getItemMeta().hasLore()) {
							GemItem given = GemItem.forItem(handInDamager);
							GemItem receiver = GemItem.forItem(handIn);
							if (given.getElement() != ElementType.EMPTY && given.getElement() != ElementType.EMPTY) {
								if (ElementType.isCounterBy(given.getElement(), receiver.getElement())) {}
							}
						}
					}
				}
			}
		}
	}
	public static List<Location> getBlocks(Location AA, Location BB) {
		if (!AA.getWorld().getName().equals(BB.getWorld().getName())) {
			throw new IllegalArgumentException();
		}
		List<Location> loc = new ArrayList<>();
		int xAdd = 1;
		int yAdd = 1;
		int zAdd = 1;
		xAdd = AA.getBlockX() > BB.getBlockX() ? 1 : -1;
		yAdd = AA.getBlockY() > BB.getBlockX() ? 1 : -1;
		zAdd = AA.getBlockZ() > BB.getBlockZ() ? 1 : -1;
		for (int x = AA.getBlockX(); x != BB.getBlockX(); x += xAdd) {
			for (int y = AA.getBlockY(); y != BB.getBlockY(); y += yAdd) {
				for (int z = AA.getBlockZ(); z != BB.getBlockZ(); z+= zAdd) {
					loc.add(new Location(AA.getWorld(), x, y, z));
				}
			}
		}
		return loc;
	}
}
