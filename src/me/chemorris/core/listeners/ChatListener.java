package me.chemorris.core.listeners;

import me.chemorris.core.handler.ColourHandler;
import me.chemorris.core.Messages;
import me.chemorris.core.commands.Command_staffchat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class ChatListener implements Listener { 
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        if(!Command_staffchat.sctoggled.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
            String prefix = PermissionsEx.getUser(e.getPlayer()).getGroups()[0].getPrefix();
            Bukkit.broadcastMessage(new ColourHandler().translate(prefix + "&7" + e.getPlayer().getName() + " &6» &7") + e.getMessage());
        } else {
            e.setCancelled(true);
            for(Player onlinePlayer : Bukkit.getOnlinePlayers())
            {
                if(onlinePlayer.hasPermission("core.ranks.staff"))
                {
                    onlinePlayer.sendMessage(new ColourHandler().translate(Messages.STAFF_TAG + "&9" + e.getPlayer().getName() + ":&7 " + e.getMessage()));                    
                }
            }
        }
    }
}
