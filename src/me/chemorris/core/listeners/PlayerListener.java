package me.chemorris.core.listeners;

import me.chemorris.core.handler.ColourHandler;
import me.chemorris.core.Messages;
import me.chemorris.core.commands.Command_fly;
import me.chemorris.core.commands.Command_god;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {       
        if(e.getPlayer().hasPermission("core.ranks.staff"))
        {
            for(Player onlinePlayer : Bukkit.getOnlinePlayers())
            {
                if(onlinePlayer.hasPermission("core.ranks.staff"))
                {
                    onlinePlayer.sendMessage(Messages.STAFF_TAG + e.getPlayer().getName() + " has joined the server!");
                }
            }           
        }
        
        if(e.getPlayer().getName().equals("ImTheScatman"))
        {
           e.getPlayer().setPlayerListName(new ColourHandler().translate("&4&lOWNER &7" + e.getPlayer().getName()));
        }
        
        if(!e.getPlayer().getName().equals("ImTheScatman") && e.getPlayer().hasPermission("core.ranks.owner"))
        {
           e.getPlayer().setPlayerListName(new ColourHandler().translate("&4&lOWNER &7" + e.getPlayer().getName()));
        }     
        
        if(!e.getPlayer().getName().equals("ImTheScatman") && e.getPlayer().hasPermission("core.ranks.dev"))
        {
           e.getPlayer().setPlayerListName(new ColourHandler().translate("&6&lDEVELOPER &7" + e.getPlayer().getName()));
        }
        
        if(!e.getPlayer().getName().equals("ImTheScatman") && e.getPlayer().hasPermission("core.ranks.admin"))
        {
           e.getPlayer().setPlayerListName(new ColourHandler().translate("&c&lADMINISTRATOR &7" + e.getPlayer().getName()));
        }
        
        if(!e.getPlayer().getName().equals("ImTheScatman") && e.getPlayer().hasPermission("core.ranks.mod"))
        {
           e.getPlayer().setPlayerListName(new ColourHandler().translate("&5&lMODERATOR &7" + e.getPlayer().getName()));
        }
        
        if(!e.getPlayer().getName().equals("ImTheScatman") && e.getPlayer().hasPermission("core.ranks.helper"))
        {
           e.getPlayer().setPlayerListName(new ColourHandler().translate("&2&lHELPER &7" + e.getPlayer().getName()));
        }
                
        if(!e.getPlayer().getName().equals("ImTheScatman") && e.getPlayer().hasPermission("core.ranks.default"))
        {
           e.getPlayer().setPlayerListName(new ColourHandler().translate("&7" + e.getPlayer().getName()));
        }
        
        if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE) && !e.getPlayer().hasPermission("core.command.gamemode") ||
           e.getPlayer().getGameMode().equals(GameMode.ADVENTURE) && !e.getPlayer().hasPermission("core.command.gamemode") ||
           e.getPlayer().getGameMode().equals(GameMode.SPECTATOR) && !e.getPlayer().hasPermission("core.command.gamemode"))
        {
            e.getPlayer().sendMessage(Messages.PLUGIN_TAG + "Your gamemode has been set to survival as you do not have permission to change gamemode.");
            e.getPlayer().setGameMode(GameMode.SURVIVAL);
        }            
    
        if(!e.getPlayer().hasPlayedBefore())
        {
            Bukkit.broadcastMessage(new ColourHandler().translate(Messages.SERVER_TAG + "Welcome &4&l" + e.getPlayer().getName() + " &cto &4&l" + Messages.SERVER_NAME + "&c!"));
        }
        e.setJoinMessage(null);
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        if(e.getPlayer().hasPermission("core.ranks.staff"))
        {
            for(Player onlinePlayer : Bukkit.getOnlinePlayers())
            {
                if(onlinePlayer.hasPermission("core.ranks.staff"))
                {
                    onlinePlayer.sendMessage(Messages.STAFF_TAG + e.getPlayer().getName() + " has left the server!");
                }
            }
        }
        e.setQuitMessage(null);
    }
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e)
    {
        if(e.getPlayer().isFlying() && !e.getPlayer().hasPermission("core.command.fly"))
        {
            e.getPlayer().sendMessage(Messages.PLUGIN_TAG + "Your flight has been disabled as you do not have permission to use flight.");
            e.getPlayer().setAllowFlight(false);
            e.getPlayer().setFlying(false);
            Command_fly.flytoggled.remove(e.getPlayer().getName());
        }
        
        if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE) && !e.getPlayer().hasPermission("core.command.gamemode") ||
           e.getPlayer().getGameMode().equals(GameMode.ADVENTURE) && !e.getPlayer().hasPermission("core.command.gamemode") ||
           e.getPlayer().getGameMode().equals(GameMode.SPECTATOR) && !e.getPlayer().hasPermission("core.command.gamemode"))
        {
            e.getPlayer().sendMessage(Messages.PLUGIN_TAG + "Your gamemode has been set to survival as you do not have permission to change gamemode.");
            e.getPlayer().setGameMode(GameMode.SURVIVAL);
        }
    }
    
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e)
    {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if(player.hasPermission("core.command.god") && Command_god.godtoggled.contains(player.getName()))
            {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e)
    {
        if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE) && !e.getPlayer().hasPermission("core.command.gamemode"))
        {
            e.setCancelled(true);
            e.getPlayer().sendMessage(Messages.PLUGIN_TAG + "Your gamemode has been set to survival as you do not have permission to change gamemode.");
            e.getPlayer().setGameMode(GameMode.SURVIVAL);            
        }
    }
}
