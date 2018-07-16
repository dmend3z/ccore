package pt.dnx.ccore.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.bukkit.Bukkit;

public class MySQLManager {
	
public static MySQL db;
public static Statement statement;

public static void setupDB() throws SQLException {
	
	
	db = new MySQL("localhost", "3306", "dam","root", "");
	try {
		db.openConnection();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	statement = db.getConnection().createStatement();
	statement.executeUpdate(
			"CREATE TABLE IF NOT EXISTS players(uuid varchar(64), name text, tokens int, xp int);");
}

public static boolean PlayerExistUUID(String uuid) {
	try {
		ResultSet rs = db.querySQL("SELECT * FROM players WHERE uuid= '" + uuid + "'");
		if (rs.next()) {
			return rs.getString("uuid") != null;
		}
		return false;
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;
}

public static boolean PlayerExistName(String name) {
	name = name.toLowerCase();
	try {
		ResultSet rs = db.querySQL("SELECT * FROM players WHERE name= '" + name + "'");
		if (rs.next()) {
			return rs.getString("name") != null;
		}
		return false;
	} catch (SQLException | ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;
}

public void createPlayer(String uuid) {
	if (!PlayerExistUUID(uuid)) {
		try {
			String name = Bukkit.getPlayer(UUID.fromString(uuid)).getName().toLowerCase();
			db.updateSQL("INSERT INTO players(uuid, name, tokens, xp) VALUES ('" + uuid + "', '"+name+"', '0', '0');");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

public static Integer getTokens(String uuid) throws SQLException, ClassNotFoundException {
	int vl = 0;
	ResultSet rs = db.querySQL("SELECT * FROM players WHERE uuid= '" + uuid + "';");
	if (!rs.next()) {
		;
	}
	vl = rs.getInt("tokens");
	return Integer.valueOf(vl);
}

public static Integer getXp(String uuid) throws SQLException, ClassNotFoundException {
	int valor = 0;
	ResultSet rs = db.querySQL("SELECT * FROM players WHERE uuid= '" + uuid + "';");
	if (!rs.next()) {
		;
	}
	valor = rs.getInt("xp");
	return Integer.valueOf(valor);
}

public static void setTokens(String uuid, Integer valor) throws ClassNotFoundException, SQLException {
	db.updateSQL("UPDATE players SET tokens= '" + valor + "' WHERE uuid= '" + uuid + "';");
}

public static void setXp(String uuid, Integer valor) throws ClassNotFoundException, SQLException {
	db.updateSQL("UPDATE jogadores SET xp= '" + valor + "' WHERE uuid= '" + uuid + "';");
}


public static void addTokens(String uuid, Integer valor){
	try {
		setTokens(uuid, getTokens(uuid)+valor);
	} catch (SQLException | ClassNotFoundException e) {
		Bukkit.getConsoleSender().sendMessage("Um erro aconteceu ao adicionar xp");
		e.printStackTrace();
	}
}


public static void addXp(String uuid, Integer valor){
	try {
		setXp(uuid, getXp(uuid)+valor);
	} catch (SQLException | ClassNotFoundException e) {
		Bukkit.getConsoleSender().sendMessage("Um erro aconteceu ao adicionar xp");
		e.printStackTrace();
	}
}

/*
 * 
 * returna
 * 
 */
public static boolean removeXP(String uuid, Integer quantidade) throws ClassNotFoundException, SQLException {
	if (getXp(uuid) >= quantidade) {
		setXp(uuid, getXp(uuid) - quantidade);
		return true;
	} else {
		return false;
	}

}









public static void closeDB() {
	try {
		db.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}