package de.BenniAntiCheat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
	
	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onChat(AsyncPlayerChatEvent e) {
		if(e.getMessage().equalsIgnoreCase("#Benni")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage("§aGaming_Benni §bhat dem §eCanstein-Berlin.de §bServer bei der §aBehebung §bvon §aSicherheitslücken §ageholfen!");
			e.getPlayer().sendMessage("§eWenn du ihn unterstützen willst, kannst du gerne auch mal bei ihm vorbei schauen: §bbennis-server.net");
			e.getPlayer().sendMessage("§eViel Spaß noch beim Spielen! :-)");
		}
	}

}
