package me.Tiernanator.Seats;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.Tiernanator.Utilities.MetaData.MetaData;

public class Seat {
	
	private static Main plugin;
	public static void setPlugin(Main main) {
		plugin = main;
	}
	
	@SuppressWarnings("deprecation")
	public static void sit(Player player, Location location) {
	
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();
		World world = location.getWorld();
		location = new Location(world, x, y, z);
		location.add(0.5, 0, 0.5);

		PotionEffect invisibility = new PotionEffect(
				PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0, false,
				false);

		Rabbit rabbit = (Rabbit) MetaData.getMetadata(player, "Seat", plugin);
		if(rabbit != null) {
			rabbit.remove();
		}
		rabbit = (Rabbit) location.getWorld().spawnEntity(location,
				EntityType.RABBIT);

		rabbit.addPotionEffect(invisibility, true);

		rabbit.setAI(false);
		rabbit.setInvulnerable(true);
		rabbit.setSilent(true);
		rabbit.setAgeLock(true);
		rabbit.setBaby();
		rabbit.setCollidable(false);
		rabbit.setGravity(false);
		rabbit.teleport(player);
		rabbit.setPassenger(player);
		MetaData.setMetadata(player, "Seat", rabbit, plugin);
		
	}

	public static void stand(Player player) {
		
		LivingEntity seatEntity = (LivingEntity) MetaData.getMetadata(player, "Seat", plugin);
		if(seatEntity == null) {
			return;
		}
		seatEntity.remove();
		MetaData.setMetadata(player, "Seat", null, plugin);
		
	}
	
}
