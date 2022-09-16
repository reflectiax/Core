package me.chemorris.core.commands;

import me.chemorris.core.Main;
import me.chemorris.core.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_cutclean implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    if(!sender.hasPermission("core.command.cutclean"))
    {
        sender.sendMessage(Messages.NO_PERMS);
        return true;
    }
    
    if(Main.getInstance().getConfig().getString("cutclean").equals("false"))
    {
        Main.getInstance().getConfig().set("cutclean", "true");
        Main.getInstance().saveConfig();
        sender.sendMessage(Messages.PLUGIN_TAG + "Cutclean has been enabled. Ores will now be autosmelted and animal drops will be cooked on dropping.");
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has enabled cutclean. Ores will now be autosmelted and animal drops will be cooked on dropping.");
            }
        }        
    }
    else if(Main.getInstance().getConfig().getString("cutclean").equals("true"))
    {
        Main.getInstance().getConfig().set("cutclean", "false");
        Main.getInstance().saveConfig();
        sender.sendMessage(Messages.PLUGIN_TAG + "Cutclean has been disabled. Ores will no longer be autosmelted and animal drops will no longer be cooked on dropping.");
        for(Player onlinePlayer : Bukkit.getOnlinePlayers())
        {
            if(onlinePlayer.hasPermission("core.ranks.admin")) {
                onlinePlayer.sendMessage(Messages.ADMIN_TAG + sender.getName() + " has disabled cutclean. Ores will no longer be autosmelted and animal drops will no longer be cooked on dropping.");
            }
        }         
    }
    return false;
  }
}