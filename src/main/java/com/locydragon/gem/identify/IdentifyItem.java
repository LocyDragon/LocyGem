package com.locydragon.gem.identify;

import com.locydragon.gem.util.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class IdentifyItem {
	public static ItemStack identifyItem;
	static {
		identifyItem = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name(ItemStackBuilder.color+"a"+ItemStackBuilder.color+"l"+"+未鉴定宝石+")
				.lore(new String[] {ItemStackBuilder.color+"e用法:"+ItemStackBuilder.color+"a拿在手里右键即可鉴定.",
						ItemStackBuilder.color+"e作用:"+ItemStackBuilder.color+"a鉴定成为可使用的宝石.",
						ItemStackBuilder.color+"e说明:", ItemStackBuilder.color+"a  - 拿在手上右键即可变成鉴定过的宝石."})
				.build();

	}
}
