package me.adityatd.essentialshub.listener;

import java.util.List;

import me.adityatd.essentialshub.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListener implements Listener {

	private List<String> motd;
	private String shout;

	public PlayerListener(Main plugin) {
		this.motd = plugin.getConfig().getStringList("joinMOTDs");
		this.shout = plugin.getConfig().getString("joinShout");
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);
		if (motd != null) {
			for (String s : motd) {
				event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', s));
			}
		}
		if (event.getPlayer().hasPermission("msg.joinshout")) {
			if (shout != null)
				Bukkit.broadcastMessage(format(event.getPlayer(), shout));
		}
	}

	private String format(Player p, String s) {
		return ChatColor.translateAlternateColorCodes('&', s.replace("%player%", p.getDisplayName()));
	}
}
