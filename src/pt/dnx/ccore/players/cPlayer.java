package pt.dnx.ccore.players;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import pt.dnx.ccore.Core;

public class cPlayer {

	
	 private UUID uuid;
	 private boolean staff;
	 private Rank rank;
	  
	
	public cPlayer(UUID uuid)
	  {
	    this.uuid = uuid;
	    this.staff = false;	    
	    Core.get().getUtils().players.add(this);
	  }
	
	
	
	public boolean isSTAFF() {
		return staff;	
	}

	public void setstaff(boolean staff) {
		this.staff = staff;
	}
	
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getNick() {
		return Bukkit.getPlayer(uuid).getName();
	}

	public Player getPlayer() {
		return Bukkit.getPlayer(uuid);
	}


	public Rank getRank() {
		return rank;
	}



	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
}
