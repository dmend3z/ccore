package pt.dnx.ccore.utils;

import org.bukkit.entity.Player;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class CooldownUtil
{
    private static Table<String, String, Long> cooldowns = HashBasedTable.create();

    public static float getCooldown(Player player, String key)
    {
        return (float)calculateRemainder((Long)cooldowns.get(player.getName(), key));
    }

    public static long setCooldown(Player player, String key, long delay)
    {
        return calculateRemainder(
                (Long)cooldowns.put(player.getName(), key, Long.valueOf(System.currentTimeMillis() + delay)));
    }

    public static boolean tryCooldown(Player player, String key, long delay)
    {
        if (getCooldown(player, key) <= 0.0F)
        {
            setCooldown(player, key, delay);
            return true;
        }
        return false;
    }

    private static long calculateRemainder(Long expireTime)
    {
        return expireTime != null ? expireTime.longValue() - System.currentTimeMillis() : Long.MIN_VALUE;
    }
}


