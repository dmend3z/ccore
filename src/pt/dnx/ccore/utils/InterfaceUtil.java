package pt.dnx.ccore.utils;

import org.bukkit.entity.Player;

public abstract class InterfaceUtil
{

    public abstract String getName();
    public abstract void open(Player p);
    public abstract void click(Player p, int slot);

}

