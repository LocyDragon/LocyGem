package com.locydragon.gem.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemStackBuilder {
	public static String color = "§";
	private ItemStack item;

	private ItemStackBuilder(Material material) {
		this.item = new ItemStack(material);
	}

	public ItemStackBuilder name(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder lore(List<String> lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(lore);
		item.setItemMeta(meta);
		return this;
	}

	public ItemStackBuilder lore(String[] lore) {
		ItemMeta meta = item.getItemMeta();
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		return this;
	}
	public ItemStack build() {
		return this.item;
	}

	public static ItemStackBuilder getBuilder(Material itemMaterial) {
		return new ItemStackBuilder(itemMaterial);
	}

	public static boolean equalsInSet(ItemStack one, ItemStack other, EqualsInfo... set) {
		if (!one.hasItemMeta()) {
			return false;
		}
		if (one.getItemMeta().getDisplayName() == null) {
			return false;
		}
		boolean nameEquals = true;
		boolean loreEquals = true;
		boolean materialEquals = true;
		boolean amountEquals = true;
		for (EqualsInfo info : set) {
			switch (info) {
				case ABOUT_AMOUNT:
					amountEquals = one.getAmount() == other.getAmount();
					break;
				case ABOUT_LORE:
					loreEquals = one.getItemMeta().getLore().equals(other.getItemMeta().getLore());
					break;
				case ABOUT_NAME:
					nameEquals = one.getItemMeta().getDisplayName().equals(other.getItemMeta().getDisplayName());
					break;
				case ABOUT_MATERIAL:
					materialEquals = one.getType() == other.getType() || one.getType().equals(other.getType());
					break;
				default:
					break;
			}
		}
		return nameEquals && loreEquals && materialEquals && amountEquals;
	}
}

