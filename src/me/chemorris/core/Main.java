package me.chemorris.core;

import me.chemorris.core.commands.Command_clearallentities;
import me.chemorris.core.commands.Command_craftingtable;
import me.chemorris.core.commands.Command_deop;
import me.chemorris.core.commands.Command_feed;
import me.chemorris.core.commands.Command_fly;
import me.chemorris.core.commands.Command_gamemode;
import me.chemorris.core.commands.Command_god;
import me.chemorris.core.commands.Command_heal;
import me.chemorris.core.commands.Command_op;
import me.chemorris.core.commands.Command_staffchat;
import me.chemorris.core.handler.ConfigHandler;
import org.bukkit.plugin.java.JavaPlugin;
import me.chemorris.core.listeners.ChatListener;
import me.chemorris.core.listeners.CommandListener;
import me.chemorris.core.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class Main extends JavaPlugin {

    public static Main plugin;
    
    public void onEnable()
    {
        plugin = this;
        getLogger().info("Plugin enabled!");
        
        // Config
        ConfigHandler.load((Plugin)this, "config.yml");
        
        // Listeners
        Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CommandListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        
        // Commands
        getServer().getPluginCommand("fly").setExecutor(new Command_fly());
        getServer().getPluginCommand("staffchat").setExecutor(new Command_staffchat());
        getServer().getPluginCommand("gamemode").setExecutor(new Command_gamemode());
        getServer().getPluginCommand("op").setExecutor(new Command_op());
        getServer().getPluginCommand("deop").setExecutor(new Command_deop());
        getServer().getPluginCommand("craftingtable").setExecutor(new Command_craftingtable());
        getServer().getPluginCommand("clearallentities").setExecutor(new Command_clearallentities());
        getServer().getPluginCommand("god").setExecutor(new Command_god());
        getServer().getPluginCommand("heal").setExecutor(new Command_heal());
        getServer().getPluginCommand("feed").setExecutor(new Command_feed());
    }
    
    public void onDisable()
    {
        getLogger().info("Plugin disabled!");
    }
}
