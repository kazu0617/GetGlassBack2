/**
 * @author     kazu0617
 * @license    LGPLv3
 * @copyright  Copyright kazu0617 2015
 */
package net.kazu0617.getglassback2;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
    public String Pluginname = getDescription().getName();
    public String Pluginprefix = "[" + ChatColor.GREEN + Pluginname + ChatColor.RESET +"] ";
    public GetGlassBackBlockListener blockListener = new GetGlassBackBlockListener(this);
    public ConsoleLog cLog = new ConsoleLog(this);
 
    public boolean DebugMode = false;
    
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
            cLog.Message(sender,"/ggb2 DebugMode ...use DebugMode");
        }
        return true;
    }
}