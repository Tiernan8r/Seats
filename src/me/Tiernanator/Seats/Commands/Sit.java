package me.Tiernanator.Seats.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Tiernanator.Colours.Colour;
import me.Tiernanator.Seats.SeatsMain;
import me.Tiernanator.Seats.Seat;

public class Sit implements CommandExecutor {

	@SuppressWarnings("unused")
	private static SeatsMain plugin;

	private ChatColor warning = Colour.WARNING.getColour();

	public Sit(SeatsMain main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(warning + "You can't use this command.");
			return true;
		}
		
		Player player = (Player) sender;
		Location location = player.getLocation();
		Seat.sit(player, location);
		
		return true;
	}

}
