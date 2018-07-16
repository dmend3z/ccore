package pt.dnx.ccore.interfaces.whitelist;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import pt.dnx.ccore.interfaces.Interfaces;
import pt.dnx.ccore.utils.InterfaceUtil;
import pt.dnx.ccore.utils.ItemUtil;
import pt.dnx.ccore.utils.MessageUtil;

public class WhitelistInterface extends InterfaceUtil
{
	  boolean whitelist = Bukkit.hasWhitelist();
	  
	  public String getName()
	  {
	    return "Whitelist";
	  }
	  
	  public void open(Player p)
	  {
	    Inventory inv = Bukkit.createInventory(p, 9, getName());
	    
	    inv.setItem(0, ItemUtil.createItem(Material.EMERALD, "&aLigar Whitelist"));
	    inv.setItem(4, ItemUtil.createItem(Material.PAPER, "&fVer jogadores whitelist"));
	    inv.setItem(8, ItemUtil.createItem(Material.REDSTONE, "&cDesligar Whitelist"));
	    
	    p.openInventory(inv);
	  }
	  
	  public void click(Player p, int slot)
	  {
	    switch (slot)
	    {
	    case 0: 
	      Bukkit.setWhitelist(true);
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
	      MessageUtil.sendRawMessage(p, new String[] { "&aVoce ligou a whitelist" });
	      break;
	    case 4: 
	      Interfaces.getWhitelistedPlayersInterface().open(p);
	      p.playSound(p.getLocation(), Sound.NOTE_PLING, 10.0F, 10.0F);
	      break;
	    case 8: 
	      Bukkit.setWhitelist(false);
	      p.playSound(p.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
	      MessageUtil.sendRawMessage(p, new String[] { "&cVoce desligou a whitelist" });
	    }
	  }
	}