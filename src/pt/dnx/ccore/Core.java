package pt.dnx.ccore;

import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pt.dnx.ccore.comandos.AvisoCommad;
import pt.dnx.ccore.comandos.ClearChatCommand;
import pt.dnx.ccore.comandos.TokensCommand;
import pt.dnx.ccore.comandos.WhitelistCommand;
import pt.dnx.ccore.listeners.Eventos;
import pt.dnx.ccore.listeners.InventoryClickListener;
import pt.dnx.ccore.players.Rank;
import pt.dnx.ccore.sql.MySQLManager;
import pt.dnx.ccore.utils.TagAPI;
import pt.dnx.ccore.utils.Utils;

public class Core extends JavaPlugin {
	
	
	private static Core instance;
	private MySQLManager mysqlmanager;
	private Utils utils;

	 
	 
	public void onEnable() {
		
		instance = this;
		
		try {
			Bukkit.getConsoleSender().sendMessage("Conectando a mysql");
			MySQLManager.setupDB();
		} catch (SQLException e) {
			Bukkit.getConsoleSender().sendMessage("Um erro aconteceu ao conectar a mysql, fechando servidor");
			Bukkit.shutdown();
		}
		
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		
		
		registereventos();
		registerCommands();
	
		
	
		

        
        
	}
	
	
	
	public void onDisable() {
		
		MySQLManager.closeDB();
		HandlerList.unregisterAll();
	}
	
	public void registereventos() {
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Eventos(), this);
		pm.registerEvents(new InventoryClickListener(), this);
		
	}
	
	
	public void registerCommands()
	  {
	    WhitelistCommand whitelistCommand = new WhitelistCommand("Whitelist", "whitelist", "Whitelist Command");
	    whitelistCommand.register();
	    
	    ClearChatCommand clearchatcommand = new ClearChatCommand("clearchat", "clearchat", "clearchat Command");
	    clearchatcommand.register();
	    
	    AvisoCommad avisocommand = new AvisoCommad("aviso", "aviso", "Aviso Command");
	    avisocommand.register();
	    
	    TokensCommand tokenscommand = new TokensCommand("tokens", "tokens", "Tokens Command");
	    tokenscommand.register();
	  }

	public void onLoad() {
		mysqlmanager = new MySQLManager();	
		instance = this;
		utils = new Utils();
	}
	
	
	
	
	public static Core get() {
		return instance;
	}
	
	public MySQLManager getMysqlManager()
	  {
	    return this.mysqlmanager;
	  }
	  
	  
	public Utils getUtils() {
		return utils;
		}
	
	
	public static HashMap<Player, Rank> tagset = new HashMap<>();


	public static void setTag(Player p, Rank tag) {
		tagset.put(p, tag);
	}

	public static void forceTag(Player p, Rank tag) {
		for (Player players :  Bukkit.getOnlinePlayers()) {

		setTag(p, tag);
		p.setDisplayName(tag.getTag() + p.getName() + "§r");
		TagAPI.setTag(p, tag.getTag());
		}
	}

	public static String getPlayerTag(Player p) {
		return tagset.get(p).getTag();
	}

	public static Rank getTag(Player p) {
		return tagset.get(p);
	}
    

}
