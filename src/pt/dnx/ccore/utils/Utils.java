package pt.dnx.ccore.utils;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.entity.Player;

import pt.dnx.ccore.players.cPlayer;

public class Utils {
	
	public ArrayList<cPlayer> players = new ArrayList<>();
	
	
	public boolean existecPlayer(Player p) {
		if (getcPlayer(p) == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean existecPlayer(UUID p) {
		if (getcPlayer(p) == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean existecPlayer(String p) {
		if (getcPlayer(p) == null) {
			return false;
		} else {
			return true;
		}
	}

	public cPlayer criarJogador(Player p) {
		if (getcPlayer(p.getUniqueId()) == null) {
			//Core.get().Bukkit.getConsoleSender().sendMessage(p.getName() + " nao tinha a conta criada, foi criada uma nova");
			return new cPlayer(p.getUniqueId());
		} else {
			//Core.get().debugar(p.getName() + " tinha a conta criada");
			return getcPlayer(p.getUniqueId());
		}
	}

	public cPlayer getcPlayer(Player player) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getPlayer() == player) {
				return players.get(i);
			}
		}
		return null;
	}

	public cPlayer getcPlayer(UUID uuid) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getUuid() == uuid) {
				return players.get(i);
			}
		}
		return null;
	}

	public cPlayer getcPlayer(String nick) {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getNick().toLowerCase() == nick.toLowerCase()) {
				return players.get(i);
			}
		}
		return null;
	}

}
