package me.Tiernanator.Seats.Events;

import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.Tiernanator.MagicSigns.Events.CustomEvents.CustomSignClickEvent;
import me.Tiernanator.Seats.Main;
import me.Tiernanator.Seats.Seat;
import me.Tiernanator.Utilities.Players.SelectAction;

public class OnSignInteract implements Listener {

	private Main plugin;

	public OnSignInteract(Main main) {
		plugin = main;
	}

	@EventHandler
	public void onPlayerClickSign(CustomSignClickEvent event) {

		SelectAction selectAction = event.getSelectAction();
		if(selectAction != SelectAction.RIGHT_CLICK) {
			return;
		}
		
		Player player = event.getPlayer();
		Location location = event.getSign().getBlock().getLocation();
		
		String seatCode = plugin.getConfig().getString("Seat Code");
		if(seatCode == null) {
			return;
		}
		Sign sign = event.getSign();
		boolean hasCode = false;
		for(String line : sign.getLines()) {
			if(line.contains(seatCode)) {
				hasCode = true;
			}
		}
		
		if(!hasCode) {
			return;
		}
		Seat.sit(player, location);

	}

}
