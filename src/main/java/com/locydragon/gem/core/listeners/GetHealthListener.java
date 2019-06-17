package com.locydragon.gem.core.listeners;

import com.locydragon.gem.LocyGem;
import com.locydragon.gem.api.GemItem;
import com.locydragon.gem.api.enums.AttributeType;
import com.locydragon.gem.identify.IdentifyItemListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GetHealthListener implements Listener {
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.isCancelled()) {
			return;
		}
		if (e.getDamager() instanceof Player) {
			Player target = (Player) e.getDamager();
			if (target.getItemInHand() != null &&
					target.getItemInHand().hasItemMeta()
					&& target.getItemInHand().getItemMeta().hasLore()) {
				GemItem gemItem = GemItem.forItem(target.getItemInHand());
				int ods = gemItem.getAttributeNum(AttributeType.HEALTH_ADD);
				if (IdentifyItemListener.isInODS(ods)) {
					target.sendMessage(LocyGem.out + "触发吸血.吸血加成 > "+e.getDamage());
					double addHealth = target.getHealth() + e.getDamage();
					if (addHealth >= target.getMaxHealth()) {
						target.setHealth(target.getMaxHealth());
					} else {
						target.setHealth(addHealth);
					}
				}
			}
		}
	}
}
