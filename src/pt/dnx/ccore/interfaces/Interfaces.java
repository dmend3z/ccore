package pt.dnx.ccore.interfaces;

import pt.dnx.ccore.interfaces.whitelist.WhitelistInterface;
import pt.dnx.ccore.interfaces.whitelist.WhitelistedPlayersInterface;

public class Interfaces {

	 private static WhitelistInterface whitelistInterface = new WhitelistInterface();
	  private static WhitelistedPlayersInterface whitelistedPlayersInterface = new WhitelistedPlayersInterface();
	  
	  public static WhitelistInterface getWhitelistInterface()
	  {
	    return whitelistInterface;
	  }
	  
	  public static WhitelistedPlayersInterface getWhitelistedPlayersInterface()
	  {
	    return whitelistedPlayersInterface;
	  }
	}
