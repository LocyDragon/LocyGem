package com.locydragon.gem.identify;

import com.locydragon.gem.LocyGem;
import com.locydragon.gem.util.EqualsInfo;
import com.locydragon.gem.util.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class IdentifyItemListener implements Listener {
	public static ItemStack[] empty = new ItemStack[]{new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR),
			new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR),
			new ItemStack(Material.AIR), new ItemStack(Material.AIR), new ItemStack(Material.AIR)};
	@EventHandler
	public void onIdentifyItemCraft(CraftItemEvent e) {
		if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) {
			return;
		}
        if (ItemStackBuilder.equalsInSet(e.getRecipe().getResult(), IdentifyItem.identifyItem, EqualsInfo.ABOUT_LORE, EqualsInfo.ABOUT_NAME)) {
			if (e.getClick() != ClickType.LEFT) {
				e.setCancelled(true);
				e.getWhoClicked().sendMessage(LocyGem.out + "请用左键取出宝石.");
				return;
			}
			double randomODS = LocyGem.odds;
			for (ItemStack item : e.getInventory().getMatrix()) {
				if (item == null) {
					continue;
				}
				if (item.getAmount() > 1) {
					e.getWhoClicked().sendMessage(LocyGem.out + "请不要一次合成多个宝石.");
					e.setCancelled(true);
					return;
				}
			}
			if (!isInODS(randomODS)) {
				e.getInventory().setMatrix(empty);
				e.getInventory().setResult(empty[0]);
				((Player)e.getWhoClicked()).updateInventory();
				((Player)e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.ANVIL_BREAK, 1, 1);
				e.getWhoClicked().sendMessage(LocyGem.out + "§3啊嘞(ｷ｀ﾟДﾟ´)!! §7合成失败了!!");

			} else {
				((Player)e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.LEVEL_UP, 1, 1);
				e.getWhoClicked().sendMessage(LocyGem.out + "§5啊呦(*^▽^*) §c合成成功了!!");
			}
		}
	}
	public static boolean isInODS(double ods) {
		double random = Math.random() * 100;
		int intODS = (int)random;
		if (intODS <= ods) {
			return true;
		}
		return false;
	}
}
