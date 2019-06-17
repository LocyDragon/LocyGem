package com.locydragon.gem.core.gems;

import com.locydragon.gem.LocyGem;
import com.locydragon.gem.api.GemItem;
import com.locydragon.gem.api.enums.AttributeType;
import com.locydragon.gem.util.EqualsInfo;
import com.locydragon.gem.util.ItemStackBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class InlayListener implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		ItemStack handIn = e.getPlayer().getItemInHand();
		ItemStack zero = e.getPlayer().getInventory().getItem(0);
		if (handIn != null && handIn.getType() != Material.BARRIER && handIn.hasItemMeta() && handIn.getItemMeta().hasLore()) {
			GemItem gemItem = GemItem.forItem(zero);
			if (ItemStackBuilder.equalsInSet(handIn, GemItems.ignoreArmor, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || gemItem.getHoles() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				int id = zero.getTypeId();
				if (!(id == 267)
						&& !(id == 268) && !(id == 272) && !(id == 276) && !(id == 261)) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				gemItem.cutHole();
				if (new Random().nextBoolean()) {
					gemItem.increaseAttribute(AttributeType.IGNORE_ARMOR, 1);
				} else {
					gemItem.increaseAttribute(AttributeType.IGNORE_ARMOR, 2);
				}
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "镶嵌完成!(*^▽^*)");
			} else if (ItemStackBuilder.equalsInSet(handIn, GemItems.damageStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || gemItem.getHoles() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				int id = zero.getTypeId();
				if (!(id == 267)
						&& !(id == 268) && !(id == 272) && !(id == 276) && !(id == 261)) {
					e.getPlayer().sendMessage(LocyGem.out + "抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				gemItem.cutHole();
				int addDamage = new Random().nextInt(6);
				while (addDamage == 0) {
					addDamage = new Random().nextInt(6);
				}
				gemItem.increaseAttribute(AttributeType.DAMAGE, addDamage);
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "镶嵌完成!(*^▽^*)");
			} else if (ItemStackBuilder.equalsInSet(handIn, GemItems.addHealStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || gemItem.getHoles() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				int id = zero.getTypeId();
				if (!(id == 267)
						&& !(id == 268) && !(id == 272) && !(id == 276) && !(id == 261)) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				gemItem.cutHole();
				int addHealth = new Random().nextInt(6);
				while (addHealth == 0) {
					addHealth = new Random().nextInt(6);
				}
				gemItem.increaseAttribute(AttributeType.HEALTH_ADD, addHealth);
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "镶嵌完成!(*^▽^*)");
			} else if (ItemStackBuilder.equalsInSet(handIn, GemItems.potionStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || gemItem.getHoles() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				int id = zero.getTypeId();
				if (!(id == 267)
						&& !(id == 268) && !(id == 272) && !(id == 276) && !(id == 261)) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				gemItem.cutHole();
				int addPotion = new Random().nextInt(6);
				while (addPotion == 0) {
					addPotion = new Random().nextInt(6);
				}
				gemItem.increaseAttribute(AttributeType.RANDOM_POTION, addPotion);
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "镶嵌完成!(*^▽^*)");
			} else if (ItemStackBuilder.equalsInSet(handIn, GemItems.armorStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || gemItem.getHoles() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				int id = zero.getTypeId();
				if (!(id >= 298 && id <= 317)) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				gemItem.cutHole();
				gemItem.increaseAttribute(AttributeType.ARMOR, 1);
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "镶嵌完成!(*^▽^*)");
			} else if (ItemStackBuilder.equalsInSet(handIn, GemItems.ignoreDamageStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || gemItem.getHoles() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				int id = zero.getTypeId();
				if (!(id >= 298 && id <= 317)) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				gemItem.cutHole();
				if (new Random().nextBoolean()) {
					gemItem.increaseAttribute(AttributeType.IGNORE_DAMAGE, 1);
				} else {
					gemItem.increaseAttribute(AttributeType.IGNORE_DAMAGE, 2);
				}
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "镶嵌完成!(*^▽^*)");
			} else if (ItemStackBuilder.equalsInSet(handIn, GemItems.returnDamageStone, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
				if (zero == null || gemItem.getHoles() == 0) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				int id = zero.getTypeId();
				if (!(id >= 298 && id <= 317)) {
					e.getPlayer().sendMessage(LocyGem.out + "很抱歉,这个物品无法镶嵌!o(╥﹏╥)o");
					return;
				}
				gemItem.cutHole();
				int addReturn = new Random().nextInt(4);
				while (addReturn == 0) {
					addReturn = new Random().nextInt(4);
				}
				gemItem.increaseAttribute(AttributeType.RETURN_DAMAGE, addReturn);
				if (handIn.getAmount() > 1) {
					handIn.setAmount(handIn.getAmount() - 1);
				} else {
					handIn.setType(Material.AIR);
				}
				e.getPlayer().sendMessage(LocyGem.out + "镶嵌完成!(*^▽^*)");
			}
			e.getPlayer().setItemInHand(handIn);
			e.getPlayer().getInventory().setItem(0, gemItem.getItem());
			e.getPlayer().updateInventory();
		}
	}
}
