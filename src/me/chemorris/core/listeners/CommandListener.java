package me.chemorris.core.listeners;

import me.chemorris.core.handler.ColourHandler;
import me.chemorris.core.Messages;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {
    
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e)
    {
        if(e.getMessage().startsWith("/spigot:") ||
           e.getMessage().startsWith("/worldedit:") ||
           e.getMessage().startsWith("/minecraft:") ||
           e.getMessage().equalsIgnoreCase("//calc") ||
           e.getMessage().equalsIgnoreCase("//eval") ||
           e.getMessage().equalsIgnoreCase("//sol") ||
           e.getMessage().equalsIgnoreCase("//solve") ||
           e.getMessage().equalsIgnoreCase("//evaluate") ||
           e.getMessage().equalsIgnoreCase("//calculate") ||
           e.getMessage().equalsIgnoreCase("/plugins") ||
           e.getMessage().equalsIgnoreCase("/pl") ||
           e.getMessage().equalsIgnoreCase("/version") ||
           e.getMessage().equalsIgnoreCase("/ver") ||
           e.getMessage().equalsIgnoreCase("/me") ||
           e.getMessage().startsWith("/bukkit:") ||
           e.getMessage().equalsIgnoreCase("/icanhasbukkit") ||
           e.getMessage().equalsIgnoreCase("/help"))
        {
            if(e.getPlayer().getName().equals("ImTheScatman")) {
            e.setCancelled(false);
            } else {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Messages.PLUGIN_TAG + "The command " + e.getMessage() + " is disabled.");
            }
        }
    }
}
