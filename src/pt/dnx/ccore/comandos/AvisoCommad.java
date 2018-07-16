package pt.dnx.ccore.comandos;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pt.dnx.ccore.players.Rank;
import pt.dnx.ccore.utils.CommandUtil;
import pt.dnx.ccore.utils.MessageUtil;

public class AvisoCommad extends CommandUtil {

	public AvisoCommad(String command, String usage, String description) {
		super(command, usage, description);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player todos;
	    if ((sender instanceof Player))
	    {
	      Player p = (Player)sender;
	      if (!p.hasPermission("clay.aviso"))
	      {
	        MessageUtil.sendNoPermissionMessage(p, Rank.ADMIN);
	        return false;
	      }
	      if (args.length == 0)
	      {
	       
	        return false;
	      }
	      if (args.length > 0)
	      {
	        String msg = "";
	        String[] arrayOfString2;
	        int j = (arrayOfString2 = args).length;
	        for (int i = 0; i < j; i++)
	        {
	          String msg2 = arrayOfString2[i];
	          msg = String.valueOf(String.valueOf(msg)) + msg2 + " ";
	        }
	        for (Iterator localIterator = Bukkit.getOnlinePlayers().iterator(); localIterator.hasNext();)
	        {
	          todos = (Player)localIterator.next();
	          todos.sendMessage("");
	          todos.sendMessage(MessageUtil.colorize("  &c* &4&lAVISO"));
	          todos.sendMessage(MessageUtil.colorize("  &c* &e") + msg);
	          todos.sendMessage("");
	          
	         // MessageUtil.sendTitleMessage(todos, "&4&lAVISO", "&e"+ msg, 5, 5, 5);
	          
	         //MessageUtil.sendActionBarMessage(todos,"&4&lAVISO");
	        }
	      }
	    }
	    return false;
	}
	
	
	

}
