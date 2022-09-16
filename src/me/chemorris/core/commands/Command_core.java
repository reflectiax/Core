package me.chemorris.core.commands;

import me.chemorris.core.Main;
import me.chemorris.core.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_core implements CommandExecutor
{
  public static Main plugin;
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    sender.sendMessage(Messages.PLUGIN_TAG + "Version 1.0");
    return false;
  }
}