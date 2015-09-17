/*
 * @author     kazu0617
 * @license    LGPLv3
 * @copyright  Copyright kazu0617 2015
 */
package net.kazu0617.getglassback2;

import static org.bukkit.GameMode.CREATIVE;
import static org.bukkit.GameMode.SPECTATOR;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class GetGlassBackBlockListener implements Listener
{
  Main plugin;
  
  public GetGlassBackBlockListener(Main instance)
  {
    this.plugin = instance;
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onBlockBreak(BlockBreakEvent event)
  {
    if (event.isCancelled())
    {
      return;
    }
    Block block = event.getBlock();
    Player p = event.getPlayer();
    if (!p.hasPermission("getglassback2.use")||p.getGameMode().equals(CREATIVE)||p.getGameMode().equals(SPECTATOR))
        return;
    if (block.getType() == Material.GLASS)
    {
        if(plugin.DebugMode)
            plugin.cLog.debug(p+" dropped GLASS.");
      block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GLASS, 1));
    }
    if (block.getType() == Material.THIN_GLASS)
    {
        if(plugin.DebugMode)
            plugin.cLog.debug(p+" dropped THIN_GLASS.");
      block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.THIN_GLASS, 1));
    }
    if (block.getType() == Material.STAINED_GLASS)
    {
        short damage = (short)block.getData();
        if(plugin.DebugMode)
            plugin.cLog.debug(p+" dropped STAINED_GLASS(Damage "+damage+").");
        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.STAINED_GLASS, 1));
    }
    if (block.getType() == Material.STAINED_GLASS_PANE)
    {
      short damage = (short)block.getData();
        if(plugin.DebugMode)
            plugin.cLog.debug(p+" dropped STAINED_GLASS_PANE(Damage "+damage+").");
      block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.STAINED_GLASS_PANE, 1));
    }
  }
}
