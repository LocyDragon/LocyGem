package com.locydragon.gem.core.gems;

import com.locydragon.gem.LocyGem;
import com.locydragon.gem.util.EqualsInfo;
import com.locydragon.gem.util.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class FixStoneListener implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		ItemStack handIn = e.getPlayer().getItemInHand();
		ItemStack zero = e.getPlayer().getInventory().getItem(0);
		if (handIn != null && handIn.hasItemMeta() && handIn.getItemMeta().hasLore()) {
			if (ItemStackBuilder.equalsInSet(handIn, GemItems.badFixStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || !zero.hasItemMeta()) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法修复!o(╥﹏╥)o");
					return;
				}
				if (!LocyGem.equipList.contains(zero.getTypeId())) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法修复!o(╥﹏╥)o");
					return;
				}
				if (zero.getDurability() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法修复!o(╥﹏╥)o");
					return;
				}
				int random = new Random().nextInt(300);
				short nowDur = zero.getDurability();
				nowDur = (short)((short)nowDur - (short)random);
				if (nowDur <= 0) {
					zero.setDurability((short)0);
				} else {
					zero.setDurability(nowDur);
				}
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "劣质修复石修复了"+random+"点耐久~!");
			} else if (ItemStackBuilder.equalsInSet(handIn, GemItems.veryFixStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || !zero.hasItemMeta() || !zero.getItemMeta().hasLore()) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法修复!o(╥﹏╥)o");
					return;
				}
				if (!LocyGem.equipList.contains(zero.getTypeId())) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法修复!o(╥﹏╥)o");
					return;
				}
				if (zero.getDurability() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法修复!o(╥﹏╥)o");
					return;
				}
				zero.setDurability((short)0);
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "完美修复石把你的耐久修满了~!ヽ(￣▽￣)ﾉ");
			}
			e.getPlayer().setItemInHand(handIn);
			e.getPlayer().getInventory().setItem(0, zero);
			e.getPlayer().updateInventory();
		}
	}
}
