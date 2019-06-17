package com.locydragon.gem.core.listeners;

import com.locydragon.gem.api.GemItem;
import com.locydragon.gem.api.enums.AttributeType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class IgnoreArmorListener implements Listener {
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.isCancelled()) {
			return;
		}
		if (e.getDamager() instanceof Player && e.getEntity() instanceof LivingEntity) {
			LivingEntity er = (LivingEntity)e.getEntity();
			Player target = (Player)e.getDamager();
			if (target.getItemInHand() != null &&
					target.getItemInHand().hasItemMeta()
					&& target.getItemInHand().getItemMeta().hasLore()) {
				GemItem gemItem = GemItem.forItem(target.getItemInHand());
				int ignoreArmor = gemItem.getAttributeNum(AttributeType.IGNORE_ARMOR);
				if (ignoreArmor > 0) {
					double health = er.getHealth();
					double last = health - ignoreArmor;
					if (last <= 0) {
						er.setHealth(0);
					} else {
						er.setHealth(last);
					}
				}
			}
		}
	}
}
