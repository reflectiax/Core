package me.chemorris.core.commands;

import java.util.HashSet;
import java.util.Set;
import me.chemorris.core.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_fly implements CommandExecutor
{
  public final static Set<String> flytoggled = new HashSet<String>();
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    if(!sender.hasPermission("core.command.fly"))
    {
        sender.sendMessage(Messages.NO_PERMS);
        return true;
    }
    if(!flytoggled.contains(player.getName())) {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has enabled fly!");
            }
        }
                
        player.setAllowFlight(true);
        player.setFlying(true);
        player.sendMessage(Messages.PLUGIN_TAG + "Flight has been enabled!");
        flytoggled.add(player.getName());
    } else {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has disabled fly!");
            }
        }
                
        player.setAllowFlight(false);
        player.setFlying(false);
        player.sendMessage(Messages.PLUGIN_TAG + "Flight has been disabled!");
        flytoggled.remove(player.getName());
    }
    return false;
  }
}