package pt.dnx.ccore.manager;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.entity.Player;

import pt.dnx.ccore.Core;

public class BungeeManager {

	
	public static void sendToServer(Player p, String target){
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try{
			out.writeUTF("Connect");
			out.writeUTF(target);
		}catch(Exception e){
			e.printStackTrace();
		}
		p.sendPluginMessage(Core.get(), "BungeeCord", b.toByteArray());
	}
}
