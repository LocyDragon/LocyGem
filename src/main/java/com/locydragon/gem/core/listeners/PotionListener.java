package com.locydragon.gem.core.listeners;

import com.locydragon.gem.LocyGem;
import com.locydragon.gem.api.GemItem;
import com.locydragon.gem.api.enums.AttributeType;
import com.locydragon.gem.identify.IdentifyItemListener;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class PotionListener implements Listener {
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.isCancelled()) {
			return;
		}
		if (e.getDamager() instanceof Player && e.getEntity() instanceof LivingEntity) {
			Player target = (Player) e.getDamager();
			LivingEntity em = (LivingEntity)e.getEntity();
			if (target.getItemInHand() != null &&
					target.getItemInHand().hasItemMeta()
					&& target.getItemInHand().getItemMeta().hasLore()) {
				GemItem gemItem = GemItem.forItem(target.getItemInHand());
				int ods = gemItem.getAttributeNum(AttributeType.RANDOM_POTION);
				if (IdentifyItemListener.isInODS(ods)) {
					target.sendMessage(LocyGem.out + "触发毒气效果.对方已经中毒(凋零/中毒)了.");
					if (new Random().nextBoolean()) {
						em.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
					} else {
						em.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1));
					}
				}
			}
		}
	}
}
