package me.chemorris.core.commands;

import java.util.HashSet;
import java.util.Set;
import me.chemorris.core.handler.ColourHandler;
import me.chemorris.core.Messages;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_staffchat implements CommandExecutor
{
  public final static Set<String> sctoggled = new HashSet<String>();
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    String message = StringUtils.join(args, " ");
    if(!sender.hasPermission("core.ranks.staff"))
    {
        sender.sendMessage(Messages.NO_PERMS);
        return true;
    }

    if(args.length == 0)
    {
        if(sctoggled.contains(player.getName()))
        {
            player.sendMessage(Messages.STAFF_TAG + "Your staff chat has been disabled!");
            sctoggled.remove(player.getName());
            return false;
        } else {
            player.sendMessage(Messages.STAFF_TAG + "Your staff chat has been enabled!");
            sctoggled.add(player.getName());
            return false;
        }
    }
    
    for(Player onlinePlayer : Bukkit.getOnlinePlayers())
    {
        if(onlinePlayer.hasPermission("core.ranks.staff"))
        {
            onlinePlayer.sendMessage(new ColourHandler().translate(Messages.STAFF_TAG + "&9" + sender.getName() + ":&7 " + message));
        }
    }
    return false;
  }
}