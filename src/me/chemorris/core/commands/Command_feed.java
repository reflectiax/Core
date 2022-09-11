package me.chemorris.core.commands;

import me.chemorris.core.Main;
import me.chemorris.core.Messages;
import me.chemorris.core.handler.ColourHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Command_feed implements CommandExecutor
{
  private final Main plugin = Main.plugin;
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    if(!sender.hasPermission("core.command.feed"))
    {
        sender.sendMessage(Messages.NO_PERMS);
        return true;
    }

    player.setFoodLevel(20);
    player.sendMessage(Messages.PLUGIN_TAG + "Your food level has been restored to full.");
    return false;
  }
}