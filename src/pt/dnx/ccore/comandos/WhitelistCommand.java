package pt.dnx.ccore.comandos;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pt.dnx.ccore.interfaces.Interfaces;
import pt.dnx.ccore.utils.CommandUtil;
import pt.dnx.ccore.utils.MessageUtil;

public class WhitelistCommand extends CommandUtil
{
	  public WhitelistCommand(String command, String usage, String description)
	  {
	    super(command, usage, description);
	  }
	  
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player p = (Player)sender;
	    if ((cmd.getName().equalsIgnoreCase("whitelist")) && (args.length <= 0))
	    {
	      Interfaces.getWhitelistInterface().open(p);
	    }
	    else if ((args[0].equalsIgnoreCase("add")) && (args.length == 2))
	    {
	     
		OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
	      Bukkit.getWhitelistedPlayers().add(player);
	      MessageUtil.sendRawMessage(p, new String[] { "&aAdicionou &e" + player.getName() + "&a a whitelist!" });
	    }
	    else if ((args[0].equalsIgnoreCase("remove")) && (args.length == 2))
	    {
	      OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
	      Bukkit.getWhitelistedPlayers().remove(player);
	      MessageUtil.sendRawMessage(p, new String[] { "&cRemoveu &e" + player.getName() + "&c da whitelist" });
	    }
	    return true;
	  }
	}


