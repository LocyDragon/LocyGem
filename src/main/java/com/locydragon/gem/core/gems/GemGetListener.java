package com.locydragon.gem.core.gems;

import com.locydragon.gem.LocyGem;
import com.locydragon.gem.identify.IdentifyItem;
import com.locydragon.gem.util.EqualsInfo;
import com.locydragon.gem.util.ItemStackBuilder;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class GemGetListener implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		ItemStack handIn = e.getPlayer().getItemInHand();
		if (handIn != null && handIn.hasItemMeta() && handIn.getItemMeta().hasLore()) {
			if (ItemStackBuilder.equalsInSet(handIn, IdentifyItem.identifyItem
					, EqualsInfo.ABOUT_NAME, EqualsInfo.ABOUT_LORE)) {
				int randomNum = new Random().nextInt(101);
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().setItemInHand(handIn);
				e.getPlayer().updateInventory();
				ItemStack needToGive = GemItems.holeStone;
				if (randomNum <= 15) {
					needToGive = GemItems.holeStone;
				} else if (randomNum > 15 && randomNum <= 30) {
					needToGive = GemItems.badFixStone;
				} else if (randomNum > 30 && randomNum <= 38) {
					needToGive = GemItems.veryFixStone;
				} else if (randomNum > 38 && randomNum <= 46) {
					needToGive = GemItems.ignoreArmor;
				} else if (randomNum > 46 && randomNum <= 54) {
					needToGive = GemItems.damageStone;
				} else if (randomNum > 54 && randomNum <= 62) {
					needToGive = GemItems.addHealStone;
				} else if (randomNum > 62 && randomNum <= 70) {
					needToGive = GemItems.potionStone;
				} else if (randomNum > 70 && randomNum <= 80) {
					needToGive = GemItems.armorStone;
				} else if (randomNum > 80 && randomNum <= 90){
					needToGive = GemItems.ignoreDamageStone;
				} else if (randomNum > 90 && randomNum <= 100) {
					needToGive = GemItems.returnDamageStone;
				}
				HashMap<Integer,ItemStack> out = e.getPlayer().getInventory().addItem(needToGive);
				e.getPlayer().sendMessage(LocyGem.out + "恭喜你获得 "+needToGive.getItemMeta().getDisplayName()+" §7一个!(*^▽^*)!");
				if (!out.isEmpty()) {
					e.getPlayer().sendMessage(LocyGem.out + "你的背包已经满了,装不下宝石了!我们把它丢到地上啦~(>ω･* )ﾉ");
					for (Map.Entry<Integer,ItemStack> entry : out.entrySet()) {
						e.getPlayer().getLocation().getWorld().dropItem(e.getPlayer().getLocation(), entry.getValue());
					}
				}
			}
		}
	}
}
