package de.BenniAntiCheat;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class FastPlace implements Listener {
	
	static ArrayList<String> playerBlockPlaceList = new ArrayList<String>();
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onBlockPlaceEvent(BlockPlaceEvent e) {
		if(listContainsPlayer(e.getPlayer())) {
			addOnePlace(e.getPlayer());
			if(getPlayerCount(e.getPlayer()) >= 9) {
				Bukkit.getPluginManager().callEvent(new PlayerCheatEvent(e.getPlayer(), "FastPlace"));
			}
		} else {
			playerBlockPlaceList.add(e.getPlayer().getName() + ":" + "1");
		}
	}
	
	void addOnePlace(Player p) {
		playerBlockPlaceList.add(p.getName() + ":" + Integer.valueOf(getPlayerCount(p) + 1));
		playerBlockPlaceList.remove(p.getName() + ":" + Integer.valueOf(getPlayerCount(p) - 1));
	}
	
	
	int getPlayerCount(Player p) {
		int ret = 0;
		if(!playerBlockPlaceList.isEmpty()) {
			for(String each : playerBlockPlaceList) {
				if(each.split(":")[0].equals(p.getName())) {
					ret = Integer.valueOf(each.split(":")[1]);
				}
			}
		}
		
		return ret;
	}
	
	Boolean listContainsPlayer(Player p) {
		if(getPlayerCount(p) == 0) {
			return false;
		} else {
			return true;
		}
	}

}
