package pt.dnx.ccore.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import pt.dnx.ccore.Core;
import pt.dnx.ccore.players.Rank;
import pt.dnx.ccore.utils.TabUtil;

public class Eventos implements Listener{
	
	
	
	@EventHandler(priority = EventPriority.HIGH)
	void entrar (PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		Core.get().getMysqlManager().createPlayer(p.getUniqueId().toString());
		
		 TabUtil.setPlayerList(p, "&6&lCLAY&f&lNETWORK", "&bShop: &eshop.claynetwork.com" + "     " + "&bForums: &eclaynetwork.com");
		 
		  Core.forceTag(p, Rank.getRank(p));
	}
	

	
	@EventHandler
    public void onLeafDecayEvent(LeavesDecayEvent e)
    {

        e.setCancelled(true);

    }
	
	
	
}
