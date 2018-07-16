package pt.dnx.ccore.players;

import org.bukkit.entity.Player;

public enum Rank
{

	DONO("§4[DONO] ", 1, "dono"),
	ADMIN("§c[ADMIN]§r ", 2, "admin"),
    GERENTE("§6[GERENTE]§r ",3, "gerente"),
    MOD("§5[MOD]§r ",4, "mod"),
    AJUDANTE("§9[AJUDANTE]§r ",5, "ajudante"),
    YOUTUBER("§c[YT]§r ",6, "youtuber"),
    BETA("§e[BETA]§r ",7, "beta"),
    MVPP("§d[MVP+]§r ",8, "mvpp"),
    MVP("§b[MVP]§r ",9, "mvp"),
    VIP("§a[VIP]§r ", 99, "vip"),
    NORMAL("§7",999, "");
    
    String tag;
    String nome;
    int position;
    
    private Rank(String tag, int position, String nome) {
        this.tag = tag;
        this.position = position;
        this.nome = nome;
    }
    
    public String getNome() {
		return nome;
	}

	public int getPosition() {
		return this.position;
	}
	
	public String getTag() {
		return this.tag;
	}
	
	public static Rank getRank(Player p) {
		if(p.hasPermission("rank.dono")) {
			return DONO;
		}else if(p.hasPermission("rank.admin")) {
			return ADMIN;
		}else if(p.hasPermission("rank.gerente")) {
			return GERENTE;
		}else if(p.hasPermission("rank.mod")) {
			return MOD;
		}else if(p.hasPermission("rank.ajudante")) {
			return AJUDANTE;
		}else if(p.hasPermission("rank.youtuber")) {
			return Rank.YOUTUBER;
		}else if(p.hasPermission("rank.beta")) {
			return BETA;
		}else if(p.hasPermission("rank.mvpp")) {
			return MVPP;
		}else if(p.hasPermission("rank.mvp")) {
			return Rank.MVP;
		}else if(p.hasPermission("rank.vip")) {
			return Rank.VIP;
		}else{
			return Rank.NORMAL;
		}
	}
}