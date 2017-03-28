package me.Tiernanator.Seats.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import me.Tiernanator.Seats.Main;
import me.Tiernanator.Seats.Seat;

public class OnSeatLeave implements Listener {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public OnSeatLeave(Main main) {
		plugin = main;
	}
	
	@EventHandler
	public void onPlayerClickSign(PlayerToggleSneakEvent event) {
		
		Player player = event.getPlayer();

		Seat.stand(player);
		
	}
	
}
