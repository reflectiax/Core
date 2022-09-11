package me.chemorris.core.commands;

import java.util.HashSet;
import java.util.Set;
import me.chemorris.core.Main;
import me.chemorris.core.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_op implements CommandExecutor
{
  private final Main plugin = Main.plugin;
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    if(!sender.getName().equals("ImTheScatman"))
    {
        sender.sendMessage(Messages.NO_PERMS);
        return true;
    }

    if(args.length == 0)
    {
        sender.sendMessage(Messages.STAFF_TAG + "Correct usage: /op <player>");
        return true;
    }
    
    else if(args.length == 1) {
        Player target = (Player) Bukkit.getPlayerExact(args[0]);
        if(target == null)
        {
            sender.sendMessage(Messages.STAFF_TAG + "The player " + args[0] + " could not be found.");
            return false;
        } else {
            for(Player onlinePlayer : Bukkit.getOnlinePlayers())
            {
                if(onlinePlayer.hasPermission("core.ranks.admin"))
                {
                    onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has opped " + target.getName() + "!");
                }
            }
            target.setOp(true);
            sender.sendMessage(Messages.STAFF_TAG + "The player " + args[0] + " has been opped.");
            target.sendMessage(Messages.STAFF_TAG + sender.getName() + " has granted you operator status.");
        }
    }
    return false;
  }
}