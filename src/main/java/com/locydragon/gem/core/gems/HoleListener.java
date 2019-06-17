package com.locydragon.gem.core.gems;

import com.locydragon.gem.LocyGem;
import com.locydragon.gem.api.GemItem;
import com.locydragon.gem.util.EqualsInfo;
import com.locydragon.gem.util.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class HoleListener implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		ItemStack inHand = e.getPlayer().getItemInHand();
		if (inHand != null && inHand.hasItemMeta() && inHand.getItemMeta().hasLore()) {
			if (ItemStackBuilder.equalsInSet(inHand, GemItems.holeStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				ItemStack needHole = e.getPlayer().getInventory().getItem(0);
				if (needHole == null || needHole.getType() == Material.BOW) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法打孔!o(╥﹏╥)o");
					return;
				}
				GemItem gemItem = GemItem.forItem(needHole);
				if (!GemItem.forItem(needHole).doHole(e.getPlayer())) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,该物品无法打孔!o(╥﹏╥)o");
					return;
				}
				if (inHand.getAmount() > 1) {
					inHand.setAmount(inHand.getAmount() - 1);
				} else {
					inHand.setType(Material.AIR);
				}
				e.getPlayer().setItemInHand(inHand);
				e.getPlayer().getInventory().setItem(0, gemItem.getItem());
				e.getPlayer().updateInventory();
			}
		}
	}
}
