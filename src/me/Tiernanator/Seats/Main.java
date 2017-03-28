package me.Tiernanator.Seats;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Tiernanator.Seats.Commands.Sit;
import me.Tiernanator.Seats.Events.OnSeatLeave;
import me.Tiernanator.Seats.Events.OnSignInteract;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		
		Seat.setPlugin(this);
		registerCommands();
		registerEvents();
	}

	@Override
	public void onDisable() {

	}

	private void registerCommands() {
		getCommand("sit").setExecutor(new Sit(this));
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new OnSignInteract(this), this);
		pm.registerEvents(new OnSeatLeave(this), this);
	}


}
