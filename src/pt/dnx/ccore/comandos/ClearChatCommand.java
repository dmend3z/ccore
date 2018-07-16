package pt.dnx.ccore.comandos;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pt.dnx.ccore.utils.CommandUtil;
import pt.dnx.ccore.utils.MessageUtil;

public class ClearChatCommand extends CommandUtil {

	public ClearChatCommand(String command, String usage, String description) {
		super( command,  usage,  description);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if ((sender instanceof Player))
	    {
	      Player p = (Player)sender;
	      if (args.length == 0) {
	        if (p.hasPermission("clay.clear"))
	        {
	          for (int i = 0; i < 100; i++) {
	        	  Bukkit.broadcastMessage("");
	          }
	        }
	      }
	   
	      MessageUtil.sendRawMessage(sender, "&eChat limpo com sucesso");
	      
	    }
	    return false;
	}
	

}
