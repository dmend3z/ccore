package pt.dnx.ccore.interfaces.whitelist;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import pt.dnx.ccore.utils.InterfaceUtil;
import pt.dnx.ccore.utils.ItemUtil;

public class WhitelistedPlayersInterface extends InterfaceUtil
{
	  public String getName()
	  {
	    return "Whitelisted Players";
	  }
	  
	  public void open(Player p)
	  {
	    Inventory inv = Bukkit.createInventory(p, 54, getName());
	    
	    int slot = 0;
	    for (OfflinePlayer whitelisted : Bukkit.getWhitelistedPlayers())
	    {
	      inv.setItem(slot, ItemUtil.createSkull(whitelisted.getName(), "&a" + whitelisted.getName()));
	      slot++;
	    }
	    p.openInventory(inv);
	  }
	  
	  public void click(Player p, int slot) {}
	}
