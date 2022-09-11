package me.chemorris.core.commands;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.chemorris.core.Main;
import me.chemorris.core.Messages;
import me.chemorris.core.handler.ColourHandler;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Command_clearallentities implements CommandExecutor
{
  private final Main plugin = Main.plugin;
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    if(!sender.hasPermission("core.command.clearallentities"))
    {
        sender.sendMessage(Messages.NO_PERMS);
        return true;
    }
    
    World world = player.getWorld();
    List<Entity> entList = world.getEntities();
    for (Iterator<Entity> localIterator = entList.iterator(); localIterator.hasNext(); ) {
      Entity current = localIterator.next();
      if (current instanceof org.bukkit.entity.Item)
        current.remove(); 
    }

    for(Player onlinePlayer : Bukkit.getOnlinePlayers())
    {
        if(onlinePlayer.hasPermission("core.ranks.admin")) {
            onlinePlayer.sendMessage(Messages.ADMIN_TAG + "All entities were cleared by " + sender.getName() + "!");
        }
    }    
    sender.sendMessage(new ColourHandler().translate(Messages.PLUGIN_TAG + "Cleared all entities in your current world!"));    
    return false;
  }
}