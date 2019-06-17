package com.locydragon.gem;

import com.locydragon.gem.core.gems.FixStoneListener;
import com.locydragon.gem.core.gems.GemGetListener;
import com.locydragon.gem.core.gems.HoleListener;
import com.locydragon.gem.core.gems.InlayListener;
import com.locydragon.gem.core.listeners.GetHealthListener;
import com.locydragon.gem.core.listeners.IgnoreArmorListener;
import com.locydragon.gem.core.listeners.PotionListener;
import com.locydragon.gem.core.listeners.damage.DamageListener;
import com.locydragon.gem.identify.IdentifyItem;
import com.locydragon.gem.identify.IdentifyItemListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class LocyGem extends JavaPlugin {
	public static LocyGem instance;
	public static ShapedRecipe identifyRecipe
			= new ShapedRecipe(IdentifyItem.identifyItem);
	public static List<Integer> equipList = null;
	public static int odds = 30;
	public static String out = "Tip:";
	@Override
	public void onEnable() {
		identifyRecipe.shape("XXX", "TTT", "FFF");
		identifyRecipe.setIngredient('X', Material.IRON_INGOT);
		identifyRecipe.setIngredient('T', Material.DIAMOND);
		identifyRecipe.setIngredient('F', Material.GOLD_INGOT);
		Bukkit.addRecipe(identifyRecipe);
		Bukkit.getPluginManager().registerEvents(new IdentifyItemListener(), this);
		Bukkit.getPluginManager().registerEvents(new IgnoreArmorListener(), this);
		Bukkit.getPluginManager().registerEvents(new DamageListener(), this);
		Bukkit.getPluginManager().registerEvents(new GetHealthListener(), this);
		Bukkit.getPluginManager().registerEvents(new PotionListener(), this);
		Bukkit.getPluginManager().registerEvents(new GemGetListener(), this);
		Bukkit.getPluginManager().registerEvents(new FixStoneListener(), this);
		Bukkit.getPluginManager().registerEvents(new HoleListener(), this);
		Bukkit.getPluginManager().registerEvents(new InlayListener(), this);
		Bukkit.getLogger().info("您正在使用宝石插件——LocyGem;作者： LocyDragon(绿毛)");
		Bukkit.getLogger().info("本插件作为插件开发比赛参赛作品");
		Bukkit.getLogger().info("本插件为免费插件，作者QQ: 2424441676");
        instance = this;
        saveDefaultConfig();
        equipList = getConfig().getIntegerList("ID");
        odds = getConfig().getInt("ODDS", 25);
        out = ChatColor.translateAlternateColorCodes('&'
				, getConfig().getString("Prefix", "Tip:"));
	}
}
