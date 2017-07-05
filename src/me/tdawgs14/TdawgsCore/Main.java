package me.tdawgs14.TdawgsCore;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
/**
 * Don't Worry About This Class. This is used to Make it a Plugin.
 * 
 * @author Tdawgs
 *
 */
public class Main extends JavaPlugin {
	int task;
	public void onEnable() {
		Bukkit.getLogger().info("TdawgsCore v"+getDescription().getVersion()+" Enabled!");
		task = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for(Plugin p : Bukkit.getPluginManager().getPlugins()) {
					if(p.getDescription().getDepend().contains("TdawgsCore")) {
						Bukkit.getLogger().info("Loaded TdawgsCore Plugin: "+p.getName());
					}
				}
				Bukkit.getScheduler().cancelTask(task);
				return;
			}
		}, 0, 1);
	}
}