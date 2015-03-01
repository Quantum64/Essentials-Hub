package me.adityatd.essentialshub;

import me.adityatd.essentialshub.listener.PlayerListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		saveDefaultConfig();
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	}

	public void onDisable() {

	}
}
