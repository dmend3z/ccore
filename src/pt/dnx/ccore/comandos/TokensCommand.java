package pt.dnx.ccore.comandos;

import java.sql.SQLException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pt.dnx.ccore.sql.MySQL;
import pt.dnx.ccore.sql.MySQLManager;
import pt.dnx.ccore.utils.CommandUtil;
import pt.dnx.ccore.utils.MessageUtil;

public class TokensCommand extends CommandUtil {

	public TokensCommand(String command, String usage, String description) {
		super(command, usage, description);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player)sender;
		if (args.length == 0){
			if (sender instanceof Player){
				
				try {
					p.sendMessage("§aSeu saldo: §b" + MySQLManager.getTokens(p.getUniqueId().toString()));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				sender.sendMessage("§cApenas jogadores!");
			}
		}
		if (args.length >= 1){
			if (args[0].equalsIgnoreCase("set")){
				if (args.length < 3){
					sender.sendMessage("§cUse: §f/cash set §7<player, quantia>");
					return true;
				}

				Player target = Bukkit.getPlayer(args[1]);
				
				Integer quantia;
				try {
					quantia = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					sender.sendMessage("§cDigite um numero valido!");
					return true;
				}
				try {
					MySQLManager.setTokens(target.getUniqueId().toString(), quantia);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sender.sendMessage("§aVoce setou o cash do jogador §f" + target.getName() + "§a para §f" + quantia);
				return true;
			}
			if (args[0].equalsIgnoreCase("add")){
				if (args.length < 3){
					sender.sendMessage("§cUse: §f/cash add §7<player, quantia>");
					return true;
				}

				Player target = Bukkit.getPlayer(args[1]);
				
				Integer quantia;
				try {
					quantia = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					sender.sendMessage("§cDigite um numero valido!");
					return true;
				}
				MySQLManager.addTokens(target.getUniqueId().toString(), quantia);
				sender.sendMessage("§aVoce adicionou §f" + quantia + "§a de cash na conta §f" + target);
				return true;
			}
			if (args[0].equalsIgnoreCase("remove")){
				if (args.length < 3){
					sender.sendMessage("§cUse: §f/cash remove §7<player, quantia>");
					return true;
				}

				Player target = Bukkit.getPlayer(args[1]);
				
				Integer quantia;
				try {
					quantia = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					sender.sendMessage("§cDigite um numero valido!");
					return true;
				}
				//remove(target, quantia);
				MessageUtil.sendSomethingIsBrokenMessage(p);
				return true;
			}
			
			
			Player target = Bukkit.getPlayer(args[0]);
				if (!MySQLManager.PlayerExistUUID(target.getUniqueId().toString())){
					sender.sendMessage("§cEste jogador nao existe!");
				return true;
				}
				try {
					sender.sendMessage("§aSaldo do jogador §f" + target + ": §3" + MySQLManager.getTokens(target.getUniqueId().toString()));
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		

	return false;
}
}
