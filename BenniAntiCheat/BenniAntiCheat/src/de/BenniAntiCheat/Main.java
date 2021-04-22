package de.BenniAntiCheat;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	static Plugin plugin;
	
	public void onEnable() {
		
		plugin = this;
		
		Bukkit.getPluginManager().registerEvents(new FastPlace(), this);
		Bukkit.getPluginManager().registerEvents(new CheatBanner(), this);
		Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
		
		startSecondCounter();
		
	}
	
	void startSecondCounter() {
		Thread t = new Thread(new Runnable() {
		
			@Override
			public void run() {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					//Nothing to handle
				}
				
				FastPlace.playerBlockPlaceList = new ArrayList<String>();
				
				startSecondCounter();
				
			}
		});
		
		t.start();
	}

}