package me.chemorris.core.commands;

import java.util.HashSet;
import java.util.Set;
import me.chemorris.core.Main;
import me.chemorris.core.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_gamemode implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    if(!sender.hasPermission("core.command.gamemode"))
    {
        player.sendMessage(Messages.NO_PERMS);
        return true;
    }
    if(args.length == 0)
    {
        player.sendMessage(Messages.STAFF_TAG + "Correct arguments: /gamemode <creative / survival / adventure / spectator>");
        return false;
    }
    
    else if(args[0].equals("creative") || args[0].equals("c") || args[0].equals("1"))
    {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has switched their gamemode to CREATIVE!");
            }
        }
        
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(Messages.STAFF_TAG + "Your gamemode has been updated to creative!");
        return false;
    }
    
    else if(args[0].equals("survival") || args[0].equals("s") || args[0].equals("0"))
    {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has switched their gamemode to SURVIVAL!");
            }
        }
                
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(Messages.STAFF_TAG + "Your gamemode has been updated to survival!");
        return false;
    }
    
    else if(args[0].equals("adventure") || args[0].equals("a") || args[0].equals("2"))
    {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has switched their gamemode to ADVENTURE!");
            }
        }
                
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(Messages.STAFF_TAG + "Your gamemode has been updated to adventure!");
        return false;
    }    
    
    else if(args[0].equals("spectator") || args[0].equals("spec") || args[0].equals("3"))
    {
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has switched their gamemode to SPECTATOR!");
            }
        }
                
        player.setGameMode(GameMode.SPECTATOR);
        player.sendMessage(Messages.STAFF_TAG + "Your gamemode has been updated to spectator!");
        return false;
    }
    player.sendMessage(Messages.STAFF_TAG + "Correct arguments: /gamemode <creative / survival / adventure / spectator>");
    return false;
  }
}