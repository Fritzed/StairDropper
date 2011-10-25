package me.fritz.stairdropper;

import java.util.logging.Logger;

import me.fritz.stairdropper.StairDropperBlockListener;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/** Main StairDropper Class
 *  
 * @Author Fritz
 * @version 1.2
 */
public class StairDropper extends JavaPlugin{

	private StairDropperBlockListener blockListener = new StairDropperBlockListener();
	Logger log = Logger.getLogger("Minecraft");

	/** Called when the plugin is enabled
	 */
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
		
		log.info("[StairDropper] plugin enabled.");
	}

	/** Called when the plugin is disabled
	 */
	public void onDisable() {
		log.info("[StairDropper] plugin disabled.");
	}
}