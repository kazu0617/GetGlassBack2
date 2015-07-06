/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.kazu0617.getglassback2;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author kazu0617
 */
public class Main extends JavaPlugin implements Listener
{
    public String Pluginprefix = "[" + ChatColor.GREEN + getDescription().getName() + ChatColor.RESET +"] ";
    public String Pluginname = "[" + getDescription().getName() +"] ";
    public ConsoleLog cLog = new ConsoleLog(this);
    public ButtonCreate BC = new ButtonCreate(this);
    public GetGlassBackBlockListener blockListener = new GetGlassBackBlockListener(this);
 
    boolean DebugMode = false;
    
    @Override
    public void onEnable()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.blockListener, this);
        cLog.info("DebugMode is now ["+DebugMode+"].");
    }
    @Override
    public void onDisable()
    {
        
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if((args.length == 1) && "DebugMode".equalsIgnoreCase(args[0]) && sender.hasPermission("getglassback2.debug"))
        {
            if(DebugMode)
                DebugMode = false;
            else if(!DebugMode)
                DebugMode = true;
            cLog.Message(sender,"DebugMode is now ["+DebugMode+"].");
        }
        if((args.length == 1) && "help".equalsIgnoreCase(args[0]))
        {
            cLog.Message(sender,"CommandList");
            cLog.Message(sender,"/ggb DebugMode ... DebugMode");
        }
        return true;
    }
}
