package me.chemorris.core;

import me.chemorris.core.commands.*;
import me.chemorris.core.listeners.*;
import me.chemorris.core.handler.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Main extends JavaPlugin {

    public static Main plugin;
    
    public void onEnable()
    {
        plugin = this;
        getLogger().info("Plugin enabled!");
        
        // Config
        FileConfiguration config = this.getConfig();
        this.saveDefaultConfig();
        
        // Listeners
        Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CommandListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BlockListener(), this);
        
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
        getServer().getPluginCommand("core").setExecutor(new Command_core());
        getServer().getPluginCommand("cutclean").setExecutor(new Command_cutclean());
    }
    
    public void onDisable()
    {
        getLogger().info("Plugin disabled!");
    }
    
    public static Main getInstance() {
        return plugin;
    }
}
