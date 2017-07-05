package me.tdawgs14.TdawgsCore;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
/**
 * Class where the API Methods are.
 * 
 * @author Tdawgs
 *
 */
public class TdawgsCore {
	
	private String prefix;
	
	/**
	 * Constructor that takes the Plugin Prefix and uses it in other methods.
	 * 
	 * @param prefix - The Plugin Name Prefix for Messages so it makes your Plugin Professional.
	 */
	public TdawgsCore(String prefix) {
		this.prefix = prefix;
	}
	
	/**
	 * Gets the Prefix Loaded in the Constructor.
	 * 
	 * @return The Prefix Loaded in the Constructor.
	 */
	public String getPrefix() {
		return prefix;
	}
	
	/**
	 * Checks to see if the Player Has Permission.
	 * 
	 * @param sender - The Command Sender that Sends the Commands.
	 * @param permission - The Permission Needed to be Checked.
	 * @param messagewithprefix - The Message Sent to the Player who Doesn't Have Permissions. The Prefix will be Included with this Message.
	 * @return TRUE if the Player Has Permission and FALSE if the Player Doesn't Have Permission.
	 */
	public boolean playerPermissionCheck(CommandSender sender, String permission, String messagewithprefix) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(!p.hasPermission(permission)) {
				sender.sendMessage(prefix+messagewithprefix);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks to see if the Command Sender is a Player.
	 * 
	 * @param sender - The Command Sender that is being Checked for a Player.
	 * @param messagewithprefix - The Message Sent to the Command Sender who is Not a Player. The Prefix will be Included with this Message.
	 * @return TRUE if the Command Sender is a Player and FALSE if the Command Sender isn't a Player.
	 */
	public boolean senderPlayerCheck(CommandSender sender, String messagewithprefix) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(prefix+messagewithprefix);
			return false;
		}
		return true;
	}
	
	/**
	 * Determines the Distance in Blocks from One Location to Another Location as a One Dimensional Line.
	 * 
	 * @param l1 - One of the Locations that is One End of the Distance Line.
	 * @param l2 - One of the Locations that is the Other End of the Distance Line.
	 * @return The Distance in Blocks from One Location to Another Location as a One Dimensional Line.
	 */
	public double distanceOfTwoLocations(Location l1, Location l2) {
		double x = Math.sqrt((Math.abs(l1.getX()-l2.getX())*Math.abs(l1.getX()-l2.getX()))+(Math.abs(l1.getZ()-l2.getZ())*Math.abs(l1.getZ()-l2.getZ())));
		return Math.sqrt((Math.abs(l1.getY()-l2.getY())*Math.abs(l1.getY()-l2.getY()))+(x*x));
	}
	
	/**
	 * The Command Sender Sends a Message with the Prefix included with the Message.
	 * 
	 * @param sender - The Command Sender that Sends the Message.
	 * @param message - The Message that is Being Sent. The Prefix is Included with this Message.
	 */
	public void sendMessageWithPrefix(CommandSender sender, String message) {
		sender.sendMessage(prefix+message);
	}
}