package me.chemorris.core.commands;

import java.util.HashSet;
import java.util.Set;
import me.chemorris.core.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_god implements CommandExecutor
{
  public final static Set<String> godtoggled = new HashSet<String>();
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    if(!sender.hasPermission("core.command.god"))
    {
        sender.sendMessage(Messages.NO_PERMS);
        return true;
    }
    if(!godtoggled.contains(player.getName())) {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has enabled god mode!");
            }
        }
                
        player.sendMessage(Messages.STAFF_TAG + "God mode has been enabled!");
        godtoggled.add(player.getName());
    } else {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has disabled god mode!");
            }
        }
                
        player.sendMessage(Messages.STAFF_TAG + "God mode has been disabled!");
        godtoggled.remove(player.getName());
    }
    return false;
  }
}