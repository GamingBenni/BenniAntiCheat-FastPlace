package de.BenniAntiCheat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CheatBanner implements Listener {
	
	@EventHandler
	public void onCheat(PlayerCheatEvent e) {
		e.getPlayer().kickPlayer("Hacking ist verboten!");
	}

}
