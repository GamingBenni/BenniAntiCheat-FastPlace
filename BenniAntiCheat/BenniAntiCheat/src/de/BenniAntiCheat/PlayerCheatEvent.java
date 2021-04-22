package de.BenniAntiCheat;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerCheatEvent extends Event {
	
	private Player player;
	private String cheat;
	
	private static HandlerList handlers = new HandlerList();
	
	public PlayerCheatEvent(Player p, String hack) {
		player = p;
		cheat = hack;
	}

	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	
	public Player getPlayer() {
		return player;
	}
	
	public String getCheat() {
		return cheat;
	}
	

}
