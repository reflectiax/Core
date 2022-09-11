package me.chemorris.core.commands;

import java.util.HashSet;
import java.util.Set;
import me.chemorris.core.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_craftingtable implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)
  {
    Player player = (Player) sender;
    if(!sender.hasPermission("core.command.craft"))
    {
        sender.sendMessage(Messages.NO_PERMS);
        return true;
    }

    player.openWorkbench(null, true);
    player.sendMessage(Messages.PLUGIN_TAG + "Opened crafting table!");
    return false;
  }
}