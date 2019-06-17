package com.locydragon.gem.api;

import com.locydragon.gem.LocyGem;
import com.locydragon.gem.api.enums.AttributeType;
import com.locydragon.gem.api.enums.ElementType;
import com.locydragon.gem.util.Ten2Chinese;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GemItem {
	public static Random random = new Random();
	public static final char hole = '〇';
	public static final char fixHole = '۞';
	private ItemStack item;
	private List<String> itemData;

	private GemItem(ItemStack item) {
		this.item = item;
		this.itemData = item.getItemMeta().getLore();
		if (item == null) {
			this.itemData = new ArrayList<>();
			return;
		}
		if (!item.hasItemMeta()) {
			this.itemData = new ArrayList<>();
			return;
		}
		if (!item.getItemMeta().hasLore()) {
			this.itemData = new ArrayList<>();
		}
	}

	public ItemStack getItem() {
		return item;
	}

	public ElementType getElement() {
		if (item.getType() != Material.DIAMOND_SWORD && item.getType() != Material.BOW) {
			return ElementType.EMPTY;
		}
		for (String obj : itemData) {
			if (obj.contains("元素")) {
				String last = obj.substring(obj.length() - 1, obj.length());
				switch (last) {
					case "木":
						return ElementType.WOOD;
					case "火":
						return ElementType.FIRE;
					case "水":
						return ElementType.WATER;
					case "暗":
						return ElementType.DARK;
					case "光":
						return ElementType.LIGHT;
				}
			}
		}
		return ElementType.EMPTY;
	}

	public boolean cleanAndRandomElement() {
		if (item.getType() != Material.DIAMOND_SWORD) {
			return false;
		}
		return true;
	}

	public boolean doHole(Player who) { //打孔
		int id = this.item.getTypeId();
		if (!(id >= 298 && id <= 317) && !(id == 267)
				&& !(id == 268) && !(id == 272) && !(id == 276) && !(id == 261)) {
			return false;
		}
		if (hasHole()) {
			return false;
		}
		cleanAndRandomElement();
		int holeNum = random.nextInt(11);
		while (holeNum <= 0 || holeNum >= 11) {
			holeNum = random.nextInt(11);
		}
		String colorPrefix = null;
		if (holeNum <= 3) {
			colorPrefix = "§a";
		} else if (holeNum <= 7) {
			colorPrefix = "§6";
		} else {
			colorPrefix = "§5";
			Bukkit.broadcastMessage(LocyGem.out + "恭喜玩家 §e"+who.getName()+" §7打造出了 §e"+ Ten2Chinese.toChinese(holeNum)+" §7孔武器!");
		}
		who.sendMessage(LocyGem.out + "你打造出了§b "+Ten2Chinese.toChinese(holeNum)+" §7孔武器!(*^▽^*)!");
		StringBuilder holeBuilder = new StringBuilder();
		holeBuilder.append(colorPrefix);
		for (int i = 0; i < holeNum; i++) {
			holeBuilder.append(hole);
		}
		this.itemData.add("§7> > > §d孔数:");
		this.itemData.add(holeBuilder.toString());
		update();
		return true;
	}

	public boolean hasHole() {
		if (this.itemData == null) {
			return false;
		}
		for (String obj : this.itemData) {
			if (obj.contains("孔数")) {
				return true;
			}
		}
		return false;
	}

	public int getHoles() {
		if (!hasHole()) {
			return 0;
		}
		int hole = 0;
		for (String obj : this.itemData) {
			if (obj.endsWith(String.valueOf(GemItem.hole))) {
				for (char each : obj.toCharArray()) {
					if (each == GemItem.hole) {
						hole++;
					}
				}
			}
		}
		return hole;
	}

	/**
	 * Not debug yet!
	 *
	 * @return
	 */
	public boolean cutHole() {
		if (getHoles() == 0) {
			return false;
		}
		StringBuilder holeBuilder = new StringBuilder();
		LoreLoop:
		for (int i = 0; i < this.itemData.size(); i++) {
			String obj = this.itemData.get(i);
			if (obj.contains(String.valueOf(hole))) {
				boolean touchedHole = false;
				for (char c : obj.toCharArray()) {
					if (touchedHole == false && c == hole) {
						touchedHole = true;
						holeBuilder.append(fixHole);
						continue;
					} else {
						holeBuilder.append(c);
					}
				}
				this.itemData.set(i, holeBuilder.toString());
				break LoreLoop;
			}
		}
		update();
		return true;
	}

	public boolean hasAttribute(AttributeType type) {
		for (String obj : this.itemData) {
			if (obj.contains(AttributeType.getArrtibute(type)) && obj.contains(">")) {
				return true;
			}
		}
		return false;
	}

	public boolean increaseAttribute(AttributeType type, int increase) {
		if (!hasHole()) {
			return false;
		}
		if (!hasAttribute(type)) {
			this.itemData.add("§3§l"+AttributeType.getArrtibute(type)+"加成 §5> "+increase);
			update();
			return true;
		} else {
			for (int i = 0;i < this.itemData.size();i++) {
				String obj = this.itemData.get(i);
				if (obj.contains(AttributeType.getArrtibute(type))) {
					int itemLevel = getAttributeNum(type);
					this.itemData.set(i, ("§3§l"+AttributeType.getArrtibute(type)+"加成 §5> "+(increase + itemLevel)));
					update();
					return true;
				}
			}
		}
		return false;
	}

	public int getAttributeNum(AttributeType type) {
		for (String obj : this.itemData) {
			if (obj.contains(AttributeType.getArrtibute(type))) {
				return Integer.valueOf(obj.split(">")[1].trim());
			}
		}
		return 0;
	}
	public static GemItem forItem(ItemStack item) {
		return new GemItem(item);
	}

	public void update() {
		ItemMeta meta = this.item.getItemMeta();
		meta.setLore(this.itemData);
		this.item.setItemMeta(meta);
	}

}
