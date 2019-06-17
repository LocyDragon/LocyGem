package com.locydragon.gem.core.gems;

import com.locydragon.gem.util.ItemStackBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GemItems {
	public static ItemStack holeStone;
	public static ItemStack badFixStone;
	public static ItemStack veryFixStone;
	public static ItemStack ignoreArmor;
	public static ItemStack damageStone;
	public static ItemStack addHealStone;
	public static ItemStack potionStone;
	public static ItemStack armorStone;
	public static ItemStack ignoreDamageStone;
	public static ItemStack returnDamageStone;
 	static {
		holeStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§a§l+打孔石+")
				.lore(new String[]{"§e用法:§a把你要打孔的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a为你的武器打孔,这样你就能镶嵌宝石了!"
				, "§e说明:", "§a  - 为你的装备打孔,孔数是随机的,最大是十孔."})
				.build();
		badFixStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§a§l+劣质修复石+")
				.lore(new String[]{"§e用法:§a把你要修复的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a劣质修复石可以修复你的装备!但是不能修满耐久."
						, "§e说明:", "§a  - 修复宝石!修复你的装备(*^▽^*)!"})
				.build();
		veryFixStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§a§l+完美修复石+")
				.lore(new String[]{"§e用法:§a把你要修复的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a完美修复石能把你的耐久修满!"
						, "§e说明:", "§a  - 修复宝石!修复你的装备(*^▽^*)!"})
				.build();
		ignoreArmor = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§a§l+破甲石+")
				.lore(new String[]{"§e用法:§a把你要镶嵌宝石的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a每次镶嵌增加 §b1~2 §a点可以无视护甲的伤害."
						, "§e说明:", "§a  - 镶嵌后武器就能造成破甲伤害了!但是不会给对手的护甲造成损伤."})
				.build();
		damageStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§a§l+攻击石+")
				.lore(new String[]{"§e用法:§a把你要镶嵌宝石的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a每次镶嵌增加 §b1~5 §a点武器伤害."
						, "§e说明:", "§a  - 镶嵌后武器增加伤害."})
				.build();
		addHealStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§a§l+吸血石+")
				.lore(new String[]{"§e用法:§a把你要镶嵌宝石的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a每次镶嵌增加 §b1~5% §a点吸血几率."
						, "§e说明:", "§a  - 吸血:给自己增加血量.增加的血量为你造成的伤害."})
				.build();
		potionStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§a§l+毒气石+")
				.lore(new String[]{"§e用法:§a把你要镶嵌宝石的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a每次镶嵌增加 §b1~5% §a点毒气几率."
						, "§e说明:", "§a  - 毒气:给敌人增加 §b中毒/凋零 §a的负面效果 §b5 §a秒."})
				.build();
		armorStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§e§l+护甲石+")
				.lore(new String[]{"§e用法:§a把你要镶嵌宝石的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a每次镶嵌增加 §b1 §a点防御力."
						, "§e说明:", "§a  - 你实际受到的伤害 = 武器伤害 - 护甲防御力."})
				.build();
		ignoreDamageStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§e§l+闪避石+")
				.lore(new String[]{"§e用法:§a把你要镶嵌宝石的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a每次镶嵌增加 §b1~2 §a点闪避率."
						, "§e说明:", "§a  - 闪避:将一次别人给你的伤害降为0."})
				.build();
		returnDamageStone = ItemStackBuilder.getBuilder(Material.DIAMOND)
				.name("§e§l+反伤石+")
				.lore(new String[]{"§e用法:§a把你要镶嵌宝石的装备放在§c物品栏第一格§a然后右键宝石即可."
						, "§e作用:§a每次镶嵌增加 §b1~3 §a点反伤率."
						, "§e说明:", "§a  - 反伤:返回对手攻击的一定伤害."})
				.build();
	}
}
